package com.example.user.partyapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;

/**
 * Created by lasse on 14-Nov-17.
 */

public class DrawingView extends View {
    private Bitmap bitmap; //Area used for drawing
    private Canvas canvas; //Used to draw on bitmap
    private Paint showDrawing; //Used to show drawing
    private Paint drawingTool; //Used to draw on bitmap
    private HashMap<Integer, Path> pathMap; // current Paths being drawn
    private HashMap<Integer, Point> previousPointMap; // current Points

    public void killsomething(){
        canvas = new Canvas();

    }
    public DrawingView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        showDrawing = new Paint();

        //Define drawing tool, makes the strokes black, sets its width to 2, round edges for lines.
        drawingTool = new Paint();
        drawingTool.setColor(Color.BLACK);
        drawingTool.setStyle(Paint.Style.STROKE);
        drawingTool.setStrokeWidth(15);
        drawingTool.setStrokeCap(Paint.Cap.ROUND);

        pathMap = new HashMap<Integer, Path>();
        previousPointMap = new HashMap<Integer, Point>();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, showDrawing);
        for (Integer key : pathMap.keySet()){
            canvas.drawPath(pathMap.get(key), drawingTool);
        }
    }

    //Creates the canvas, retrieves with, height etc from layout
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        bitmap = Bitmap.createBitmap(getWidth(), getHeight(),
                Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        bitmap.eraseColor(Color.WHITE); // erase the BitMap with white
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction(); //Contains an integer that defines the type of action
        int actionIndex = event.getActionIndex(); //Is used to get the id of the pointer?

        boolean touched = action == MotionEvent.ACTION_DOWN; //MotionEvent.ACTION_POINTER_DOWN ||
        boolean released = action == MotionEvent.ACTION_UP; //MotionEvent.ACTION_POINTER_UP ||

        if(touched){
            Log.d("Touch", "Touched");
            drawSequenceStart(event.getX(), event.getY(), event.getPointerId(actionIndex));
        }
        else if(released){
            Log.d("Touch", "Stopped touching");
            drawSequenceEnd(event.getPointerId(actionIndex));
        }
        else{
            Log.d("Touch", "Touching");
            drawSequence(event);
        }

        invalidate();
        return true; //return super.onTouchEvent(event);
    }


    private void drawSequenceStart(float x, float y, int pointerId){
        Path path;
        Point point;

        if(pathMap.containsKey(pointerId)){
            path = pathMap.get(pointerId);
            path.reset();
            point = previousPointMap.get(pointerId);
            previousPointMap.put(pointerId, point);
        }
        else{
            path = new Path();
            pathMap.put(pointerId, path);
            point = new Point();
            previousPointMap.put(pointerId, point);
        }

        path.moveTo(x,y);
        //This differs from example
        point.set((int)x,(int)y);
    }

    private void drawSequence(MotionEvent dragEvent){
        //For as many points the user drags his fingers, do this:
        for(int i = 0; i<dragEvent.getPointerCount(); i++){
            int pointerId = dragEvent.getPointerId(i);
            int pointerIndex = dragEvent.findPointerIndex(pointerId);
            if(pathMap.containsKey(pointerIndex)){
                connectPoints(pointerId, dragEvent.getX(pointerIndex), dragEvent.getY(pointerIndex));
            }
        }
    }

    private void connectPoints(int pointerId, float x, float y){
        Path path = pathMap.get(pointerId);
        Point point = previousPointMap.get(pointerId);

        if(significantTouch(x,y,point)){
            //move path
            path.quadTo(point.x, point.y, (x+point.x)/2, (y+point.y)/2);
            //store coordinates
            point.set((int)x,(int)y);
        }
    }

    private boolean significantTouch(float x, float y, Point point){
        float significantTouch = 10;
        float dX = difference(x, point.x); //The distance between current and past x val
        float dY = difference(y, point.y); //The distance between current and past y val
        return dX >= significantTouch || dY >= significantTouch;
    }

    private float difference(float a, float b){
         return Math.abs(a-b);
    }

    private void drawSequenceEnd(int pointerId){
        Path path = pathMap.get(pointerId);
        canvas.drawPath(path, drawingTool);
        path.reset();
    }

}



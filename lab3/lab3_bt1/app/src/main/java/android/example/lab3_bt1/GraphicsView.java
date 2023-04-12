package android.example.lab3_bt1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends  View{
    int x=0;
    int y=0;
    int d=100;
    int r=50;
    int i=0;
    Bitmap[] frames= new Bitmap[16];

    public GraphicsView(Context context)
    {
        super (context);

        frames[0]= BitmapFactory.decodeResource(getResources(),R.drawable.anh1);
        frames[1]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[2]= BitmapFactory.decodeResource(getResources(),R.drawable.anh3);
        frames[3]= BitmapFactory.decodeResource(getResources(),R.drawable.anh4);
        frames[4]= BitmapFactory.decodeResource(getResources(),R.drawable.anh1);
        frames[5]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[6]= BitmapFactory.decodeResource(getResources(),R.drawable.anh3);
        frames[7]= BitmapFactory.decodeResource(getResources(),R.drawable.anh4);
        frames[8]= BitmapFactory.decodeResource(getResources(),R.drawable.anh1);
        frames[9]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[10]= BitmapFactory.decodeResource(getResources(),R.drawable.anh3);
        frames[11]= BitmapFactory.decodeResource(getResources(),R.drawable.anh4);
        frames[12]= BitmapFactory.decodeResource(getResources(),R.drawable.anh1);
        frames[13]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[14]= BitmapFactory.decodeResource(getResources(),R.drawable.anh3);
        frames[15]= BitmapFactory.decodeResource(getResources(),R.drawable.anh4);

    }
    @Override
    protected void onDraw(Canvas canvas) {
// bai 1
/*
        Rect r=new Rect(40,40,400,200);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(r, paint);
        invalidate();
*/
//bai 2

        if (x != 0 && y != 0) {
            int right = x + d;
            int bottom = y + r;
            Rect r = new Rect(x, y, right, bottom);

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.RED);
            canvas.drawRect(r, paint);
        }
        invalidate();
    }
         @Override
    public boolean onTouchEvent(MotionEvent event){
        x=(int)event.getX();
        y=(int )event.getY();
        return super.onTouchEvent(event);
    }

        /*
if(i<16){
    canvas.drawBitmap(frames[i],40,40,new Paint(), new Size(original.Width/4,original.Height/4));

}
else {
    i=0;
}
invalidate();
        }*/
/*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        x=(int)event.getX();
        y=(int )event.getY();
        return super.onTouchEvent(event);
    }*/
}

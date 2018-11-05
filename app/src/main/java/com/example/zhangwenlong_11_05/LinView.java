package com.example.zhangwenlong_11_05;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.RotateAnimation;

public class LinView extends View implements View.OnClickListener {

    private Paint mPaint;
    private int mX;
    private int mY;
    private boolean flag;
   // private int[] ColorA=new int[]{Color.GRAY,Color.MAGENTA,Color.DKGRAY,Color.LTGRAY,Color.BLUE,Color.GREEN};
    private RotateAnimation rotateAnimation;
    private String[] TextA = new String[]{"事件一", "事件二", "事件三", "事件四", "事件五", "事件六"};
    private int color, color1, color2, color3, color4, color5;
    private Integer[] ColorA = new Integer[]{color, color1, color2, color3, color4, color5};

    public LinView(Context context) {
        this(context, null);
    }

    public LinView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public LinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取屏幕信息
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        //getResources().getStringArray()
        //获取屏幕的宽高
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        //得到宽高的一半
        mX = widthPixels / 2;
        mY = heightPixels / 2;
        //初始化画笔
        initPaint();
        //初始化旋转
        initAmn();
        //设置点击事件
        this.setOnClickListener(this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LinView);
        color = typedArray.getColor(R.styleable.LinView_title_color, 0);
        color1 = typedArray.getColor(R.styleable.LinView_title_color1, 0);
        color2 = typedArray.getColor(R.styleable.LinView_title_color2, 0);
        color3 = typedArray.getColor(R.styleable.LinView_title_color3, 0);
        color4 = typedArray.getColor(R.styleable.LinView_title_color4, 0);
        color5 = typedArray.getColor(R.styleable.LinView_title_color5, 0);


    }

    private void initAmn() {
        //获取RotateAnimation对象
        rotateAnimation = new RotateAnimation(0, 360, mX, mY);
        //设置旋转时间
        rotateAnimation.setDuration(2000);

    }

    private void initPaint() {
        mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔样式
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //平移原点到屏幕中心
        canvas.translate(mX, mY);
        //设置大圆对应的矩形
        RectF rectF = new RectF(-300, -300, 300, 300);
        //画圆弧
      //  for (int i = 0; i < 6; i++) {
            //给圆弧设置颜色
            //  mPaint.setColor(ColorA[i]);


            if (color !=-1  ) {
                mPaint.setColor(color);
                canvas.drawArc(rectF, 60 * 0, 60, true, mPaint);
            }
            if (color1 !=-1  ) {
                mPaint.setColor(color1);
                canvas.drawArc(rectF, 60 * 1, 60, true, mPaint);
            }
            if (color2 !=-1  ) {
                mPaint.setColor(color2);
                canvas.drawArc(rectF, 60 * 2, 60, true, mPaint);
            }
            if (color3 !=-1  ) {
                mPaint.setColor(color3);
                canvas.drawArc(rectF, 60 * 3, 60, true, mPaint);
            }if (color4 !=-1  ) {
                mPaint.setColor(color4);
                canvas.drawArc(rectF, 60 * 4, 60, true, mPaint);
            }
            if (color5 !=-1 ) {
                mPaint.setColor(color5);
                canvas.drawArc(rectF, 60 * 5, 60, true, mPaint);
            }


            //画圆弧
         //   canvas.drawArc(rectF, 60 * i, 60, true, mPaint);
    //    }
        //给小圆设置颜色
        mPaint.setColor(Color.RED);
        //画小圆
        canvas.drawCircle(0, 0, 100, mPaint);
        //设置文字大小及颜色
        mPaint.setTextSize(40);
        mPaint.setColor(Color.WHITE);
        //给小圆写文字
        Rect rect = new Rect();
        mPaint.getTextBounds("start", 0, 5, rect);
        //获取字体的宽高
        int width = rect.width();
        int height = rect.height();
        //设置字体zwl15901304107
        canvas.drawText("start", -width / 2, height / 2, mPaint);

        //给大圆写文字
        RectF rectF1 = new RectF(-200, -200, 200, 200);
        for (int a = 0; a < 6; a++) {
            //设置字体位置
            Path path = new Path();
            path.addArc(rectF1, 60 * a + 15, 60);
            //设置圆弧字体
            canvas.drawTextOnPath(TextA[a], path, 0, 0, mPaint);
        }
    }

    //设置停止转盘的方法
    public void stopView() {
        flag = false;
        clearAnimation();
    }

    //设置开始转盘的方法
    public void startView() {
        flag = true;
        startAnimation(rotateAnimation);
    }

    //点击事件的方法
    @Override
    public void onClick(View v) {

        if (flag) {
            stopView();
        } else {
            startView();
        }
    }


  /*  private GetData getData;
    public void Daer(GetData getData){
        this.getData = getData;
    }
    public interface GetData{
        void Data(View str);
    }*/
}

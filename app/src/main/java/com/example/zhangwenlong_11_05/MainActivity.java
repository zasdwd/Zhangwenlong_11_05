package com.example.zhangwenlong_11_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        toolbar = findViewById(R.id.toolbar_m);
        //设置左边图片
        setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayShowTitleEnabled(true);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //设置点击监听
       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            //   Toast.makeText(MainActivity.this,"你好",Toast.LENGTH_SHORT).show();
               //返回
               MainActivity.this.finish();
           }
       });




    }
}

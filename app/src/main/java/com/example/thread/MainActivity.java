package com.example.thread;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     TextView display ;
    Button btn ;
    Thread t1 ;
    MyHandler h ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.display) ;
        btn = (Button) findViewById(R.id.btn) ;

        h = new MyHandler() ;

    }

      public void click (View view)  {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<11 ;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    int finalI = i;
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            display.setText(String.valueOf(finalI));
                        }
                    });

                }

            }
        });
        t1.start();



      }


      class MyHandler extends Handler {
          public void handlerMessage(@NonNull Message msg) {
              super.handleMessage(msg);

          }

      }





}
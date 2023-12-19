package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    Button download ;
    ProgressBar progressBar;
    TextView display ;

    MyTask  m ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        download = (Button) findViewById(R.id.download);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        display = (TextView) findViewById(R.id.dis);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask m = new MyTask() ;
                m.execute() ;


            }
        });



    }
    class MyTask extends AsyncTask<String, Integer, Void> {




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            display.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressBar.setVisibility(View.GONE);
            display.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.incrementProgressBy(10);
            display.setText(progressBar.getProgress() + "/" + 100);
        }


        @Override
        protected Void doInBackground(String... strings) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                publishProgress();

            }
            return null;
        }
    }


}

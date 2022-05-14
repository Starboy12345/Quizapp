package com.example.quizgame;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    MyReceiver brodcastreceiver = new MyReceiver();
    String topicname="";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        final LinearLayout java =findViewById(R.id.javalayout);
        final LinearLayout html =findViewById(R.id.htmllayout);
        final LinearLayout css =findViewById(R.id.csslayout);
        final LinearLayout kotlin =findViewById(R.id.kotlinlayout);
        final Button startbtn =findViewById(R.id.startbtn);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="java";
                java.setBackgroundResource(R.drawable.greenborderhiglight);
                html.setBackgroundResource(R.drawable.round);
                css.setBackgroundResource(R.drawable.round);
                kotlin.setBackgroundResource(R.drawable.round);

            }
        });

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="html";
                java.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.greenborderhiglight);
                css.setBackgroundResource(R.drawable.round);
                kotlin.setBackgroundResource(R.drawable.round);
            }
        });

        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="css";
                java.setBackgroundResource(R.drawable.round);
               css.setBackgroundResource(R.drawable.greenborderhiglight);
               html.setBackgroundResource(R.drawable.round);
                kotlin.setBackgroundResource(R.drawable.round);
            }
        });

        kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="kotlin";
                kotlin.setBackgroundResource(R.drawable.greenborderhiglight);
                css.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.round);
                java.setBackgroundResource(R.drawable.round);

            }
        });

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (topicname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Choose a topic first", Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent = new Intent (MainActivity.this,game.class);
                    intent.putExtra("topicname",topicname);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(brodcastreceiver,intentFilter);
        Log.d(TAG, "onStart: ");
    }
    

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(brodcastreceiver);
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}


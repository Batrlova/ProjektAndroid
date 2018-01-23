package com.example.diana.myapplicationengtester;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public AlertDialog.Builder dlgAlert;
    private Button btVyber;
    private Button btAbout;
    private Button btClose;
    String results="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btVyber = (Button) findViewById(R.id.btVyber);
        btVyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityVyber();
            }
        });
        btAbout = (Button) findViewById(R.id.btAbout);
        btAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityMain2();
            }
        });

        btClose = (Button) findViewById(R.id.btClose);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void openActivityVyber() {
        Intent intVyber = new Intent(this, ActivityVyber.class);
        startActivity(intVyber);
    }

    private void openActivityMain2() {
        Intent intScore = new Intent(this, Main2Activity.class);
        startActivity(intScore);
    }

}

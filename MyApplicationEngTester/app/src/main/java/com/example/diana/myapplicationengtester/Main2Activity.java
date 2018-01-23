package com.example.diana.myapplicationengtester;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {
    public AlertDialog.Builder dlgAlert;
    private EditText t;
    private Button btExit;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        t =(EditText) findViewById(R.id.et);

        String filename = "ResultsTesterEn";
        try {
            FileInputStream inputStream = openFileInput(filename);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            r.close();
            inputStream.close();
            result =total.toString();

            //Log.d("File", "File contents: " + total);
        } catch (Exception e) {
            e.printStackTrace();
        }

        t.setText(result);

        btExit = (Button) findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               closeMain2();
            }
        });

    }
    private void closeMain2()
    {
        finish();
    }

}

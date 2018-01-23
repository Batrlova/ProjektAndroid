package com.example.diana.myapplicationengtester;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.diana.myapplicationengtester.api.ApiClient;
import com.example.diana.myapplicationengtester.api.ApiInterface;
import com.example.diana.myapplicationengtester.api.pojo.ResponseData;
import com.example.diana.myapplicationengtester.api.pojo.ResponseTranslator;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityVyber extends AppCompatActivity {

    public String data1;
    public String data2;
    public String data3;

    public AlertDialog.Builder dlgAlert;
    public String data;
    private Button btExit;
    private TextView textView;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button bI1;
    private Button bI2;
    private Button bI3;
    private Button bI4;
    private Button next;
    private boolean priznak = false;
    private int number=0;
    private int correctAnswers =0;
    String [] slova = {"Slon","Auto","Svět","Vítěz","Letadlo","Bunda","Krabice","Zodpovědnost","Bazén","Koleno"};
    String[][] odpovedi = {{"Elephant","Tiger","Elevator","Monkey"},
            {"Bike","Car","Carry","Transport"},
            {"Word","World","Country","Land"},
            {"Winner","Loser","Victory","Weekend"},
            {"Sky","Aeroplane","Airport","Truck"},
            {"Hoodie","Shirt","Hijack","Jacket"},
            {"Cube","Bottom","Box","Table"},
            {"Responsibility","Ability","Reliability","Creativity"},
            {"River","Pool","Liver","Wool"},
            {"Ankle","Thigh","Elbow","Knee"}};
    int [] odpovediInt = {0,1,1,0,1,3,2,0,1,3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyber);

       textView =(TextView)findViewById(R.id.tvSlovo);
        b1 =(Button)findViewById(R.id.bt1);
        b2 =(Button)findViewById(R.id.bt2);
        b3 =(Button)findViewById(R.id.bt3);
        b4 =(Button)findViewById(R.id.bt4);
        bI1 =(Button)findViewById(R.id.btInf1);
        bI2 =(Button)findViewById(R.id.btInf2);
        bI3 =(Button)findViewById(R.id.btInf3);
        bI4 =(Button)findViewById(R.id.btInf4);
        next = (Button)findViewById(R.id.btNext);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater= LayoutInflater.from(this);
        final View scrollV=inflater.inflate(R.layout.scroll_activity, null);

        fillValues(number);
        next.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                if(number == 9)
                {
                    dlgAlert.setMessage("Celkem spravnych odpovedi: " + correctAnswers);
                    dlgAlert.setTitle("Hodnoceni");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                    String formattedDate = df.format(c.getTime());

                    String filename = "ResultsTesterEn";
                    String string = "Datum: "+formattedDate+"  "+ "Skore: " + String.valueOf(correctAnswers)+ "\n\r";


                    try {
                        FileOutputStream outputStream = openFileOutput(filename, Context.MODE_APPEND);
                        outputStream.write(string.getBytes());
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    if(priznak) {
                        next.setVisibility(View.INVISIBLE);
                        number++;
                        fillValues(number);
                        priznak = false;
                        b1.setTextColor(0xff000000);
                        b2.setTextColor(0xff000000);
                        b3.setTextColor(0xff000000);
                        b4.setTextColor(0xff000000);
                        for(int i=0; i<4;i++) {
                            ApiInterface apiService =
                                    ApiClient.getClient().create(ApiInterface.class);
                            Call<ResponseTranslator> call = apiService.getDescription(odpovedi [number][i], true);
                            call.enqueue(new MyCall(odpovedi [number][i]));
                        }

                    }
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!priznak)
                {
                    next.setVisibility(View.VISIBLE);
                    priznak=true;
                    if(odpovedi[number][0]==odpovedi[number][odpovediInt[number]])
                    {
                        b1.setTextColor(0xff99cc00);
                        correctAnswers++;
                    }else
                    {
                        b1.setTextColor(0xFFFF055A);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                if (!priznak)
                {
                    next.setVisibility(View.VISIBLE);
                    priznak=true;
                    if (odpovedi[number][1] == odpovedi[number][odpovediInt[number]]) {
                        b2.setTextColor(0xff99cc00);
                        correctAnswers++;
                    } else {
                        b2.setTextColor(0xFFFF055A);
                    }
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!priznak)
                {
                    next.setVisibility(View.VISIBLE);
                    priznak=true;
                    if (odpovedi[number][2] == odpovedi[number][odpovediInt[number]]) {
                        b3.setTextColor(0xff99cc00);
                        correctAnswers++;
                    } else {
                        b3.setTextColor(0xFFFF055A);
                    }
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!priznak)
                {
                    next.setVisibility(View.VISIBLE);
                    priznak=true;
                    if (odpovedi[number][3] == odpovedi[number][odpovediInt[number]]) {
                        b4.setTextColor(0xff99cc00);
                        correctAnswers++;
                    } else {
                        b4.setTextColor(0xFFFF055A);
                    }
                }
            }
        });


        bI1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dlgAlert.setMessage(data);
                dlgAlert.setTitle(b1.getText().toString());
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        });

        bI2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dlgAlert.setMessage(data1);
                dlgAlert.setTitle(b2.getText().toString());
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        });

        bI3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dlgAlert.setMessage(data2);
                dlgAlert.setTitle(b3.getText().toString());
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        });

        bI4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dlgAlert.setMessage(data3);
                dlgAlert.setTitle(b4.getText().toString());
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        });

        btExit = (Button) findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeActivityVyber();
            }
        });

        dlgAlert= new AlertDialog.Builder(this);
        for(int i=0; i<4;i++) {
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);
            Call<ResponseTranslator> call = apiService.getDescription(odpovedi [number][i], true);
            call.enqueue(new MyCall(odpovedi [number][i]));
        }


    }

    private class MyCall implements Callback<ResponseTranslator>
    {
        private String mTranslatedText;
        private MyCall(String extract) {
            mTranslatedText = extract;
        }
        @Override
        public void onResponse(Call<ResponseTranslator> call,
                               Response<ResponseTranslator> response) {
            System.out.println("onResponse");

            if(mTranslatedText == b1.getText().toString())
                data = response.body().getResponseData();
            if(mTranslatedText == b2.getText().toString())
                data1 = response.body().getResponseData();
            if(mTranslatedText == b3.getText().toString())
                data2 = response.body().getResponseData();
            if(mTranslatedText == b4.getText().toString())
                data3 = response.body().getResponseData();
        }
        @Override
        public void onFailure(Call<ResponseTranslator> call, Throwable t) {
            textView.setText(t.getMessage());
            System.out.println("onFailure");
            t.printStackTrace();

        }
    }

    private void fillValues(int number)
    {
        textView.setText(slova[number]);
        b1.setText(odpovedi [number][0]);
        b2.setText(odpovedi [number][1]);
        b3.setText(odpovedi [number][2]);
        b4.setText(odpovedi [number][3]);
    }

        private void closeActivityVyber()
    {
        finish();
    }
}

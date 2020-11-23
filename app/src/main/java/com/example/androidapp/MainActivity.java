package com.example.androidapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.textView);
        txt2=(TextView) findViewById(R.id.textView2);
        txt3=(TextView) findViewById(R.id.textView3);
        txt4=(TextView) findViewById(R.id.textView4);
        txt5=(TextView) findViewById(R.id.textView5);
        btn=(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                txt.setText("This is the first application from Group 4");
                txt2.setText("Kristers Veveris 1");
                txt3.setText("Toms Baugis 2");
                txt5.setText("Artis Taurins 3");
                txt4.setText(" Developed by Kristers Veveris 1");
            }
        });
    }
}
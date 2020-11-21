package com.example.androidapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final TextView tv1 = (TextView)findViewById(R.id.firstLine);
        final TextView tv2 = (TextView)findViewById(R.id.secondLine);
        final TextView tv3 = (TextView)findViewById(R.id.thirdLine);
        final TextView tv4 = (TextView)findViewById(R.id.fourthLine);
        final TextView tv5 = (TextView)findViewById(R.id.fifthLine);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv1.setText("This is the first application from Group 4:");
                tv2.setText("Toms Bauģis");
                tv3.setText("Artis Tauriņš");
                tv4.setText("Kristers Vēveris");
                tv5.setText("And the application was developed by Artis");
            }
        });
    }
}
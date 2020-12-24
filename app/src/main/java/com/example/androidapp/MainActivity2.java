package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.androidapp.MainActivity.TEXT;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private Button buttonReadPrefs;
    private TextView showPref;

    public static final String TEXT = "text";

    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showPref = (TextView) findViewById(R.id.editTextTextPersonName2);
        buttonReadPrefs = (Button) findViewById(R.id.buttonReadPref);
        button = (Button) findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonReadPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
                updateViews();
                if(text.length() == 0){
                   Toast.makeText(MainActivity2.this, "Nothing found", Toast.LENGTH_SHORT).show();
                } else {
                    showPref.setText(text);
                }
            }
        });
    }

    public void loadData(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        text = sharedPreferences.getString(TEXT, "");
    }

    public void updateViews() {
        showPref.setText(text);
    }
}
package com.example.androidapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    boolean buttonIsPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView groupName = findViewById(R.id.groupName1);
        final TextView participant1 = findViewById(R.id.participant1);
        final TextView participant2 = findViewById(R.id.participant2);
        final TextView participant3 = findViewById(R.id.participant3);
        final TextView appDev = findViewById(R.id.appDev1);
        final Button button = findViewById(R.id.button);
        button.setText("Show group information");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!buttonIsPressed) {
                    groupName.setText("This is the first application from Group: 4");
                    participant1.setText("First participant: Toms Bauģis");
                    participant2.setText("Second participant: Kristers Vēveris");
                    participant3.setText("Third participant: Artis Tauriņš");
                    appDev.setText("The application was developed by : Toms Bauģis");
                    button.setText("Stop showing group information");
                    buttonIsPressed = true;
                } else {
                    groupName.setText("");
                    participant1.setText("");
                    participant2.setText("");
                    participant3.setText("");
                    appDev.setText("");
                    button.setText("Show group information");
                    buttonIsPressed = false;
                }
            }
        });
    }
}
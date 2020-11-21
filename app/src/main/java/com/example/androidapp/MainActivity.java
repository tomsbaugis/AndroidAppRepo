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
        final TextView groupName = (TextView)findViewById(R.id.groupName1);
        final TextView participant1 = (TextView)findViewById(R.id.participant1);
        final TextView participant2 = (TextView)findViewById(R.id.participant2);
        final TextView participant3 = (TextView)findViewById(R.id.participant3);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                groupName.setText("Group number: 4");
                participant1.setText("First participant: Toms Bauģis");
                participant2.setText("Second participant: Kristers Vēveris");
                participant3.setText("Third participant: Artis Tauriņš");
            }
        });
    }
}
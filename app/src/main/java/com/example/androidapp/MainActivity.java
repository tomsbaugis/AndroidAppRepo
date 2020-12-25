package com.example.androidapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private double number1;
    private double number2;
    private double result;

    public static final String RESULT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sumButton = findViewById(R.id.btnSum);
        Button subtractButton = findViewById(R.id.btnSubtract);
        Button multiplyButton = findViewById(R.id.btnMultiply);
        Button divideButton = findViewById(R.id.btnDivide);
        Button getResultButton = findViewById(R.id.btnResult);
        Button saveResultToMemory = findViewById(R.id.btnSave);
        Button readResultFromMemory = findViewById(R.id.btnRead);
        Button clearMemory = findViewById(R.id.btnClear);
        final TextView outPut = findViewById(R.id.result);
        final TextView firstNumber = findViewById(R.id.number1);
        final TextView secondNumber = findViewById(R.id.number2);

        sumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (firstNumber.getText().toString().equals("") || secondNumber.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both numbers",Toast.LENGTH_SHORT).show();
                } else {
                    String numberValue = firstNumber.getText().toString();
                    number1 = Double.parseDouble(numberValue);
                    String numberValue2 = secondNumber.getText().toString();
                    number2 = Double.parseDouble(numberValue2);
                    result = number1 + number2;
                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (firstNumber.getText().toString().equals("") || secondNumber.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both numbers",Toast.LENGTH_SHORT).show();
                } else {
                    String numberValue = firstNumber.getText().toString();
                    number1 = Double.parseDouble(numberValue);
                    String numberValue2 = secondNumber.getText().toString();
                    number2 = Double.parseDouble(numberValue2);
                    result = number1 - number2;
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (firstNumber.getText().toString().equals("") || secondNumber.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both numbers",Toast.LENGTH_SHORT).show();
                } else {
                    String numberValue = firstNumber.getText().toString();
                    number1 = Double.parseDouble(numberValue);
                    String numberValue2 = secondNumber.getText().toString();
                    number2 = Double.parseDouble(numberValue2);
                    result = number1 * number2;
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (firstNumber.getText().toString().equals("") || secondNumber.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both numbers",Toast.LENGTH_SHORT).show();
                } else {
                    String numberValue = firstNumber.getText().toString();
                    number1 = Double.parseDouble(numberValue);
                    String numberValue2 = secondNumber.getText().toString();
                    number2 = Double.parseDouble(numberValue2);
                    result = number1 / number2;
                }
            }
        });

        getResultButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                outPut.setText("" + result);
            }
        });
        saveResultToMemory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(RESULT, String.valueOf(result));
                editor.apply();
                Toast.makeText(MainActivity.this, "Result: " + result + " saved to memory",Toast.LENGTH_SHORT).show();
            }
        });
        readResultFromMemory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
                String savedResult = sharedPreferences.getString(RESULT, "");
                if(savedResult.equals("")){
                    Toast.makeText(MainActivity.this, "No saved result",Toast.LENGTH_SHORT).show();
                } else {
                    double valueFromMemory = Double.parseDouble(savedResult);
                    firstNumber.setText("" + valueFromMemory);
                    secondNumber.setText("");
                    outPut.setText("");
                }
            }
        });
        clearMemory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().clear().apply();
                Toast.makeText(MainActivity.this, "Saved memory cleared",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
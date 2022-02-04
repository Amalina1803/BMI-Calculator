package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button info;
    private Button aboutbtn;

    //Declaring valuables
    EditText weight, height;
    TextView resultText;
    String calculation, BMIresult, HealthRisk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        info = (Button) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WeightInfo.class);
                startActivity(intent);
            }
        });

        aboutbtn = (Button) findViewById(R.id.aboutbtn);
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);
            }
        });


        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultText = findViewById(R.id.result);

    }

    public void calculateBMI(View view) {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2) / 100;

        //BMI calculation formula
        float bmi = weightValue / (heightValue * heightValue);

        //The categories
        if (bmi < 18.4){
            BMIresult = "Underweight";
            HealthRisk = "Malnutriton risk";
        }
        else if (bmi >= 18.5 && bmi <= 24.9){
            BMIresult = "Normal weight";
            HealthRisk = "Low risk";
        }
        else if (bmi >= 25 && bmi <= 29.9){
            BMIresult = "Overweight";
            HealthRisk = "Enhanced risk";
        }
        else if (bmi >= 30 && bmi <= 34.9){
            BMIresult = "Moderately Obese";
            HealthRisk = "Medium risk";
        }
        else if (bmi >= 35 && bmi <= 39.9){
            BMIresult = "Severely Obese";
            HealthRisk = "High risk";
        }
        else {
            BMIresult = "Very Severely Obese";
            HealthRisk = "Very high risk";
        }

        calculation = "BMI Result:\n\n" + bmi + "\n" + BMIresult +
        "\n\nHealth Risk: " + "\n" + HealthRisk;

        resultText.setText(calculation);
    }


}
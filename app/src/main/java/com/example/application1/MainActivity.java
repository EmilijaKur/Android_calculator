package com.example.application1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNum, inputSecondNum;
    private TextView textResult;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputFirstNum=findViewById(R.id.inputFirstNumber);
        inputSecondNum=findViewById(R.id.inputSecondNumber);
        btnPlus=findViewById(R.id.buttonPlus);
        btnMinus=findViewById(R.id.buttonMinus);
        btnMultiply=findViewById(R.id.buttonMultiply);
        btnDivide=findViewById(R.id.buttonDivide);
        textResult=findViewById(R.id.textResult);
        btnPlus.setOnClickListener(v -> Calculate("+"));
        btnMinus.setOnClickListener(v -> Calculate("-"));
        btnMultiply.setOnClickListener(v -> Calculate("*"));
        btnDivide.setOnClickListener(v -> Calculate("/"));


    }
    private void Calculate(String operation){
        String num1Text=inputFirstNum.getText().toString();
        String num2Text=inputSecondNum.getText().toString();
        if(num1Text.isEmpty()||num2Text.isEmpty()){
            textResult.setText("Please enter both numbers");
            return;
        }
        double num1=Double.parseDouble(num1Text);
        double num2=Double.parseDouble(num2Text);
        double result=0;

        switch(operation){
            case"+":
                result=num1+num2;
                break;
            case"-":
                result=num1-num2;
                break;
            case"*":
                result=num1*num2;
                break;
            case"/":
                if (num2 == 0) {
                    textResult.setText("Cannot divide by zero");
                    return;
                }
                result=num1/num2;
                break;
        }
        textResult.setText(String.format("%.2f", result));


    }
}
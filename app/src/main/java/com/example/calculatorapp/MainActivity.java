package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private double value1 = Double.NaN;
    private double value2;
    private char currentAction;
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        setNumericButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumericButtonListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String text = b.getText().toString();

                if (isNewOp) {
                    textViewResult.setText("");
                    isNewOp = false;
                }

                textViewResult.append(text);
            }
        };

        findViewById(R.id.btn0).setOnClickListener(listener);
        findViewById(R.id.btn1).setOnClickListener(listener);
        findViewById(R.id.btn2).setOnClickListener(listener);
        findViewById(R.id.btn3).setOnClickListener(listener);
        findViewById(R.id.btn4).setOnClickListener(listener);
        findViewById(R.id.btn5).setOnClickListener(listener);
        findViewById(R.id.btn6).setOnClickListener(listener);
        findViewById(R.id.btn7).setOnClickListener(listener);
        findViewById(R.id.btn8).setOnClickListener(listener);
        findViewById(R.id.btn9).setOnClickListener(listener);
    }

    private void setOperatorButtonListeners() {
        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                currentAction = '+';
//                textViewResult.setText(String.valueOf(value1));
                if (value1 == (long) value1) {
                    textViewResult.setText(String.format("%d", (long) value1));
                } else {
                    textViewResult.setText(String.format("%s", value1));
                }
                isNewOp = true;
            }
        });

        findViewById(R.id.btnSubtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                currentAction = '-';
//                textViewResult.setText(String.valueOf(value1));
                if (value1 == (long) value1) {
                    textViewResult.setText(String.format("%d", (long) value1));
                } else {
                    textViewResult.setText(String.format("%s", value1));
                }
                isNewOp = true;
            }
        });

        findViewById(R.id.btnMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                currentAction = '*';
//                textViewResult.setText(String.valueOf(value1));
                if (value1 == (long) value1) {
                    textViewResult.setText(String.format("%d", (long) value1));
                } else {
                    textViewResult.setText(String.format("%s", value1));
                }
                isNewOp = true;
            }
        });

        findViewById(R.id.btnDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                currentAction = '/';
//                textViewResult.setText(String.valueOf(value1));
                if (value1 == (long) value1) {
                    textViewResult.setText(String.format("%d", (long) value1));
                } else {
                    textViewResult.setText(String.format("%s", value1));
                }
                isNewOp = true;
            }
        });

        findViewById(R.id.btnEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
//                textViewResult.setText(String.valueOf(value1));
                if (value1 == (long) value1) {
                    textViewResult.setText(String.format("%d", (long) value1));
                } else {
                    textViewResult.setText(String.format("%s", value1));
                }
                value1 = Double.NaN;
                currentAction = '0';
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                textViewResult.setText("");
            }
        });
    }

    private void computeCalculation() {
        if (!Double.isNaN(value1)) {
            value2 = Double.parseDouble(textViewResult.getText().toString());

            switch (currentAction) {
                case '+':
                    value1 = value1 + value2;
                    break;
                case '-':
                    value1 = value1 - value2;
                    break;
                case '*':
                    value1 = value1 * value2;
                    break;
                case '/':
                    value1 = value1 / value2;
                    break;
            }
        } else {
            value1 = Double.parseDouble(textViewResult.getText().toString());
        }
    }
}

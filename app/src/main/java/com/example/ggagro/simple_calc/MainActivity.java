package com.example.ggagro.simple_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG: ";
    @BindView(R.id.edittext_main_first_number)
    EditText mFirstNumber;
    @BindView(R.id.edittext_main_second_number)
    EditText mSecondNumber;
    @BindView(R.id.button_main_add)
    Button mOperationAdd;
    @BindView(R.id.button_main_subtract)
    Button mOperationSubtract;
    @BindView(R.id.button_main_multiply)
    Button mOperationMultiply;
    @BindView(R.id.button_main_divide)
    Button mOperationDivide;
    @BindView(R.id.textview_main_result)
    TextView mResult;
    Double firstNumber;
    Double secondNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Locale.setDefault(new Locale("hr"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_main_add)
    public void add() {
        try {
            convertNumbers();
            double result = firstNumber + secondNumber;
            displayResult(result);
        } catch (Exception e) {
            showToast(e);
        }
    }

    @OnClick(R.id.button_main_subtract)
    public void subtract() {
        try {
            convertNumbers();
            double result = firstNumber - secondNumber;
            displayResult(result);
        } catch (Exception e) {
            showToast(e);
        }
    }


    @OnClick(R.id.button_main_multiply)
    public void multiply() {
        try {
            convertNumbers();
            double result = firstNumber * secondNumber;
            displayResult(result);
        } catch (Exception e) {
            showToast(e);
        }
    }

    @OnClick(R.id.button_main_divide)
    public void divide() {
        try {
            convertNumbers();
            double result = firstNumber / secondNumber;
            displayResult(result);
        } catch (Exception e) {
            showToast(e);
        }
    }

    private void convertNumbers() {
        try {
            firstNumber = null;
            secondNumber = null;
            firstNumber = Double.parseDouble(mFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(mSecondNumber.getText().toString());
        } catch (NumberFormatException e) {
            showToast(e);
        }
    }

    private void displayResult(double result) {
        mResult.setText(String.valueOf(result));
    }

    private void showToast(Exception e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}

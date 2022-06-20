package com.example.android_studio_lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NUMBER = "key_number";

    private EditText numberEditText;
    private Button operationButton;
    private TextView resultTextView;
    private Button showButton;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_NUMBER)){
            number = savedInstanceState.getInt(KEY_NUMBER);
        }

        showText();

        operationButton.setOnClickListener(v -> {
            number = Integer.parseInt(String.valueOf(numberEditText.getText()));
            number = number * number;
            showText();
        });

        showButton.setOnClickListener(v ->{
            Intent intent = SecondActivity.getIntentForLaunch(this, number);
            startActivity(intent);
        });
    }

    private void initView() {
        resultTextView = findViewById(R.id.result_text_view);
        operationButton = findViewById(R.id.operation_button);
        numberEditText = findViewById(R.id.number_edit_text);
        showButton = findViewById(R.id.show_button);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUMBER, number);
    }

    private void showText() {
        resultTextView.setText(String.valueOf(number));
    }
}
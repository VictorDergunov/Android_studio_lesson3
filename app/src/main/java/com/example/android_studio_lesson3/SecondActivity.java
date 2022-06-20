package com.example.android_studio_lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String NUMBER_EXTRA_KEY = "number_extra_key";

    private TextView numberTextView;
    private Button webButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();

        int number = getIntent().getExtras().getInt(NUMBER_EXTRA_KEY);
        numberTextView.setText(String.valueOf(number));
        }

    private void initView() {
        numberTextView = findViewById(R.id.number_text_view);
        webButton = findViewById(R.id.web_button);
    }
}

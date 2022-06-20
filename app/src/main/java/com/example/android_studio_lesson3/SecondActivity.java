package com.example.android_studio_lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        webButton.setOnClickListener(v ->{
            String url = "https://gb.ru";
            Uri uri = Uri.parse(url);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(webIntent);
        });
        }

    private void initView() {
        numberTextView = findViewById(R.id.number_text_view);
        webButton = findViewById(R.id.web_button);
    }
    public static Intent getIntentForLaunch(Context context, int number){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(NUMBER_EXTRA_KEY, number);
        return intent;
    }
}

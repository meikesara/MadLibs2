package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void goToFill(View view) {

        CheckBox checkbox = (CheckBox) view;
        Story clickedStory;
        String clickedText = (String) checkbox.getText();
        InputStream stream = getResources().openRawResource(R.raw.madlib1_tarzan);

        switch (clickedText) {
            case "Simple":
                stream = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case "Tarzan":
                stream = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case "University":
                stream = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case "Clothes":
                stream = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case "Dance":
                stream = getResources().openRawResource(R.raw.madlib4_dance);;
                break;
        }

        clickedStory = new Story(stream);

        Intent intent = new Intent(this, FillActivity.class);
        intent.putExtra("clicked_story", clickedStory);
        startActivity(intent);
        checkbox.setChecked(false);
    }
}
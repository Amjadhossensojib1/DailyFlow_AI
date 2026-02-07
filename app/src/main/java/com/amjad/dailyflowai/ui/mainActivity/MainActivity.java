package com.amjad.dailyflowai.ui.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.dailyflowai.R;
import com.amjad.dailyflowai.ui.homeFragment.HomeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            ArrayList<String> result =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            if (result != null && !result.isEmpty()) {
                homeFragment.onSpeechResult(result.get(0));
            }
        }
    }
}

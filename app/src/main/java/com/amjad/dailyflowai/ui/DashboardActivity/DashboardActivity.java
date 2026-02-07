package com.amjad.dailyflowai.ui.DashboardActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.amjad.dailyflowai.R;
import com.amjad.dailyflowai.ui.homeFragment.HomeFragment;

import com.amjad.dailyflowai.ui.addphotoFragment.AddPhotoFragment;


import com.amjad.dailyflowai.ui.seatingFragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    AddPhotoFragment addPhotoFragment = new AddPhotoFragment();
    SettingFragment settingFragment = new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // default fragment
        loadFragment(homeFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            loadFragment(homeFragment);
            return true;

        } else if (id == R.id.addphoto) {
            loadFragment(addPhotoFragment);
            return true;

        } else if (id == R.id.setting) {
            loadFragment(settingFragment);
            return true;
        }

        return false;
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }

    // speech result back to HomeFragment
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            ArrayList<String> result =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            Fragment fragment =
                    getSupportFragmentManager().findFragmentById(R.id.flFragment);

            if (fragment instanceof HomeFragment && result != null && !result.isEmpty()) {
                ((HomeFragment) fragment).onSpeechResult(result.get(0));
            }
        }
    }
}
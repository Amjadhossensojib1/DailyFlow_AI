package com.amjad.dailyflowai.utils;

import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;

public class SpeechManager {

    public static final int SPEECH_REQUEST_CODE = 100;

    public static void startListening(Activity activity) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        );

        activity.startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }
}

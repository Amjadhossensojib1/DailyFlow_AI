package com.amjad.dailyflowai.ui.homeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.amjad.dailyflowai.R;
import com.amjad.dailyflowai.utils.ApiClient;
import com.amjad.dailyflowai.utils.ChatRequest;
import com.amjad.dailyflowai.utils.ChatResponse;
import com.amjad.dailyflowai.utils.OpenAIService;
import com.amjad.dailyflowai.utils.SpeechManager;
import com.amjad.dailyflowai.utils.TTSManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    ImageView micBtn, aiIcon;
    TextView textView;
    TTSManager ttsManager;

    public HomeFragment() {
        // required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        micBtn = view.findViewById(R.id.mic_icon);
        aiIcon = view.findViewById(R.id.iv_aiicon);
        textView = view.findViewById(R.id.tv_aititle2);

        ttsManager = new TTSManager(requireContext());

        micBtn.setOnClickListener(v -> {
            aiIcon.animate().rotation(360).setDuration(800).start();
            SpeechManager.startListening(requireActivity());
        });

        return view;
    }

    public void onSpeechResult(String userText) {

        OpenAIService service =
                ApiClient.getClient().create(OpenAIService.class);

        List<ChatRequest.Message> messages = new ArrayList<>();
        messages.add(new ChatRequest.Message("system",
                "You are a friendly voice assistant. Ask questions."));
        messages.add(new ChatRequest.Message("user", userText));

        ChatRequest request = new ChatRequest(messages);

        service.getChatResponse(request).enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(Call<ChatResponse> call,
                                   Response<ChatResponse> response) {

                if (response.body() != null && response.body().choices != null) {
                    String aiText =
                            response.body().choices.get(0).message.content;

                    textView.setText(aiText);
                    ttsManager.speak(aiText);
                }
            }

            @Override
            public void onFailure(Call<ChatResponse> call, Throwable t) {
                textView.setText("Error: " + t.getMessage());
            }
        });
    }
}

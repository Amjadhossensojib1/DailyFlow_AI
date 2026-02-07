package com.amjad.dailyflowai.utils;

import java.util.List;

public class ChatRequest {

    public String model = "gpt-4o-mini";
    public List<Message> messages;

    public ChatRequest(List<Message> messages) {
        this.messages = messages;
    }

    public static class Message {
        public String role;
        public String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}

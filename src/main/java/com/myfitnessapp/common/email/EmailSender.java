package com.myfitnessapp.common.email;

public interface EmailSender {
    void send(String to, String subject, String msg);
}

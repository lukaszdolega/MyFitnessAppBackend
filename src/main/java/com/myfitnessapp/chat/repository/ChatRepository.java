package com.myfitnessapp.chat.repository;

import com.myfitnessapp.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}

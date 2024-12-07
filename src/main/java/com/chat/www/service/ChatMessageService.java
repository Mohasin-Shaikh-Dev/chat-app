package com.chat.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.www.model.ChatMessage;
import com.chat.www.repository.ChatRepository;

@Service
public class ChatMessageService {

	@Autowired
	ChatRepository chatRepository;
	public void saveMessage(ChatMessage message) {
	    chatRepository.save(message);
	}
	
}

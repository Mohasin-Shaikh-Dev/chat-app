package com.chat.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.www.model.ChatMessage;
import com.chat.www.service.ChatMessageService;

@Controller
public class ChatController {
	@Autowired
	private ChatMessageService chatMessageService;
	@MessageMapping("/sendmessage")
	@SendTo("/topic/message")
	public ChatMessage sendMessage( @RequestBody ChatMessage message)
	{
		chatMessageService.saveMessage(message);
		return message;
	}
	
	@GetMapping("/chat")
	public String chat()
	{
		return "chat";
	}
}

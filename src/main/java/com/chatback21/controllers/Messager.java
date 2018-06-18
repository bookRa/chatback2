package com.chatback21.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chatback21.pojos.converation.Conversation;
import com.chatback21.pojos.converation.Log;
import com.chatback21.pojos.converation.Message;
import com.chatback21.pojos.converation.MessagesItem;

@Controller
public class Messager {
	@RequestMapping(value = "chat", method = RequestMethod.POST)
	public void receive(Conversation conversation) {
		String timestamp = String.valueOf(conversation.getLog().getMessages().get(0).getMessage().getTimestamp());
		Logger.getAnonymousLogger().info(timestamp);
	}

	@RequestMapping(value = "chat", method = RequestMethod.GET)
	public Conversation retrieve(@RequestParam(defaultValue = "1") int index) {
		Conversation conversation = getConversation(index);
		return conversation;
	}

	private Conversation getConversation(int index) {
		// TODO:Call db
		List<Conversation> conversations = new ArrayList<>();

		conversations.add(Conversation.builder().id(123)
				.log(Log.builder()
						.messages(Collections.singletonList(
								MessagesItem.builder().message(Message.builder().text("text").build()).build()))
						.build())
				.build());

		return conversations.stream().filter(x -> x.getId() == index).findFirst().get();
	}
}

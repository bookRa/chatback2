package com.chatback.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class Messenger
{
    @RequestMapping(value = "chat", method = RequestMethod.POST)
    public void receive(Conversation conversation)
    {
        String timestamp = String.valueOf(conversation.getMessages().get(0).getMessage().getTimestamp());
        Logger.getAnonymousLogger().info(timestamp);
    }

    @RequestMapping(value = "chat", method = RequestMethod.GET)
    public Conversation retrieve(@RequestParam(defaultValue = "1") int index)
    {
        Conversation conversation = getConversation(index);
        return conversation;
    }
    private Conversation getConversation(int index)
    {
        //TODO:Call db
        List<Conversation> conversations = new ArrayList<>();
        return conversations.stream().filter(x->x.getId() == index).findFirst().get();
    }
}

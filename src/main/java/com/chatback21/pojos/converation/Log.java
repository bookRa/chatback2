package com.chatback21.pojos.converation;

import java.util.LinkedList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Log {

	private List<MessagesItem> messages = new LinkedList<>();

}
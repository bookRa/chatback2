package com.chatback21.pojos.converation;

import java.util.LinkedList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Conversation {

	private Log log;
	private int endTime;
	private List<ResponsesItem> responses = new LinkedList<>();
	private int id;
	private int startTime;

}
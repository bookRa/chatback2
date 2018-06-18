package com.chatback21.pojos.converation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

	private String name;
	private String text;
	private int timestamp;

}
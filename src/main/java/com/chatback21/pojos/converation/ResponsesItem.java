package com.chatback21.pojos.converation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsesItem {

	private String userB;
	private String userA;
	private String type;

}
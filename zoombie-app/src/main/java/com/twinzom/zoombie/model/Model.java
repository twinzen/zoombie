package com.twinzom.zoombie.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Model {

	public String toString() {
		ObjectMapper om = new ObjectMapper();
		String str = null;
		try {
			str = om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
}

package com.twinzom.zoombie.model;

import java.util.List;
import com.google.cloud.firestore.annotation.DocumentId;

public class User extends Model{

	@DocumentId
	String id;
	
	String name;
	
	String email;
	
	List<Meeting> meetings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}
	
}

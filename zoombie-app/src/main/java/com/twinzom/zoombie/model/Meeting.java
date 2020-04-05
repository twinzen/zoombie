package com.twinzom.zoombie.model;

import java.util.Date;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;

public class Meeting extends Model {

	@DocumentId
	String id;
	
	String topic;
	
	String creationAppCde;
	
	String launchAppCde;
	
	String participateId;
	
	String participateEmail;
	
	Date startTime;
	
	Integer duration;
	
	String zoomMeetingId;
	
	String zoomMeetingStartUrl;
	
	String zoomMeetingJoinUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getCreationAppCde() {
		return creationAppCde;
	}

	public void setCreationAppCde(String creationAppCde) {
		this.creationAppCde = creationAppCde;
	}

	public String getLaunchAppCde() {
		return launchAppCde;
	}

	public void setLaunchAppCde(String launchAppCde) {
		this.launchAppCde = launchAppCde;
	}

	public String getParticipateId() {
		return participateId;
	}

	public void setParticipateId(String participateId) {
		this.participateId = participateId;
	}

	public String getParticipateEmail() {
		return participateEmail;
	}

	public void setParticipateEmail(String participateEmail) {
		this.participateEmail = participateEmail;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getZoomMeetingId() {
		return zoomMeetingId;
	}

	public void setZoomMeetingId(String zoomMeetingId) {
		this.zoomMeetingId = zoomMeetingId;
	}

	public String getZoomMeetingStartUrl() {
		return zoomMeetingStartUrl;
	}

	public void setZoomMeetingStartUrl(String zoomMeetingStartUrl) {
		this.zoomMeetingStartUrl = zoomMeetingStartUrl;
	}

	public String getZoomMeetingJoinUrl() {
		return zoomMeetingJoinUrl;
	}

	public void setZoomMeetingJoinUrl(String zoomMeetingJoinUrl) {
		this.zoomMeetingJoinUrl = zoomMeetingJoinUrl;
	}
	
}

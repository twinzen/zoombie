package com.twinzom.zoombie.remote.zoom;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twinzom.zoombie.remote.zoom.model.BaseMeeting;
import com.twinzom.zoombie.remote.zoom.model.Settings;

@Service
public class ZoomApiClient {

	String JWT_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6Ii1rVnFlbHdlVHBhQTlsR1hxdFdzY1EiLCJleHAiOjI0MDcwODA4NDAsImlhdCI6MTU4NjAyMjA0Mn0.hF0AD9O5Ty3STBOv_ME9P3CqUmZmT9hmZF02WKdZ5jo";
	
	String ZOOM_API_BASE_URI = "https://api.zoom.us/v2";
	
	public BaseMeeting createMeeting (String topic, String userId, String startTime, int duration) {
		
		BaseMeeting m = new BaseMeeting();
		Settings s = new Settings();
		
		m.setTopic(topic);
		m.setType(2); //config
		m.setStart_time(startTime);
		m.setDuration(duration);
		m.setTimezone("Asia/Hong Kong");
		s.setHost_video(true); //config
		s.setParticipant_video(false);//config
		s.setCn_meeting(false);//config
		s.setIn_meeting(false);//config
		s.setJoin_before_host(false); //config
		s.setMute_upon_entry(false); //config
		s.setWatermark(true); //config
		s.setUser_pmi(false); //config
		s.setApproval_type(2); //config
		s.setAudio("voip"); //config
		s.setAuto_recording("none"); //config
		s.setEnforce_login(false); //config
		s.setEnforce_login_domains(""); //config
		s.setAlternative_hosts(""); //config
		s.setClose_registration(true); //config
		s.setWaiting_room(true); //config
		s.setContact_name(""); //config
		s.setContact_email(""); //config
		s.setRegistrants_email_notification(false); //config
		s.setMeeting_authentication(false); //config
		s.setAuthentication_option(""); //config
		s.setAuthentication_domains(""); //config
		m.setSettings(s);
		
		Mono<BaseMeeting> resp = WebClient
				  .create()
				  .post()
				  .uri(URI.create(ZOOM_API_BASE_URI+"/users/"+userId+"/meetings"))
				  .contentType(MediaType.APPLICATION_JSON)
				  .header("Authorization", "Bearer "+JWT_TOKEN)
				  .body(Mono.just(m),BaseMeeting.class)
				  .retrieve().bodyToMono(BaseMeeting.class);
		
		return resp.block();
	}
	
}
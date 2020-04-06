package com.twinzom.zoombie.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.twinzom.zoombie.model.Meeting;
import com.twinzom.zoombie.model.User;
import com.twinzom.zoombie.remote.zoom.ZoomApiClient;
import com.twinzom.zoombie.remote.zoom.model.BaseMeeting;

@RestController
public class MeetingController {

	private String projectId = "zoombie-273203";

	@Autowired
	ZoomApiClient zoomApiClient;

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
	
	@RequestMapping(value = "/api/users/{userId}/meetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Meeting> listMeetings(@PathVariable String userId)
			throws InterruptedException, ExecutionException {

		FirestoreOptions firestoreOptions = FirestoreOptions
				.getDefaultInstance().toBuilder().setProjectId(projectId)
				.build();
		Firestore db = firestoreOptions.getService();

		ApiFuture<QuerySnapshot> future = db.collection("users")
				.document(userId).collection("meetings").get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();

		List<Meeting> meetings = new ArrayList<Meeting>();
		
		for (QueryDocumentSnapshot document : documents) {
			meetings.add(document.toObject(Meeting.class));
		}
		
		List<Meeting> sortedMeetings = meetings.stream().sorted(Comparator.comparing(Meeting::getStartTime).reversed())
				.collect(Collectors.toList());

		return meetings;
	}

	@RequestMapping(value = "/api/users/{userId}/meetings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Meeting createMeeting(@PathVariable String userId,
			@RequestBody Meeting meeting) throws Exception {

		FirestoreOptions firestoreOptions = FirestoreOptions
				.getDefaultInstance().toBuilder().setProjectId(projectId)
				.build();
		Firestore db = firestoreOptions.getService();

		DocumentSnapshot document = db.collection("users").document(userId)
				.get().get();

		User user = null;
		
		if (document.exists()) {
			
			//Get user infomation from firebase
			user = document.toObject(User.class);
			BaseMeeting zoomMeeting = zoomApiClient.createMeeting(meeting.getTopic(), user.getEmail(), df.format(meeting.getStartTime()), meeting.getDuration());
			
			meeting.setZoomMeetingId(zoomMeeting.getId().toString());
			meeting.setZoomMeetingStartUrl(zoomMeeting.getStart_url());
			meeting.setZoomMeetingJoinUrl(zoomMeeting.getJoin_url());
			
			db.collection("users").document(userId).collection("meetings").document().set(meeting);
			
		} else {
			
			throw new Exception("User not found!");
		}

		return meeting;
	}

}
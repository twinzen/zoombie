package com.twinzom.zoombie.remote.zoom.model;

import java.util.List;

public class Settings {

//    "settings": {
//    "type": "object",
//    "description": "Meeting settings.",
//    "properties": {
//      "host_video": {
//        "type": "boolean",
//        "description": "Start video when the host joins the meeting."
//      },
	boolean host_video;
	
//      "participant_video": {
//        "type": "boolean",
//        "description": "Start video when participants join the meeting."
//      },
	boolean participant_video;
	
//      "cn_meeting": {
//        "type": "boolean",
//        "description": "Host meeting in China.",
//        "default": false
//      },
	boolean cn_meeting;
	
//      "in_meeting": {
//        "type": "boolean",
//        "description": "Host meeting in India.",
//        "default": false
//      },
	boolean in_meeting;
	
//      "join_before_host": {
//        "type": "boolean",
//        "description": "Allow participants to join the meeting before the host starts the meeting. Only used for scheduled or recurring meetings.",
//        "default": false
//      },
	boolean join_before_host;
	
//      "mute_upon_entry": {
//        "type": "boolean",
//        "description": "Mute participants upon entry.",
//        "default": false
//      },
	boolean mute_upon_entry;
	
//      "watermark": {
//        "type": "boolean",
//        "description": "Add watermark when viewing a shared screen.",
//        "default": false
//      },
	boolean watermark;
	
//      "use_pmi": {
//        "type": "boolean",
//        "description": "Use a personal meeting ID. Only used for scheduled meetings and recurring meetings with no fixed time.",
//        "default": false
//      },
	boolean user_pmi;
	
//      "approval_type": {
//        "type": "integer",
//        "default": 2,
//        "description": "Enable registration and set approval for the registration. Note that this feature requires the host to be of **Licensed** user type. **Registration cannot be enabled for a basic user.** <br><br>\n\n`0` - Automatically approve.<br>`1` - Manually approve.<br>`2` - No registration required.",
//        "enum": [
//          0,
//          1,
//          2
//        ],
//        "x-enum-descriptions": [
//          "Automatically Approve",
//          "Manually Approve",
//          "No Registration Required"
//        ]
//      },
	Integer approval_type;
	
//      "registration_type": {
//        "type": "integer",
//        "description": "Registration type. Used for recurring meeting with fixed time only. <br>`1` Attendees register once and can attend any of the occurrences.<br>`2` Attendees need to register for each occurrence to attend.<br>`3` Attendees register once and can choose one or more occurrences to attend.",
//        "default": 1,
//        "enum": [
//          1,
//          2,
//          3
//        ],
//        "x-enum-descriptions": [
//          "Attendees register once and can attend any of the occurrences",
//          "Attendees need to register for each occurrence to attend",
//          "Attendees register once and can choose one or more occurrences to attend"
//        ]
//      },
	Integer registration_type;
	
//      "audio": {
//        "type": "string",
//        "description": "Determine how participants can join the audio portion of the meeting.<br>`both` - Both Telephony and VoIP.<br>`telephony` - Telephony only.<br>`voip` - VoIP only.",
//        "default": "both",
//        "enum": [
//          "both",
//          "telephony",
//          "voip"
//        ],
//        "x-enum-descriptions": [
//          "Both Telephony and VoIP",
//          "Telephony only",
//          "VoIP only"
//        ]
//      },
	String audio;
	
//      "auto_recording": {
//        "type": "string",
//        "description": "Automatic recording:<br>`local` - Record on local.<br>`cloud` -  Record on cloud.<br>`none` - Disabled.",
//        "default": "none",
//        "enum": [
//          "local",
//          "cloud",
//          "none"
//        ],
//        "x-enum-descriptions": [
//          "Record to local device",
//          "Record to cloud",
//          "No Recording"
//        ]
//      },
	String auto_recording;
	
//      "enforce_login": {
//        "type": "boolean",
//        "description": "Only signed in users can join this meeting."
//      },
	boolean enforce_login;
	
//      "enforce_login_domains": {
//        "type": "string",
//        "description": "Only signed in users with specified domains can join meetings."
//      },
	String enforce_login_domains;
	
//      "alternative_hosts": {
//        "type": "string",
//        "description": "Alternative host's emails or IDs: multiple values separated by a comma."
//      },
	String alternative_hosts;
	
//      "close_registration": {
//        "type": "boolean",
//        "description": "Close registration after event date",
//        "default": false
//      },
	boolean close_registration;
	
//      "waiting_room": {
//        "type": "boolean",
//        "description": "Enable waiting room",
//        "default": false
//      },
	boolean waiting_room;
	
//      "global_dial_in_countries": {
//        "type": "array",
//        "description": "List of global dial-in countries",
//        "items": {
//          "type": "string"
//        }
//      },
	List<String> global_dial_in_countries;
	
//      "global_dial_in_numbers": {
//        "type": "array",
//        "description": "Global Dial-in Countries/Regions",
//        "items": {
//          "type": "object",
//          "properties": {
//            "country": {
//              "type": "string",
//              "description": "Country code. For example, BR."
//            },
//            "country_name": {
//              "type": "string",
//              "description": "Full name of country. For example, Brazil."
//            },
//            "city": {
//              "type": "string",
//              "description": "City of the number, if any. For example, Chicago."
//            },
//            "number": {
//              "type": "string",
//              "description": "Phone number. For example, +1 2332357613."
//            },
//            "type": {
//              "type": "string",
//              "description": "Type of number. ",
//              "enum": [
//                "toll",
//                "tollfree"
//              ]
//            }
//          }
//        }
//      },
	
//      "contact_name": {
//        "type": "string",
//        "description": "Contact name for registration"
//      },
	String contact_name;
	
//      "contact_email": {
//        "type": "string",
//        "description": "Contact email for registration"
//      },
	String contact_email;
	
//      "registrants_confirmation_email": {
//        "type": "boolean",
//        "description": "Send confirmation email to registrants"
//      },
	boolean registrants_confirmation_email;
	
//      "registrants_email_notification": {
//        "type": "boolean",
//        "description": "registrants email notification"
//      },
	boolean registrants_email_notification;
	
//      "meeting_authentication": {
//        "type": "boolean",
//        "description": "Only authenticated users can join meetings"
//      },
	boolean meeting_authentication;
	
//      "authentication_option": {
//        "type": "string",
//        "description": "Meeting authentication option id"
//      },
	String authentication_option;
	
//      "authentication_domains": {
//        "type": "string",
//        "description": "Meeting authentication_domains"
//      }
//    }
//  },
	String authentication_domains;

	public boolean isHost_video() {
		return host_video;
	}

	public void setHost_video(boolean host_video) {
		this.host_video = host_video;
	}

	public boolean isParticipant_video() {
		return participant_video;
	}

	public void setParticipant_video(boolean participant_video) {
		this.participant_video = participant_video;
	}

	public boolean isCn_meeting() {
		return cn_meeting;
	}

	public void setCn_meeting(boolean cn_meeting) {
		this.cn_meeting = cn_meeting;
	}

	public boolean isIn_meeting() {
		return in_meeting;
	}

	public void setIn_meeting(boolean in_meeting) {
		this.in_meeting = in_meeting;
	}

	public boolean isJoin_before_host() {
		return join_before_host;
	}

	public void setJoin_before_host(boolean join_before_host) {
		this.join_before_host = join_before_host;
	}

	public boolean isMute_upon_entry() {
		return mute_upon_entry;
	}

	public void setMute_upon_entry(boolean mute_upon_entry) {
		this.mute_upon_entry = mute_upon_entry;
	}

	public boolean isWatermark() {
		return watermark;
	}

	public void setWatermark(boolean watermark) {
		this.watermark = watermark;
	}

	public boolean isUser_pmi() {
		return user_pmi;
	}

	public void setUser_pmi(boolean user_pmi) {
		this.user_pmi = user_pmi;
	}

	public Integer getApproval_type() {
		return approval_type;
	}

	public void setApproval_type(Integer approval_type) {
		this.approval_type = approval_type;
	}

	public Integer getRegistration_type() {
		return registration_type;
	}

	public void setRegistration_type(Integer registration_type) {
		this.registration_type = registration_type;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getAuto_recording() {
		return auto_recording;
	}

	public void setAuto_recording(String auto_recording) {
		this.auto_recording = auto_recording;
	}

	public boolean isEnforce_login() {
		return enforce_login;
	}

	public void setEnforce_login(boolean enforce_login) {
		this.enforce_login = enforce_login;
	}

	public String getEnforce_login_domains() {
		return enforce_login_domains;
	}

	public void setEnforce_login_domains(String enforce_login_domains) {
		this.enforce_login_domains = enforce_login_domains;
	}

	public String getAlternative_hosts() {
		return alternative_hosts;
	}

	public void setAlternative_hosts(String alternative_hosts) {
		this.alternative_hosts = alternative_hosts;
	}

	public boolean isClose_registration() {
		return close_registration;
	}

	public void setClose_registration(boolean close_registration) {
		this.close_registration = close_registration;
	}

	public boolean isWaiting_room() {
		return waiting_room;
	}

	public void setWaiting_room(boolean waiting_room) {
		this.waiting_room = waiting_room;
	}

	public List<String> getGlobal_dial_in_countries() {
		return global_dial_in_countries;
	}

	public void setGlobal_dial_in_countries(List<String> global_dial_in_countries) {
		this.global_dial_in_countries = global_dial_in_countries;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public boolean isRegistrants_confirmation_email() {
		return registrants_confirmation_email;
	}

	public void setRegistrants_confirmation_email(
			boolean registrants_confirmation_email) {
		this.registrants_confirmation_email = registrants_confirmation_email;
	}

	public boolean isRegistrants_email_notification() {
		return registrants_email_notification;
	}

	public void setRegistrants_email_notification(
			boolean registrants_email_notification) {
		this.registrants_email_notification = registrants_email_notification;
	}

	public boolean isMeeting_authentication() {
		return meeting_authentication;
	}

	public void setMeeting_authentication(boolean meeting_authentication) {
		this.meeting_authentication = meeting_authentication;
	}

	public String getAuthentication_option() {
		return authentication_option;
	}

	public void setAuthentication_option(String authentication_option) {
		this.authentication_option = authentication_option;
	}

	public String getAuthentication_domains() {
		return authentication_domains;
	}

	public void setAuthentication_domains(String authentication_domains) {
		this.authentication_domains = authentication_domains;
	}
	
}

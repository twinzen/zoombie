package com.twinzom.zoombie.remote.zoom.model;

public class BaseMeeting {

//		    "id": {
//		      "description": "Meeting ID: Unique identifier of the meeting, also known as the meeting number.",
//		      "type": "integer"
//		    },
	Integer id;
	
//		    "topic": {
//		      "type": "string",
//		      "description": "Meeting topic"
//		    },
	String topic;
	
//		    "type": {
//		      "type": "integer",
//		      "description": "Meeting Type",
//		      "default": 2,
//		      "enum": [
//		        1,
//		        2,
//		        3,
//		        8
//		      ],
	Integer type;
	
//		    "start_time": {
//		      "type": "string",
//		      "format": "date-time",
//		      "description": "Meeting start date-time in UTC/GMT. Example: \"2020-03-31T12:02:00Z\""
//		    },
	String start_time;
	
//		    "duration": {
//		      "type": "integer",
//		      "description": "Meeting duration"
//		    },
	Integer duration;
	
//		    "timezone": {
//		      "type": "string",
//		      "description": "Timezone to format start_time"
//		    },
	String timezone;
	
//		    "created_at": {
//		      "type": "string",
//		      "format": "date-time",
//		      "description": "The date and time at which this meeting was created."
//		    },
	String created_at;
	
//		    "agenda": {
//		      "type": "string",
//		      "description": "Agenda"
//		    },
	String agenda;
	
//		    "start_url": {
//		      "type": "string",
//		      "description": "URL to start the meeting. This URL should only be used by the host of the meeting and **should not be shared with anyone other than the host** of the meeting as anyone with this URL will be able to login to the Zoom Client as the host of the meeting."
//		    },
	String start_url;
	
//		    "join_url": {
//		      "type": "string",
//		      "description": "URL for participants to join the meeting. This URL should only be shared with users that you would like to invite for the meeting."
//		    },
	String join_url;
	
//		    "password": {
//		      "type": "string",
//		      "description": "Meeting password. Password may only contain the following characters: `[a-z A-Z 0-9 @ - _ * !]`"
//		    },
	String password;
	
//		    "h323_password": {
//		      "type": "string",
//		      "description": "H.323/SIP room system password"
//		    },
	String h323_password;
	
//		    "pmi": {
//		      "type": "integer",
//		      "description": "Personal Meeting Id. Only used for scheduled meetings and recurring meetings with no fixed time.",
//		      "format": "int64"
//		    },
	Integer pmi;
	
//		    "tracking_fields": {
//		      "type": "array",
//		      "description": "Tracking fields",
//		      "items": {
//		        "type": "object",
//		        "properties": {
//		          "field": {
//		            "type": "string",
//		            "description": "Tracking fields type"
//		          },
//		          "value": {
//		            "type": "string",
//		            "description": "Tracking fields value"
//		          }
//		        }
//		      }
//		    },
	Settings settings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getStart_url() {
		return start_url;
	}

	public void setStart_url(String start_url) {
		this.start_url = start_url;
	}

	public String getJoin_url() {
		return join_url;
	}

	public void setJoin_url(String join_url) {
		this.join_url = join_url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getH323_password() {
		return h323_password;
	}

	public void setH323_password(String h323_password) {
		this.h323_password = h323_password;
	}

	public Integer getPmi() {
		return pmi;
	}

	public void setPmi(Integer pmi) {
		this.pmi = pmi;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	
//		    "occurrences": {
//		      "type": "array",
//		      "description": "Array of occurrence objects.",
//		      "items": {
//		        "type": "object",
//		        "description": "Occurence object. This object is only returned for Recurring Webinars.",
//		        "properties": {
//		          "occurrence_id": {
//		            "type": "string",
//		            "description": "Occurrence ID: Unique Identifier that identifies an occurrence of a recurring webinar. [Recurring webinars](https://support.zoom.us/hc/en-us/articles/216354763-How-to-Schedule-A-Recurring-Webinar) can have a maximum of 50 occurrences."
//		          },
//		          "start_time": {
//		            "type": "string",
//		            "format": "date-time",
//		            "description": "Start time."
//		          },
//		          "duration": {
//		            "type": "integer",
//		            "description": "Duration."
//		          },
//		          "status": {
//		            "type": "string",
//		            "description": "Occurrence status."
//		          }
//		        }
//		      }
//		    },
	

//		    "recurrence": {
//		      "type": "object",
//		      "description": "Recurrence object. Use this object only for a meeting with type `8` i.e., a recurring meeting with fixed time. ",
//		      "required": [
//		        "type"
//		      ],
//		      "properties": {
//		        "type": {
//		          "type": "integer",
//		          "description": "Recurrence meeting types:<br>`1` - Daily.<br>`2` - Weekly.<br>`3` - Monthly.",
//		          "enum": [
//		            1,
//		            2,
//		            3
//		          ],
//		          "x-enum-descriptions": [
//		            "Daily",
//		            "Weekly",
//		            "Monthly"
//		          ]
//		        },
//		        "repeat_interval": {
//		          "type": "integer",
//		          "description": "Define the interval at which the meeting should recur. For instance, if you would like to schedule a meeting that recurs every two months, you must set the value of this field as `2` and the value of the `type` parameter as `3`. \n\nFor a daily meeting, the maximum interval you can set is `90` days. For a weekly meeting the maximum interval that you can set is  of `12` weeks. For a monthly meeting, there is a maximum of `3` months.\n\n"
//		        },
//		        "weekly_days": {
//		          "type": "string",
//		          "description": "Use this field **only if you're scheduling a recurring meeting of type** `2` to state which day(s) of the week the meeting should repeat. <br>\n**Note:** If you would like the meeting to occur on multiple days of a week, you should provide comma separated values for this field. <br>`1`  - Sunday. <br>`2` - Monday.<br>`3` - Tuesday.<br>`4` -  Wednesday.<br>`5` -  Thursday.<br>`6` - Friday.<br>`7` - Saturday.",
//		          "enum": [
//		            "1",
//		            "2",
//		            "3",
//		            "4",
//		            "5",
//		            "6",
//		            "7"
//		          ]
//		        },
//		        "monthly_day": {
//		          "type": "integer",
//		          "description": "Use this field **only if you're scheduling a recurring meeting of type** `3` to state which day in a month, the meeting should recur. The value range is from 1 to 31.\n\nFor instance, if you would like the meeting to recur on 23rd of each month, provide `23` as the value of this field and `1` as the value of the `repeat_interval` field. Instead, if you would like the meeting to recur every three months, on 23rd of the month, change the value of the `repeat_interval` field to `3`."
//		        },
//		        "monthly_week": {
//		          "type": "integer",
//		          "description": "Use this field **only if you're scheduling a recurring meeting of type** `3` to state the week of the month when the meeting should recur. If you use this field, **you must also use the `monthly_week_day` field to state the day of the week when the meeting should recur.** <br>`-1` - Last week of the month.<br>`1` - First week of the month.<br>`2` - Second week of the month.<br>`3` - Third week of the month.<br>`4` - Fourth week of the month.",
//		          "enum": [
//		            -1,
//		            1,
//		            2,
//		            3,
//		            4
//		          ],
//		          "x-enum-descriptions": [
//		            "Last week",
//		            "First week",
//		            "Second week",
//		            "Third week",
//		            "Fourth week"
//		          ]
//		        },
//		        "monthly_week_day": {
//		          "type": "integer",
//		          "description": "Use this field **only if you're scheduling a recurring meeting of type** `3` to state a specific day in a week when the monthly meeting should recur. To use this field, you must also use the `monthly_week` field. \n\n<br>`1` - Sunday.<br>`2` - Monday.<br>`3` - Tuesday.<br>`4` -  Wednesday.<br>`5` - Thursday.<br>`6` - Friday.<br>`7` - Saturday.",
//		          "enum": [
//		            1,
//		            2,
//		            3,
//		            4,
//		            5,
//		            6,
//		            7
//		          ],
//		          "x-enum-descriptions": [
//		            "Sunday",
//		            "Monday",
//		            "Tuesday",
//		            "Wednesday",
//		            "Thursday",
//		            "Friday",
//		            "Saturday"
//		          ]
//		        },
//		        "end_times": {
//		          "type": "integer",
//		          "description": "Select how many times the meeting should recur before it is canceled. (Cannot be used with \"end_date_time\".)",
//		          "default": 1,
//		          "maximum": 50
//		        },
//		        "end_date_time": {
//		          "type": "string",
//		          "description": "Select the final date on which the meeting will recur before it is canceled. Should be in UTC time, such as 2017-11-25T12:00:00Z. (Cannot be used with \"end_times\".)",
//		          "format": "date-time"
//		        }
//		      }
//		    }
//		  }
//		}
}

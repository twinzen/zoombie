var Zoombie_isNoMeeting = false;

function ZoombieWidget(userId, participateId) {
	this.userId = userId;
	this.participateId = participateId;
	this.init = function() {
		Zoombie.getMeetings(userId, participateId);
		$(document.body).append(
				'<div id="zoombie-widget-icon">'
				+ '<a href="javascript:Zoombie.toggleDetail()" id="iconLink" class="icon">'
				+ '<span id="iconCaption">Next Meeting</span>'
				+ '<span class="badge" id="timeToMeeting"> -- </span>'
				+ '<iframe src="blank.html" style="border: none;width: 0px; height: 0px;" id="zoombie-widget-start-meeting-frame" name="zoombie-widget-start-meeting-frame"></iframe>'
				+ '</a>'	
				+'</div>'
				);
		$(document.body).append(
				'<div id="zoombie-widget-detail">'
				+'<div class="content">'
				+ '<div>Topic: <span id="topicSpan"> -- </span></div>'
				+ '<div>Start Time: <span id="startTimeSpan" >12 Apr, 1:00 PM</span></div>'
				+ '<div><a href="#" id="startUrlLink" target="zoombie-widget-start-meeting-frame">Start Meeting</a>'
				+'</div>'
				+'</div>'
				);
		$(document.body).append(
				'<div id="zoombie-widget-one-click-meeting">'
				+'<div class="content">'
				+'<div><svg class="bi bi-plus-circle-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">'
				+' <path fill-rule="evenodd" d="M16 8A8 8 0 110 8a8 8 0 0116 0zM8.5 4a.5.5 0 00-1 0v3.5H4a.5.5 0 000 1h3.5V12a.5.5 0 001 0V8.5H12a.5.5 0 000-1H8.5V4z" clip-rule="evenodd"/>'
				+'	</svg>' 
				+ ' <a href="javascript:Zoombie.oneClickMeeting(\''+userId+'\',\''+participateId+'\')" id="oneClickLink">One Click Meeting</a>'
				+'</div>'
				+'</div>'
				);
	}
}

var Zoombie = {
	
	getMeetings : function getMeetings(userId, participateId) {
		$.getJSON("http://localhost:8080/api/users/" + userId + "/meetings?participateId="+participateId,
				function(data) {
					
					l = Object.keys(data).length;
					
					if (l >= 1) {
						Zoombie.populateBadge(data[l-1]);
						Zoombie.populateDetail(data[l-1]);
					}
			
				});
	},
	
	populateDetail : function populateDetail(m) {
		//$("#zoombie-widget-detail").html(JSON.stringify(m));
		$("#topicSpan").html(m.topic);
		$("#startTimeSpan").html(Zoombie.formatDate(m.startTime));
		$("#startUrlLink").attr('href', m.zoomMeetingStartUrl);
	},
	
	populateBadge : function populateBadge(m) {
		var meetingStartTime = new Date(m.startTime);
		var now = new Date();
		var diff = meetingStartTime - now;
		console.log(diff);
		var timeToMeetingVal = " -- "
		var isNoMeeting = true;
		if (diff < 0) {
			console.log("No Meeting");
			timeToMeetingVal = "N/A";
		} else if (diff/1000 < 60 ) {
			timeToMeetingVal = "Now";
			isNoMeeting = false;
		} else if (diff/1000/60 < 60) {
			timeToMeetingVal = Math.round(diff/1000/60) + "Mins";
			isNoMeeting = false;
		} else if (diff/1000/60/60 < 24) {
			timeToMeetingVal = Math.round(diff/1000/60/60) + "Hrs";
			isNoMeeting = false;
		} else if (diff/1000/60/60/24 < 31) {
			timeToMeetingVal = Math.round(diff/1000/60/60/24) + "Days";
			isNoMeeting = false;
		} else {
			console.log("N/A");
			timeToMeetingVal = "No Meeting";
		}
		console.log(timeToMeetingVal);
		$("#timeToMeeting").html(timeToMeetingVal);
		if (isNoMeeting) {
			$("#timeToMeeting").addClass("badge-no-meeting");
			$("#iconLink").addClass("icon-no-meeting");
			$("#iconCaption").html("No Meeting");
			Zoombie_isNoMeeting = true;
		}
	},
	
	toggleDetail : function toggleDetail() {
		if (!Zoombie_isNoMeeting) {
			if ($("#zoombie-widget-detail").is(":visible")) {
				$("#zoombie-widget-detail").hide("slow");
			} else {
				$("#zoombie-widget-detail").show("slow");
			}
		} else {
			if ($("#zoombie-widget-one-click-meeting").is(":visible")) {
				$("#zoombie-widget-one-click-meeting").hide("slow");
			} else {
				$("#zoombie-widget-one-click-meeting").show("slow");
			}
		}
	},
	
	formatDate : function formatDate(timestamp){
        var x=new Date(timestamp);
        var yy = x.getFullYear();
        var dd = x.getDate();
        var mm = x.getMonth()+1;
        var month = "";
        switch(mm) {
	    	case 1:
				month = "Jan"
				break;
			case 2:
				month = "Feb"
				break;
			case 3:
				month = "Mar"
				break;
			case 4:
				month = "Apr"
				break;
			case 5:
				month = "May"
				break;
			case 6:
				month = "Jun"
				break;
			case 7:
				month = "Jul"
				break;
			case 8:
				month = "Aug"
				break;
			case 9:
				month = "Sep"
				break;
			case 10:
				month = "Oct"
				break;
			case 11:
				month = "Nov"
				break;
			case 12:
				month = "Dec"
				break;
	        default:
	          // code block
	    }
        
        var hh = x.getHours();
        var mi = x.getMinutes();
        var ampm = hh >= 12 ? 'pm' : 'am';
        hh = hh % 12;
        hh = hh ? hh : 12; // the hour '0' should be '12'
        mi = mi < 10 ? '0'+mi : mi;
        
        return dd + " " + month +" "+ yy +", "+hh+":"+mi + " " + ampm;
    },
    
    oneClickMeeting : function oneClickMeeting (userId, participateId) {
		
    	var newMeeting = {};
		
		newMeeting["topic"] = "New meeting";
		newMeeting["participateId"] = participateId;
		newMeeting["participateEmail"] = "";
		newMeeting["startTime"] = new Date();
		newMeeting["duration"] = 60;
		newMeeting["creationAppCde"] = "RMP";
		newMeeting["launchAppCde"] = "SFP";
		
		//console.log(JSON.stringify(newMeeting));
		
		$.ajax({
			type: "POST",
			url: "/api/users/"+userId+"/meetings",
			dataType: "json",
			headers: {"Content-Type":"application/json"},
			data: JSON.stringify(newMeeting),
			success: function (data) {
				document.getElementById("zoombie-widget-start-meeting-frame").src=data.zoomMeetingStartUrl;
			}
		})
	}
};

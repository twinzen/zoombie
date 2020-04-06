function ZoombieWidget(userId, participateId) {
	this.userId = userId;
	this.participateId = participateId;
	this.init = function() {
		Zoombie.getMeetings(userId);
		$(document.body).append(
				'<div id="zoombie-widget">' + this.userId + '</div>');
	}
}

var Zoombie = {
	getMeetings : function getMeetings(userId) {
		$.getJSON("http://localhost:8080/api/users/" + userId + "/meetings",
				function(data) {
					$.each(data, function(key, m) {
						console.log("RESP: " + JSON.stringify(m));
						// $("#meetings-table").append(formatMeetingTable(m));
					});
				});
	}
};

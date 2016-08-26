/**
 * 
 * 
 * jQuery.ajax({ type: "GET|POST|DELETE|PUT", url:
 * "http://localhost:5050/words/", data: data, data.id
 * dataType:"text|html|json|jsonp|script|xml" success: success_callback, error:
 * error_callback });
 */

$(document).ready(function() {
	getWord();
});

var getWord = function() {
	$.ajax({
		url : "http://localhost:5050/words/"
	}).then(function(data) {
		$.each(data, function(index) {
			$('#word').append(data[index].word + "   *   ");

		});
	});
}

/*
 * (function($) {
 * 
 * $('#editor').on('submit', function(e) { e.preventDefault();
 * 
 * var word = $('#wordToSubmit').val(); var JSONObj = { "word" : word };
 * 
 * var data = JSON.stringify(JSONObj);
 * 
 * $.ajax({ type : "POST", url : "http://localhost:5050/words/", dataType :
 * 'json', data : data, beforeSend : function(xhr) {
 * xhr.setRequestHeader('X-WP-Nonce', JP_POST_EDITOR.nonce); },
 * 
 * success : function(response) { alert(JP_POST_EDITOR.successMessage);
 * getWord(); }, failure : function(response) {
 * alert(JP_POST_EDITOR.failureMessage); } });
 * 
 * }); })(jQuery);
 * 
 * 
 * var addWord = function() { alert("I clicked here"); var word =
 * $('#wordToSubmit').val(); var JSONObj = { "word" : word }; var data =
 * JSON.stringify(JSONObj); $.ajax({ type : "POST", url :
 * "http://localhost:5050/words/", dataType : 'json', data : data, success :
 * function(response) { alert("Successfuly added"); // getWord(); }, failure :
 * function(response) { alert("Error"); } }); }
 */
var addWord = function() {
	var word = $('#wordToSubmit').val();
	$.ajax({
		type : "POST",
		// the url where you want to sent the userName and password to
		contentType : "application/json",
		url : 'http://localhost:5050/words/',
		dataType : 'json',
		async : false,
		timeout : 100000,
		// json object to sent to the authentication url
		data : JSON.stringify({
			"word" : word
		}),
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	})
}

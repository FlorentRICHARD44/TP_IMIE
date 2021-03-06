/**
 * 
 */
var userConnected;

function User(id, nom, prenom, matricule) {
	this.id = id;
	this.name = nom;
	this.firstname = prenom;
	this.matricule = matricule;
}

$(function() {
	$('#login').on('click',
				   function() {
						if ($('div.employee-selection input#user').val() != "") {
							$.ajax({url: 'http://localhost:8080/sirh-rest/api/employee/' 
										+ $('div.employee-selection input#user').val(),
									method: 'GET',
								    dataType: 'json'})
								    .done(function(data) {
								    	userConnected = new User(data.id, data.nom, data.prenom, data.matricule);
								    	$('div.employee-data').removeAttr("hidden");
								    	$('div.employee-data h3').text(userConnected.firstname + " " + userConnected.name);
								    	$('div.employee-data #name').val(userConnected.name);
								    	$('div.employee-data #firstname').val(userConnected.firstname);
								    	$('div.employee-data #matricule').val(userConnected.matricule);
								    	$('div.employee-selection p.error').text("");
								    	$('ul#project-list li').remove();
							    		$('#close-projects').attr("hidden", "true");
							    		$('#see-projects').removeAttr("hidden");
								    	$('ul#compte-list li').remove();
							    		$('#close-comptes').attr("hidden", "true");
							    		$('#see-comptes').removeAttr("hidden");
								    })
								    .fail(function(data) {
								    	$('div.employee-selection p.error').text("Employé non trouvé");
								    	$('div.employee-data').attr("hidden", "true");
								    });
						}
	});
	
	$('#see-projects').on('click',
						  function() {
						$.ajax({url: 'http://localhost:8080/sirh-rest/api/project?employee=' 
									 + userConnected.id,
							    method: 'GET',
							    dataType: 'json'})
							    .done(function(data) {
							    	$('ul#project-list li').remove();
							    	for (var i in data) {
							    		$('ul#project-list').append($('<li>').text(data[i].nom));
							    	}
						    		$('#see-projects').attr("hidden", "true");
						    		$('#close-projects').removeAttr("hidden");
							    })
							    .fail(function(data) {
							    	console.log("project error");
							    })
	})
	$('#close-projects').on('click',
							function() {
		$('#close-projects').attr("hidden", "true");
		$('#see-projects').removeAttr("hidden");
    	$('ul#project-list li').remove();
	})
	
	$('#see-comptes').on('click',
						  function() {
						$.ajax({url: 'http://localhost:8080/sirh-rest/api/employee/' 
									 + userConnected.id + "/comptes",
							    method: 'GET',
							    dataType: 'json'})
							    .done(function(data) {
							    	$('ul#compte-list li').remove();
							    	for (var i in data) {
							    		var line = $('<li>').text(data[i].nom + " Solde = " + data[i].solde.toFixed(2) + " euros");
							    		if (data[i].solde < 0) {
							    			line.addClass("negative");
							    		} else {
							    			line.addClass("positive");
							    		}
							    		$('ul#compte-list').append(line);
							    	}
						    		$('#see-comptes').attr("hidden", "true");
						    		$('#close-comptes').removeAttr("hidden");
							    })
							    .fail(function(data) {
							    	console.log("compte error");
							    })
	})
	$('#close-comptes').on('click',
							function() {
		$('#close-comptes').attr("hidden", "true");
		$('#see-comptes').removeAttr("hidden");
    	$('ul#compte-list li').remove();
	})
})

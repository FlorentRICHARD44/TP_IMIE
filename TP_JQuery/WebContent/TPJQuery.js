/**
 * 
 */
var displayIndex = 0;
var nbImgDisplayed = 2;
var pendingImports = [];


$(function() {
	// Liste of all the images
	var tabImg = [];
	function Image(data, title, desc, tags, filename, datecreation) {
		var img_id = null;
		var img_data = data;
		var img_title = title;
		var img_desc = desc;
		var img_tags = tags;
		var img_filename = filename;
		var img_datecreation = datecreation
		this.getId = function() {return img_id};
		this.setId = function(id) {img_id = id};
		this.getData = function() {return img_data};
		this.getTitle = function() {return img_title};
		this.getDesc = function() {return img_desc};
		this.getTags = function() {return img_tags};
		this.getFileName = function() {return img_filename};
		this.getDateCreation = function() {return img_datecreation};
	}
	
	function initTagList(tagsSelected) {
		var selectedTags = tagsSelected || []
		var tags = ["Paysage", "Cinéma", "Bouton", "Logo"];
		$('#modal ul#sortable_link').text('');
		$('#modal ul#sortable_dispo').text('');
		for (var i in tags) {
			if ($.inArray(tags[i], selectedTags) != -1) {
				$('#modal ul#sortable_link').append($('<li>').addClass('ui-state-default').text(tags[i]));
			} else {
				$('#modal ul#sortable_dispo').append($('<li>').addClass('ui-state-default').text(tags[i]));
			}
		}
	}
	
	/***************************
	 * Show the Modal
	 **************************/
	function showModal() {
		$( "#effect" ).show( "slide", {}, 500, null );
	};

	/***************************
	 * Hide the Modal
	 **************************/
	function hideModal() {
		$( "#effect" ).hide( "slide", {}, 500, null );
	};

	/**************************
	 * Event : Click on Save in the modal.
	 **************************/
	$( "#savemodal" ).click(function() {
		var tags = []
		$.each($('#modal ul#sortable_link li'), function(i) {tags.push($(this).text())})
		var img = new Image($('#modal img').attr("src"),
				$('#modal #title').val(),
				$('#modal #desc').val(),
				tags,
				$('#modal #filename').val(),
				$('#modal #datepicker').val());
		img.setId($('#modal #persistid').val())
		if ($('#modal #id').val() == '') { // New image
			$.ajax({
			    data: JSON.stringify({"title":img.getTitle(),
			    					  "desc":img.getDesc(),
			    					  "data":img.getData(),
			    					  "filename": img.getFileName(),
			    					  "datecreation": img.getDateCreation(),
			    					  "tags": img.getTags()}),
			    url: 'https://api.mongolab.com/api/1/databases/imie_tpjs_portfolio/collections/folios?apiKey=b5wK_qlRZHhOMHIve4jc1DEI69PRBRdC',
			    method: 'POST',
			    contentType: 'application/json'
			}).fail(function() {alert("bouh ca marche pas")})
			  .done(function() {selectAll()});
		} else {  // Modification
			tabImg[parseInt($('#modal #id').val())] = img
			$.ajax({
			    data: JSON.stringify({"title":img.getTitle(),
			    					  "desc":img.getDesc(),
			    					  "data":img.getData(),
			    					  "filename": img.getFileName(),
			    					  "datecreation": img.getDateCreation(),
			    					  "tags": img.getTags(),
			    					  "_id": {$oid: img.getId()}}),
			    url: 'https://api.mongolab.com/api/1/databases/imie_tpjs_portfolio/collections/folios/'+ img.getId() + '?apiKey=b5wK_qlRZHhOMHIve4jc1DEI69PRBRdC',
			    method: 'PUT',
			    contentType: 'application/json'
			}).done(function() {selectAll()})
			  .fail(function() {alert("bouh ca marche pas")});
		}
		importImage();
		$('#modal img').attr("src", "");
		$('#modal #title').val('');
		$('#modal #desc').val('');
		$('#modal #id').val('');
		$('#modal #filename').val('');
		$('#modal #datepicker').val('');
	})

	
	/*************************
	 * Function: Display the correct images.
	 *************************/
	function displayImages() {
		$('#imagelist').text('')
		for (var i in tabImg) {
			if (i >= displayIndex && i < (displayIndex + nbImgDisplayed)) {
				$('#imagelist').append($('<div>').addClass('img')
											     .append($('<img>').attr('src', tabImg[i].getData()))
											     .append($('<h3>').text(tabImg[i].getTitle()))
											     .append($('<p>').text(tabImg[i].getDesc()))
											     .append($('<p>').text(tabImg[i].getFileName()))
											     .append($('<p>').text("Créé le : " + tabImg[i].getDateCreation()))
											     .append($('<p>').text(tabImg[i].getTags().join('; ')))
											     .append($('<button>').addClass('btn')  // Button DELETE
											    		 			  .button({icons: {primary: "ui-icon-trash"},text:false})
											    		 			  .click(( function(copieIndex) {
											    		 			        return function() { 
											    		 			        	var img = tabImg[copieIndex];
											    		 			        	$.ajax({
											    		 						    url: 'https://api.mongolab.com/api/1/databases/imie_tpjs_portfolio/collections/folios/'+ img.getId() + '?apiKey=b5wK_qlRZHhOMHIve4jc1DEI69PRBRdC',
											    		 						    method: 'DELETE',
											    		 						    contentType: 'application/json'
											    		 						}).done(function() {selectAll()})
											    		 						  .fail(function() {alert("bouh ca marche pas")});
											    		 			        	if (((nbImgDisplayed + displayIndex) >= tabImg.length) && (displayIndex > 0)) {
											    		 			        		displayIndex--;
											    		 			        	}
								    		 			  					  	}}) ( i )))
	    		 			  					 .append($('<button>').addClass('btn')  // Button EDIT
											    		 			  .button({icons: {primary: "ui-icon-pencil"},text:false})
											    		 			  .click(( function(copieIndex) {
											    		 			        return function() { 
											    		 			        	$('#modal img').attr("src", tabImg[copieIndex].getData());
											    		 			        	$('#modal #title').val(tabImg[copieIndex].getTitle());
											    		 			        	$('#modal #desc').val(tabImg[copieIndex].getDesc());
											    		 			        	$('#modal #filename').val(tabImg[copieIndex].getFileName());
											    		 			        	$('#modal #datepicker').val(tabImg[copieIndex].getDateCreation());
											    		 			        	$('#modal #persistid').val(tabImg[copieIndex].getId());
											    		 			        	$('#modal #id').val(copieIndex);
											    		 			        	initTagList(tabImg[copieIndex].getTags());
											    		 			        	showModal()}}) ( i ))));
			}
		}
	}

	/********************
	 * Import new file.
	 *******************/
	function importImage() {
		var f = pendingImports.pop();
		if (f != undefined) {
			var picReader = new FileReader();
			picReader.addEventListener("load", function (event) {
				var reader = event.target;
				initTagList();
				$('#modal img').attr("src", reader.result)
				$('#modal #filename').val(reader.file.name)
			});
	
			if (!(f.type && !f.type.match('image.*'))) {
				picReader.file = f;
				picReader.readAsDataURL(f);
				showModal();
			}
		} else {
			hideModal();
		}
	}
	
	/**************************
	 * Event : Add file(s) to the selection
	 **************************/
	$( "#addfiles" ).on("change", function( e ) {
		if (window.File && window.FileReader && window.FileList && window.Blob) {
			for (i = 0; i < e.target.files.length; i++) {
				pendingImports.push(e.target.files[i]);
				
			}
			importImage();
		} else {
			console.log('non supporté');
		}

	});

	/**************************
	 * Event : Click on Left move button
	 **************************/
	$( "button#left" )
	.button({icons: {primary: "ui-icon-triangle-1-w"},
		text: false})
		.click(function( event ) {
			if (displayIndex > 0) {
				displayIndex--;
			}
			displayImages();
		});	
	/**************************
	 * Event : Click on Right move button
	 **************************/
	$( "button#right" )
	.button({icons: {primary: "ui-icon-triangle-1-e"},
		text: false})
		.click(function( event ) {
			if (displayIndex < (tabImg.length - nbImgDisplayed)) {
				displayIndex++;
			}
			displayImages();
		});
	/****************
	 * Liste drag and drop
	 **********************/
	 $( "ul.droptrue" ).sortable({
	      connectWith: "ul"
	    });
	 $( "#sortable_dispo, #sortable_link" ).disableSelection();
	 /** Date Picker **/
	 $( "#datepicker" ).datepicker();
	 
	 /**************************
	  * Persistance
	  ************************/
	 function selectAll() {
		 $.ajax({
		    	url: 'https://api.mongolab.com/api/1/databases/imie_tpjs_portfolio/collections/folios?apiKey=b5wK_qlRZHhOMHIve4jc1DEI69PRBRdC',
				method: 'GET',
				dataType: 'json'
				}).done(function(data) {
					console.log(data);
					tabImg = []
					for (var d in data) {
						var img = new Image(data[d].data, data[d].title, data[d].desc, data[d].tags, data[d].filename, data[d].datecreation);
						img.setId(data[d]._id.$oid);
						console.log(img.getId());
						tabImg.push(img);
					}
				}).fail(function() {alert("affichage: bouh ca marche pas")})
				  .done(function() {displayImages(tabImg);});
	 }
	 
	 // Main loop;
	 initTagList();
	 selectAll();
});

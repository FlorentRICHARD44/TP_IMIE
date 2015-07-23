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
		var img_data = data;
		var img_title = title;
		var img_desc = desc;
		var img_tags = tags;
		var img_filename = filename;
		var img_datecreation = datecreation
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
		if ($('#modal #id').val() == '') { // New image
			tabImg.push(img);
		} else {  // Modification
			tabImg[parseInt($('#modal #id').val())] = img
		}
		displayImages(tabImg);
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
	function displayImages(images) {
		$('#imagelist').text('')
		for (var i in images) {
			if (i >= displayIndex && i < (displayIndex + nbImgDisplayed)) {
				$('#imagelist').append($('<div>').addClass('img')
											     .append($('<img>').attr('src', images[i].getData()))
											     .append($('<h3>').text(images[i].getTitle()))
											     .append($('<p>').text(images[i].getDesc()))
											     .append($('<p>').text(images[i].getFileName()))
											     .append($('<p>').text("Créé le : " + images[i].getDateCreation()))
											     .append($('<p>').text(images[i].getTags().join('; ')))
											     .append($('<button>').addClass('btn')
											    		 			  .attr('data_index', i)
											    		 			  .button({icons: {primary: "ui-icon-trash"},text:false})
											    		 			  .click(( function(copieIndex) {
											    		 			        return function() { 
											    		 			        	tabImg.splice(copieIndex, 1);
								    		 			  					  	displayImages(tabImg);}}) ( i )))
	    		 			  					 .append($('<button>').addClass('btn')
											    		 			  .attr('data_index', i)
											    		 			  .button({icons: {primary: "ui-icon-pencil"},text:false})
											    		 			  .click(( function(copieIndex) {
											    		 			        return function() { 
											    		 			        	$('#modal img').attr("src", tabImg[copieIndex].getData());
											    		 			        	$('#modal #title').val(tabImg[copieIndex].getTitle());
											    		 			        	$('#modal #desc').val(tabImg[copieIndex].getDesc());
											    		 			        	$('#modal #datepicker').val(tabImg[copieIndex].getDateCreation());
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
			displayImages(tabImg);
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
			displayImages(tabImg);
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
	 
	 // Main loop;
	 initTagList();
});

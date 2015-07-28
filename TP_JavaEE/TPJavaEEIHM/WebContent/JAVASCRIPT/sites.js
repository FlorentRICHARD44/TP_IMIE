/****************************************************************************
 * JavaScript code for the page sites
 * Author: Florent RICHARD
 ****************************************************************************/

/*****************************************************************************
 * Function: update the local list with all the sites.
 * Description: call the server to get the list in html format
 *              update the html to add the list from server
 ****************************************************************************/
function updateSiteList(selected) {
	$.ajax({url: 'api/sites',
			dataType: "json",
			method: 'GET'})
			.done(function(data){
						$('ol#listelocale').text('');
						for (var i in data) {
							var li = $('<li>').addClass("ui-selectee")
											  .attr("data-index", data[i].id)
											  .text(data[i].nom)
							$('ol#listelocale').append(li);
						}
						if (selected != undefined) {
							SelectSelectableElement($('#listelocale'),
									$("li[data-index='"+selected+"']"))
						}
					})
		    .fail(function(data){alert("problem getting sitelist")});
}
	
function SelectSelectableElement (selectableContainer, elementsToSelect)
{
    // add unselecting class to all elements in the styleboard canvas except the ones to select
    $(".ui-selected", selectableContainer).not(elementsToSelect).removeClass("ui-selected").addClass("ui-unselecting");
    
    // add ui-selected class to the elements to select
    $(elementsToSelect).not(".ui-selected").addClass("ui-selected");

}

/*****************************************************************************
 * Function: save the site created or modified
 * Description: call the server to save the site
 ****************************************************************************/
function siteSave(siteId) {
	$.ajax({url: 'api/sites/' + (siteId || -1),
			dataType: "json",
			contentType: "application/json",
			method: 'PUT',
			data: JSON.stringify({"id": siteId || -1,
				   "nom": $('div.displayzone input#sitename').val()})})
			.fail(function(){console.log("fail save")})
			.done(function(data){
						updateSiteList(data.id);
						getSite(data.id)});
}

/*****************************************************************************
 * Function: delete the site
 * Description: call the server to delete the site
 ****************************************************************************/
function siteDelete(siteId) {
	$.ajax({url: 'api/sites/' + siteId,
			method: 'DELETE'})
			.fail(function(data){$('p.error').removeAttr("hidden")
				                             .append(data.responseText)})
			.done(function(data){
					updateSiteList();
					$('div.displayzone').text('')});
}

/*****************************************************************************
 * Function: update the display zone with the informations for a site.
 * Description: call the server to get the site in html format
 *              update the html to add the site from server
 ****************************************************************************/
function getSite(siteId) {
	$.ajax({url: 'api/sites/'+siteId,
			dataType: "json",
			method: 'GET'})
			.done((function(copieSiteId) {
					return function(data){
						$('div.displayzone').remove();
						var sitediv = $('div.sitemodel').clone();
						$('div.sitemodel').after(sitediv)
						sitediv.removeClass("sitemodel").addClass("displayzone").removeAttr("hidden");
						$('div.displayzone input#sitename').val(data.nom);
						$('div.displayzone button#save').on('click', function() {siteSave(copieSiteId)});
						$('div.displayzone button#del').on('click', function() {siteDelete(copieSiteId)});
						$('p.error').attr('hidden', 'true');
							}
					})(siteId))
			.fail(function(data){window.location.href = "sites"});
}



//JQuery abonnements
$(function() {
	/*****************************************************************************
	 * List Selectable: set local list as selectable with only 1 element selected
	 * 			   set the function to do on select.
	 ****************************************************************************/
	$('.selectable').selectable({
		selected: function(event, ui) {
			$(ui.selected).addClass("ui-selected")
						  .siblings().removeClass("ui-selected").each(
                function(key,value){
                    $(value).find('*').removeClass("ui-selected");
                }
            );
		getSite($(ui.selected).attr("data-index"));
        }});
	/*****************************************************************************
	 * Button: new site
	 * 		   update the display zone with the informations for a new site.
	 * Description: call the server to get new site in html format
	 *              update the html to create new site from server
	 *****************************************************************************/
	$('#new').on('click', function newSite() {
		$.ajax({url: 'sites',
				method: 'POST'})
				.done(function(data){
						if (data.redirect) {
							window.location.href = data.redirect;
						} else {
							$('div.displayzone').text('')
											    .append(data);
							$('div.actionzone button#save').on('click', function() {siteSave()})}
				})
				.fail(function(data){alert("problem site")});
	});
	

	/*****************************************************************************
	 * MAIN
	 * Contains the main function.
	 ****************************************************************************/
	updateSiteList();
})



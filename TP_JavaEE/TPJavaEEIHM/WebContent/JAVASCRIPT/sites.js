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
	$.ajax({url: 'sites?sitelist=true',
			method: 'GET'})
			.done(function(data){$('ol#listelocale').text('')
												.append(data);
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
	$.ajax({url: 'sites',
			method: 'PUT',
			data: {"id": siteId || "null",
				   "nom": $('input#sitename').val()}})
			.fail(function(){console.log("fail save")})
			.done(function(data){
						var id = data.substr(0, data.length - 1);
						updateSiteList(id);
						getSite(id)});
}

/*****************************************************************************
 * Function: delete the site
 * Description: call the server to delete the site
 ****************************************************************************/
function siteDelete(siteId) {
	$.ajax({url: 'sites',
			method: 'DELETE',
			data: {"id": siteId}})
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
	$.ajax({url: 'sites?site='+siteId,
			method: 'GET'})
			.done((function(copieSiteId) {
					return function(data){
							$('div.displayzone').text('')
											    .append(data);
							$('div.actionzone button#save').on('click', function() {siteSave(copieSiteId)});
							$('div.actionzone button#del').on('click', function() {siteDelete(copieSiteId)});
							$('p.error').attr('hidden', 'true');
							}
					})(siteId))
			.fail(function(data){alert("problem site")});
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



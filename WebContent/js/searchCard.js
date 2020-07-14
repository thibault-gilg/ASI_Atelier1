//Valeurs par défaut de la carte à l'arrivée sur la page

$(document).ready(function(){
	
$("#add").click(function(){
	window.location.replace("http://localhost:8080/WebServiceCard/add");
});
	
var family = $("#cardFamilyNameId").text().trim();

if(family === "DC"){
	$('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
}
else if (family === "Marvel"){
	$('#cardFamilyImgId')[0].src="https://i.pinimg.com/originals/d6/53/a2/d653a29546d9f951bcdaa4502a4e5502.jpg";
}

$( "#buttonForm" ).click(function() {
	  $( "#form" ).submit();
	});

$("#form").submit(function(event){
	
	event.preventDefault();
	
	var name = $("#input_image").val();
	
	$.get( "http://localhost:8080/WebServiceCard/rest/servicescard/find?name=" + name, function( data ) {
		  if(data != null){
			  
			  $("#errorbanner").hide();
			  
			  var json = data;
			  if(json.family === "DC"){
					$('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
				}
				else if (json.family === "Marvel"){
					$('#cardFamilyImgId')[0].src="https://i.pinimg.com/originals/d6/53/a2/d653a29546d9f951bcdaa4502a4e5502.jpg";
				}
			  
			  $('#cardFamilyNameId')[0].innerText=json.family;
			  $('#cardImgId')[0].src=json.imgUrl;
			  $('#cardNameId')[0].innerText=json.name;
			  $('#cardDescriptionId')[0].innerText=json.description;
			  $('#cardHPId')[0].innerText=json.hp;
			  $('#cardEnergyId')[0].innerText=json.energy;
			  $('#cardAttackId')[0].innerText=json.attack;
			  $('#cardDefenceId')[0].innerText=json.defence;
		  }
		  
		  else {
			  $("#errorbanner").show();
		  }
		  
		  
		});
	});
	
});
	








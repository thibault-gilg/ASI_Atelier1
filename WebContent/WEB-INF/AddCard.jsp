<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" type="text/css" href="js/Semantic-UI-CSS-master/semantic.min.css">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Add Card</title>
</head>
<body>

<%
if(request.getAttribute("error") != null) {
%>	
	<div class="ui negative message" id = "errorbanner">
		<div class="header">
			${ error }
		</div>
	</div>
<%
}
%>

<%
if(request.getAttribute("success") != null) {
%>	
	<div class="ui positive message" id = "errorbanner">
		<div class="header">
			${ success }
		</div>
	</div>
<%
}
%>

<div class="ui five column grid">
            <div class="row"></div>
            <div class="column"></div>
            <div class="column"></div>
            <div class="column">
                <form class="ui form" action="./addData" method="GET">
                    <h3 class="ui dividing header">Add Card</h3>
                    <div class="field">
                        <label>Name</label>
                        <input type="text" name="Name" placeholder="Name">
                    </div>
                    <div class="field">
                        <label>Description</label>
                        <input type="text" name="Description" placeholder="Description">
                    </div>
                    <div class="field">
                        <label>Family</label>
                        <input type="text" name="Family" placeholder="Family">
                    </div>
                    <div class="field">
                        <label>Hp</label>
                        <input type="number" name="Hp" placeholder="Hp">
                    </div>
                    <div class="field">
                        <label>Energy</label>
                        <input type="number" name="Energy" placeholder="Energy">
                    </div>
                    <div class="field">
                        <label>Attack</label>
                        <input type="number" name="Attack" placeholder="Attack">
                    </div>
                    <div class="field">
                        <label>Defence</label>
                        <input type="number" name="Defence" placeholder="Defence">
                    </div>
                    <div class="field">
                        <label>Image</label>
                        <input type="text" name="Url" placeholder="Url">
                    </div>
                    
                   
                    <button class="ui button" type="submit" >Submit</button>
                </form>
            </div>
        </div>
</body>
</html>
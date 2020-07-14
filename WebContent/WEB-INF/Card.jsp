<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" type="text/css" href="js/Semantic-UI-CSS-master/semantic.min.css">
<link rel="stylesheet" type="text/css" href="css/Card.css">

<title>Card</title>
 
</head>
<body>


<div class="ui negative message" id = "errorbanner">
		<div class="header">
			No card found
		</div>
</div>


<div class="ui five column grid">
	  <div class="row"></div>
	  <div class="row"></div>
      <div class="row">
      <div class="column"></div>
      <div class="column"></div>
      <button class="ui button" id = "add">Add card</button>
      </div>
      <div class="row">
          <div class="five column"></div>
      </div>
      <div class="column"></div>
      <div class="column"></div>
      <div class="column">
           <form class="ui form" action="#" name="mySearch" id = "form">
              <h3 class="ui dividing header">Select the Card Name to Search</h3>
              <div class="two fields">
                  <div class="field">
                      <label>Card Name</label>
                  </div>
                  <div class="field">
                      <div class="ui transparent icon input">
                          <input id = "input_image" type="text" placeholder="Search..." name="search">
                           <i class="search link icon" id = "buttonForm"></i>
                      </div>
                  </div>
              </div>
          </form>
      </div>
      <div class="column"></div>
      <div class="column"></div>
  </div>
  <!------------------------------------------------------------------------->
  <!--    ----------------------------- CARD ----------------------------- -->
  <!------------------------------------------------------------------------->

  <div class="ui five column grid">
      <div class="column"></div>
      <div class="column"></div>
      <div class="column">
          <div class="ui special cards">
              <div class="card">

                  <div class="content">
                      <img id="cardFamilyImgId" class="ui avatar image" src=""> <span id="cardFamilyNameId">${ family }</span>
                  </div>
                  <div class="image imageCard">
                      <div class="blurring dimmable image">
                          <div class="ui inverted dimmer">
                              <div class="content">
                                  <div class="center">
                                      <div class="ui primary button">Add Friend</div>
                                  </div>
                              </div>
                          </div>
                          <img id="cardImgId" class="ui centered tiny image" src=${ url }>
                      </div>
                  </div>
                  <div class="content">
                      <div class="ui form tiny">
                          <div class="field">
                              <label id="cardNameId"></label>
                              <textarea id="cardDescriptionId" class="overflowHiden"  rows="5">${ description }</textarea>
                          </div>
                      </div>
                  </div>
                  <div class="content">
                      <i class="heart outline icon"></i><span id="cardHPId">${ hp }</span> 
                      <div class="right floated ">
                          <i class="lightning outline icon"></i>
                          <span id="cardEnergyId">${ energy }</span> 
                      </div>
                  </div>
                  <div class="content">
                      <span class="right floated">
                          <i class=" wizard icon"></i>
                          <span id="cardAttackId">${ attack }</span> 
                      </span>
                      <i class="protect icon"></i>
                     <span id="cardDefenceId">${ defence } </span> 
                  </div>

              </div>
          </div>
      </div>
  </div>
  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/Semantic-UI-CSS-master/semantic.js"></script>
  <script src="js/searchCard.js"></script>
</body>
</html>
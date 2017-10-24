<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Map</title>
<style>
 #map {
   width: 100%;
   height: 400px;
   background-color: grey;
 }
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
		<ul class="nav" style="margin-right: auto !important;">
			<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/">Medivise</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/questions/">Forum</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/map/">Map</a></li>
		</ul>
		<c:if test="${username != null}">
			<span class="navbar-text"> <a href="${pageContext.request.contextPath}/profile/">${username}</a> </span>
		</c:if>
		<c:if test="${username == null}">
			<span class="navbar-text"><a href="${pageContext.request.contextPath}/login/">login</a></span>
		</c:if>
	</nav>

<div id="map"></div>
<script>
      function initMap() {
        var sydneyUni = {lat: -33.51, lng:151.124  };
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 14,
          center: sydneyUni
        });
      
        
      addMarker({
    	coords:{lat: -33.51, lng:151.126},
    	content:'<h2>Reservation with Doctor Wilkinson on 15:00, Tuesday</h2>'
      	});
    
      
      addMarker({
      	coords:{lat: -33.52, lng:15.127},
      	content:'<h2>Reservation with Doctor Archibald on 10:00, Thursday</h2>'
        });
        
        addMarker({
      	coords:{lat: -33.515, lng:151.23},
      	content:'<h2>Reservation with Doctor Waldarf on 14:00, Wednesday</h2>'
        });

      addMarker({
        	coords:{lat: -33.53, lng:151.128},
        	content:'<h2>Reservation with Doctor Wonderwooson on 11:00, Monday</h2>'
        });
          
         addMarker({
        	coords:{lat: -33.512, lng:151.125},
        	content:'<h2>Reservation with Doctor Wonderwooson on 11:00, Monday</h2>'
        });
          
      addMarker({
      	coords:{lat: -33.525, lng:151.2},
      	content:'<h2>Reservation with Doctor Waldarf on 14:00, Wednesday</h2>'
        });
        
      
      function addMarker(props){
    	  var marker = new google.maps.Marker({
              position: props.coords,
              map: map
        });
        if (props.content){
          var infoWindow = new google.maps.InfoWindow({
            content:props.content
          });
          
          marker.addListener('click',function(){
            infoWindow.open(map,marker);
          });
        }
      }
      }
    
</script>

<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-wYiKDzv4-JkZowD-RHEDFnXg1tVZlu4&callback=initMap">
</script>

</body>
</html>
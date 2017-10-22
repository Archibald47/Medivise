<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<div id="map"></div>
<script>
      function initMap() {
        var sydneyUni = {lat: -33.51, lng:151.124  };
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: sydneyUni
        });
        var marker = new google.maps.Marker({
          position: sydneyUni,
          map: map
        });
      }
</script>

<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-wYiKDzv4-JkZowD-RHEDFnXg1tVZlu4&callback=initMap">
</script>

</body>
</html>
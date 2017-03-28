var map;
function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 4.6672158, lng: -74.0573577},
    zoom: 17,
    styles: [
        {
            "featureType": "all",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "weight": "2.00"
                },
                {
                    "lightness": "-30"
                },
                {
                    "saturation": "-13"
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "geometry.stroke",
            "stylers": [
                {
                    "color": "#4099ac"
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.text",
            "stylers": [
                {
                    "visibility": "on"
                },
                {
                    "hue": "#ff5b00"
                },
                {
                    "saturation": "33"
                },
                {
                    "lightness": "12"
                },
                {
                    "gamma": "1.08"
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "visibility": "on"
                }
            ]
        },
        {
            "featureType": "landscape",
            "elementType": "all",
            "stylers": [
                {
                    "color": "#f2f2f2"
                },
                {
                    "visibility": "on"
                }
            ]
        },
        {
            "featureType": "landscape",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "color": "#ffffff"
                }
            ]
        },
        {
            "featureType": "landscape.man_made",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "color": "#ffffff"
                },
                {
                    "visibility": "on"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "all",
            "stylers": [
                {
                    "visibility": "simplified"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "geometry",
            "stylers": [
                {
                    "visibility": "simplified"
                },
                {
                    "color": "#eaeaea"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "visibility": "on"
                },
                {
                    "color": "#c4e1d4"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "geometry.stroke",
            "stylers": [
                {
                    "visibility": "on"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "labels",
            "stylers": [
                {
                    "visibility": "simplified"
                },
                {
                    "hue": "#00ff85"
                },
                {
                    "saturation": "-59"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "visibility": "simplified"
                },
                {
                    "hue": "#00ff79"
                },
                {
                    "saturation": "-39"
                },
                {
                    "weight": "1.00"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "labels.text.stroke",
            "stylers": [
                {
                    "visibility": "simplified"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "labels.icon",
            "stylers": [
                {
                    "visibility": "simplified"
                },
                {
                    "hue": "#00ff57"
                },
                {
                    "saturation": "-43"
                }
            ]
        },
        {
            "featureType": "road",
            "elementType": "all",
            "stylers": [
                {
                    "saturation": "-100"
                },
                {
                    "lightness": 45
                }
            ]
        },
        {
            "featureType": "road",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "color": "#dedddd"
                }
            ]
        },
        {
            "featureType": "road",
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "color": "#4f4e4e"
                }
            ]
        },
        {
            "featureType": "road",
            "elementType": "labels.text.stroke",
            "stylers": [
                {
                    "color": "#ffffff"
                }
            ]
        },
        {
            "featureType": "road.highway",
            "elementType": "all",
            "stylers": [
                {
                    "visibility": "simplified"
                },
                {
                    "saturation": "19"
                },
                {
                    "hue": "#0fff00"
                },
                {
                    "gamma": "0.36"
                },
                {
                    "lightness": "1"
                },
                {
                    "weight": "1.45"
                }
            ]
        },
        {
            "featureType": "road.arterial",
            "elementType": "labels.icon",
            "stylers": [
                {
                    "visibility": "off"
                },
                {
                    "hue": "#ff0000"
                },
                {
                    "saturation": "66"
                },
                {
                    "gamma": "1.75"
                },
                {
                    "lightness": "-19"
                },
                {
                    "weight": "1.94"
                }
            ]
        },
        {
            "featureType": "transit",
            "elementType": "all",
            "stylers": [
                {
                    "visibility": "off"
                }
            ]
        },
        {
            "featureType": "water",
            "elementType": "all",
            "stylers": [
                {
                    "color": "#25a9df"
                },
                {
                    "visibility": "on"
                }
            ]
        },
        {
            "featureType": "water",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "color": "#a5d8e7"
                }
            ]
        },
        {
            "featureType": "water",
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "color": "#070707"
                }
            ]
        },
        {
            "featureType": "water",
            "elementType": "labels.text.stroke",
            "stylers": [
                {
                    "color": "#ff0000"
                }
            ]
        }
    ]
  });

  var iconBase = 'img/vector/';
  var icons = {
    cover: {
        icon: iconBase + 'Cover.png'
    },
    freebar: {
        icon: iconBase + 'All.png'
    },
    normal: {
        icon: iconBase + 'Drink.png'
    }
  };

  function addMarker(feature) {
    var marker = new google.maps.Marker({
        position: feature.position,
        icon: icons[feature.type].icon,
        map: map
    });
  }

  $.get("/bares").then(function(data){
    var features=[];
    for(var i = 0; bar=data[i] ; i++){
        //console.log(bar);
        features.push({
            position: new google.maps.LatLng(bar.latitud, bar.longitud),
            type: bar.tipo
        });
    }
    for (var i = 0, feature; feature = features[i]; i++) {
        //console.log(feature);
        addMarker(feature);
    }
  });
  /*var features = [
    {
      position: new google.maps.LatLng(4.669070, -74.055216),
      type: 'cover'
    }, {
      position: new google.maps.LatLng(4.668912, -74.055302),
      type: 'freebar'
    }, {
      position: new google.maps.LatLng(4.667749, -74.053687),
      type: 'normal'
    }
  ];

  for (var i = 0, feature; feature = features[i]; i++) {
    addMarker(feature);
  }*/

  var infoWindow = new google.maps.InfoWindow({map: map});

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(position) {
        var pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };

        infoWindow.setPosition(pos);
        infoWindow.setContent('Location found.');
        map.setCenter(pos);

      }, function() {
        handleLocationError(true, infoWindow, map.getCenter());
      });
    } else {
      // Browser doesn't support Geolocation
      handleLocationError(false, infoWindow, map.getCenter());
    }
  }

  function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Error: The Geolocation service failed.' :
                          'Error: Your browser doesn\'t support geolocation.');
}
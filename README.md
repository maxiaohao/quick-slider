quick-slider
============

Create slider pages (or solo page) containing arbitrarily configurable items without coding. In the easy 3-level model of container-slider-item, every item is simply rendered as an html <div> tag into which you can insert any html tags and css styles - with all the things configured in a json file only.

### Build
Prerequisites: You should have GNU make, Java 6+, gradle 1.0+ and latest npm installed. 
`make init && make war` will create the war file suitable for running in a Java servlet container. 

### Run
`make run` will simply run quick-slider on a jetty server.
Configuration files (json format) should be put under folder `${user.home}/.quick-slider/` named `container-1.json`,`container-2.json`,etc. Copy the one from `example` would be a good start.
You may modify the json conf file on the fly.
To access the page, go to `http://localhost:8080/quick-slider` in your browser and you'll find container 1 (default container) is loaded. You may also specify the container to render by passing container id like `http://localhost:8080/quick-slider?container_id=2`. 

 RESTful application that presents the RSS feed from URL http://mediaweb.musicradio.com/RSSFeed.xml?Channel=9172
================================================================================================================

###1. Technologies used
* Spring 4.2.2.RELEASE
* Jackson 2.6.3
* Rome 1.5.0
* Maven 3

###2. To Run this project locally
```shell
$ mvn jetty:run
```
To load all resources open browser and use ```http://localhost:8080/global ```
To load every other resource use ```http://localhost:8080/global/alternate ```
To load a single resource by id use ```http://localhost:8080/global/2d755545-16cf-4d96-8df9-ea81ecc12305 ```
To load most recent resource use ```http://localhost:8080/global/latest ```

The output is best viewed in Firefox with the JSONView plugin
The REST calls have not been cached, we could use something like REDIS for this.

###3. To import this project into Eclipse IDE
1. ```$ mvn eclipse:eclipse```
2. Import into Eclipse via **existing projects into workspace** option.
3. Done.


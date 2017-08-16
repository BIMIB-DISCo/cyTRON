# Documentation
The workspace is logically divided into five packages:
* [R](https://github.com/BIMIB-DISCo/cyTRON/tree/master/src/main/java/it/unimib/disco/bimib/cyTRON/R) manages the connection between Java and the R instance;
* [controller](https://github.com/BIMIB-DISCo/cyTRON/tree/master/src/main/java/it/unimib/disco/bimib/cyTRON/controller) contains a controller for each section of the main view;
* [cytoscape](https://github.com/BIMIB-DISCo/cyTRON/tree/master/src/main/java/it/unimib/disco/bimib/cyTRON/cytoscape) loads and formats the networks imported in Cytoscape;
* [model](https://github.com/BIMIB-DISCo/cyTRON/tree/master/src/main/java/it/unimib/disco/bimib/cyTRON/model) replicates the model of the TRONCO objects;
* [view](https://github.com/BIMIB-DISCo/cyTRON/tree/master/src/main/java/it/unimib/disco/bimib/cyTRON/view) contains the visual interface.

In addition, the classes [CyActivator.java](https://github.com/BIMIB-DISCo/cyTRON/blob/master/src/main/java/it/unimib/disco/bimib/cyTRON/CyActivator.java) and [MenuAction.java](https://github.com/BIMIB-DISCo/cyTRON/blob/master/src/main/java/it/unimib/disco/bimib/cyTRON/MenuAction.java) instantiate the application in the **Apps** menu of Cytoscape.

### Framework
As suggested by the packages' names, the application exploits the MVC framework.

### Class Diagrams
In order to have a better overview of the classes and their relations, we also report three class diagrams, one for each component of the MVC:
* [model](https://github.com/BIMIB-DISCo/cyTRON/blob/master/docs/Model.png);
* [view](https://github.com/BIMIB-DISCo/cyTRON/blob/master/docs/View.png);
* [controller](https://github.com/BIMIB-DISCo/cyTRON/blob/master/docs/Controller.png).

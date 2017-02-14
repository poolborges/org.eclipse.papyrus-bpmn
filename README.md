# BPMN
A Papyrus DSML for the BPMN OMG norm

### Repository structure ###

This repository is organized around logical software components:

* `releng`: Elements related to the creation of the rcp, update-site

### How to build ###

Components in this project are built using Maven and its Tycho plugin for the build of Eclipse artifacts.
To build locally, simply execute the command line:

```
mvn clean install
```

### Building for Eclipser server ###

If you want to pack and sign the project, you have to use the following profiles:

```
-Peclipse-pack
```

and

```
-Peclipse-sign
```

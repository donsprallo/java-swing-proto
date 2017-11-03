#!bin/bash

javac Application.java engine/CoreBase.java engine/CoreEvent.java simulator/Core.java simulator/ViewBase.java simulator/ViewInterface.java simulator/ViewUIComponentBase.java simulator/view/CommandlineView.java simulator/view/SteuerkursKompassView.java simulator/view/SteuerkursView.java simulator/model/KompassModel.java simulator/controller/KompassControllerInterface.java simulator/controller/KompassController.java

java Application

rm Application.class engine/CoreBase.class engine/CoreEvent.class simulator/Core.class simulator/ViewBase.class simulator/ViewInterface.class simulator/ViewUIComponentBase.class simulator/view/CommandlineView.class simulator/view/SteuerkursKompassView.class simulator/view/SteuerkursView.class simulator/model/KompassModel.class simulator/controller/KompassControllerInterface.class simulator/controller/KompassController.class


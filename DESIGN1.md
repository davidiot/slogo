#Design for SLogo Project

##Introduction
For this project, our team is attempting to develop an integrated development environment (IDE) for the Logo programming language in Java. Our code should be able to translate basic text commands into their corresponding actions displayed on the GUI. It should also store defined functions, history, and variables. The main design goal of this project is to develop a front end and back end that are flexible enough to add extra features or extend to different languages besides Logo. It should be most flexible in its implementation of translating commands, so users can be creative with their coding. It should also be flexible in the display to accommodate different situations or modifications to what is being presented. The primary architecture of our program starts in the front end where users can input commands to the IDE. The back end will then parse and translate the commands, perform the commands on the actor, and update the visuals in the front end. The back end will also store the inputs in the history to be displayed in the front end. If variables or functions were defined, they will also be displayed in the user interface. The basic layout of the front end should be closed to modification. There is a possibility that the visual display of the Logo commands will have to be modified, so this will be open to extensions. In the back end, the parsing of the code should remain closed, but translating the commands should be open.

##Overview
Our four API’s are as follows: an API that the back end will be building, an API that the front end will be building, an API that allows those two ends to meet, and an API that will be put in place for future developers who wish to extend the project.

The front end API is the collection of all public methods on the front end that can be called by other parts of the program, most notably the back end, and specifically the executor on the back end that runs after the commands have been parsed and interpreted. The back end API will have fewer public methods since its main function will be to parse the commands and execute them on the click of the run button. The API that allows the two ends to communicate will be the collection of all the methods that, for instance, allow the back end to set history, custom commands, and variables. It was decided that variables would be on the back end so as to allow the interpreter to access these values when executing these commands.

The first front end API, which contains the public methods accessible by the back end, includes methods for changing elements of the screen and displaying errors.  There will be methods for updating the history, updating the variables, and updating the commands  (these are the three interactive lists that will appear on the right side of the screen).  There will also be a several methods for updating the map, including:
* setAngle(): sets the direction that the turtle is facing
* setCoordinate(): sets a new destination direction for the turtle
* setPen(): toggles the pen up or down
* setVisible(): make turtle invisible or visible
* home(): makes the turtle head home
* clear(): clears the screen and calls home

Finally, there will be a showError() method that the backend can use for generating error messages.  These error messages will appear on the screen as pop-up windows; if there are other elements of the screen that should be highlighted, such as obstacles on the map or other errors that could come up in extensions of this project, the showError() method will handle those cases as well.

The second front-end API, which contains the tools required for extension of our program, includes all of the abstract classes and interfaces that will be used to create our initial project. Specifically, this includes the AbstractScreen and RootManager classes, which allow for the creation of a menu system and easy switching between screens, as well as the element system, which allows a developer to easily populate the locations of the screen with elements that have a defined purpose. These elements will be an abstract class that will be extended to create the console, map, and lists that comprise the user interface.  The lists themselves will be extended from a second abstract class that will allow further creation of more lists.  For the map itself, we will also make the turtle into an interface to allow for the creation of turtles with different properties or multiple turtles on the screen.  

![Design Overview](https://github.com/duke-compsci308-fall2015/slogo_team10/blob/master/Images/1.png)

The back-end of our project is essentially just an interpreter for the SLogo language commands. The main functionality of the of the backend is to take in some command expressed as a string and translate this command to actual function calls on a front-end interface. For this reason, our initial design for our external API is represented by a function interpret(String input) which takes some string as a parameter. Because users can create and define their own functions and variables, the backend must also manage the variables and commands that the  user has created in the past. We discussed a number of possible designs but in the end, we came to the conclusion that the most efficient way to implement the interpretation of commands would be to form a tree abstraction. 

This means that the first step every time of interpreting an input is to build our tree, checking at each command we read in that the command syntax is correct in an of itself. When an input is submitted to the back-end using the interpret() function, the interpreter will create a new commandTree object. This object has a root Node from which all SLogo commands that are part of the inputted string will branch off. The inputting string will be split and parsed in order. Each “command” in the inputted string will be represented by a Node in the tree. Each child of every node represents a parameter to that “command.” An example is presented below:

![Back end](https://github.com/duke-compsci308-fall2015/slogo_team10/blob/master/Images/2.png)

As the tree is built it will be checked for correct syntax. We plan to have all “commands” (meaning both default commands like FORWARD, RIGHT, and PENUP and user created commands) easily accessible by their name (mostly likely implemented by a map structure) . This means that as the inputting string is parsed while building the tree, each command can be checked to ensure that it is a legitimate SLogo command. In a similar manner, any variables mentioned in the inputting string can be checked to ensure that they have been created and form legitimate Slogo code. If a command used in the input string is not defined, the execution of the command will be terminated and an error will be sent to the frontend. If a non-defined variable is used, a value of 0 will be used in its place.

Once the tree has been built we can analyze whether the syntax for each of the “commands” in the tree is correct by calling a treeComplete() function. What this method will do is ensure that each of the commands has the proper number of children. If the tree is not complete, then the syntax of the inputting string is wrong, assuming that our implementation of the tree-building algorithm is correct. Again, the execution will be terminated, and an error will be sent to the front-end. 

Once the tree has been checked for the proper syntax, the commands in the tree will be executed. Execution will occur recursively, and each node must have an execute() method. This execute() method will in turn call execute() on all of the children of the a node (in the correct order). After all of its children nodes have executed, a node will then have access to all of its necessary parameters (return values of the its children). The node itself can then be executed.

We decided that all of the commands that are implemented will be kept in classes separate from the nodes. These will be objects which all extend from a class “Action.” For instance, when a node representing a FORWARD command in the tree is executed, it must first ensure it has its necessary parameter (by calling execute on its child). It can then call a method in its corresponding FORWARD action object called performAction(). It is in this method in the Action that the actual calls to change the front end display are made.

We  decided that all elements of the SLogo syntax will be stored in the tree as nodes. This means that commands such as IF, REPEAT, DOTIMES, and FOR will also be represented by nodes. The children of these nodes will only be executed if a condition is met (in the case of IF) or executed multiple times (in the case of REPEAT, DOTIMES, or FOR). The TO command, which creates a new user defined function, will represent a special case in which the subtree below this node will be created but not executed, instead it will be added as an action.

##User Interface
The user interface of this program will include a menu system for navigating through the various screens of the program and a pane system for separating the main screen of the program into parts.  The menu system uses a wrapper class for a scene called a Screen, which has a loop method for running the screen (this is used for the timeline) as well methods that point to the next Screen to be run.  A RootManager in the background keeps track of the pointer to the next Screen; when it is no longer null, the scenes will switch.  This is managed by the code below in RootManager:

```Java
  public void run() {
  	currentScreen.run();
  	if (currentScreen.getNextScreen() != null) {
  		currentScreen = currentScreen.getNextScreen();
  		stage.setScene(currentScreen.getScene());
  		stage.show();
    }
  }
```

This system allows for easy switching between scenes and allows for an interactive menu system that will allow the user to return to the menu to visit the settings and help pages.
In the screen specific to the Slogo simulation, we will separate the screen into different components using an Abstract class or interface we are currently calling an element; this is essentially a wrapper class for a pane and will allow us to partition the Slogo screen into several sections with dedicated tasks.  There will be a map element, a console element, and three elements for the variables, commands, and history lists.  The user will be able to interact with all of the elements except possibly the map, but because the map is its own component, we can easily add interaction to the map (for example, clicking a location of the map can print those x and y coordinates onto the console).  The console will have a run that calls the backend API using the current input in the console as well as a clear button for erasing the input.  The elements of the history, command, and variable lists will also be clickable and will produce the actions specified in the assignment page.  There will also be buttons that lead to the help and settings screens at the top right corner; these will use the RootManager system to switch screens.  Finally, error messages will be displayed using notification boxes that appear whenever the backend calls the showError method of the front end.

Presented below are two basic templates from our planning meeting regarding the front end.  Please refer to the image in the overview section for the look of the UI and the position of each of the elements on the screen.

![UIClss](https://github.com/duke-compsci308-fall2015/slogo_team10/blob/master/Images/3.png)

![UIClass2](https://github.com/duke-compsci308-fall2015/slogo_team10/blob/master/Images/4.png)

##Design Details
The first thing we decided was necessary to have was an abstract Action class that can be extended for different types of commands that can be input into the console. The types of commands are math commands, logic commands, and Turtle commands. An Action object is created using a constructor that takes in a GUIController interface. The Action object also has an abstract method called doAction(List parameters) that checks if the number of parameters given in the list is the amount required for the command, and then calls the appropriate method within GUIController, which is the middleman between the front end and backend.

In the case of a Turtle Actions (the types of Actions that are executed on a Turtle, such as FORWARD, and RIGHT), this method would be a getTurtle() method which would return the Turtle, thus granting the backend access to methods within the Turtle that would be called to make it move forward, rotate, move backward, etc... 

These Action objects’ doAction() command will be called within the Node of our Action tree. This brings us to the commandTree, the syntax tree discussed above. The tree is represented by its root Node, which branches off into different Nodes each having a specific number of children representing the parameters that the Action within the Node needs in order to execute. The Node is an abstract class that contains the following instance variables: a List of children called myChildren, a String of its name called myName, a List of its parameters called myParameters, an Action myAction, and an integer numChildrenRequired, which represents the number of children, or parameters, that this node needs in order to execute.

The name of the Node is set by the kind of command that it is representing: this command would be read in from the input String and, upon the creation of the Node, the Node’s myName instance variable would be set to the type of command. This string is then used to create the appropriate instance of Action using reflection. Upon the creation of the Node as well, the numChildrenRequired instance variable is set to the number of parameters required by the Action object’s main doAction() method. This would be used later to ensure that the tree is complete. 

The execute() command would recursively call the execute() commands within other Node objects until the base case of a Node having integer parameters is reached. The execute command thus contains a doAction(parameters) method call which is defined inside the Node, and what this does is that it calls the Node’s doAction() method which returns an integer. 

Example code for this would is shown below:

In Action Class:

```Java
execute() {
for (Node child: myChildren){
myParameters.add(child.execute());
}
return performAction(myParameters) //myParameters is now a complete list of parameters required by the command

performAction(List params){
\\ reflection myAction = appropriateActionType;
return myAction.doAction(params);
}
```

An Interpreter class contains an interpret method which takes in a string input and sends it to a parser. The parser splits the string by whitespace and creates new Action objects using reflection for every command prefix found in the array and creates a Node containing that Action object. The parser would then check to see how many children that Action is required to have, and then moves on to create the children of that Node by creating new Nodes of whatever comes after the command prefix in the list and adding them the myChildren List. Reaching the an integer (or variable) is the base case for this method after which it returns to the parent. 

Trees that are built are not stored. Instead, if they were built successfully and the treeComplete() method called with a ‘true’ return statement, then the string input that resulted in the creation of the tree would be added to the history space in the model. 

Example code for “fd 50” input command:

```java
interpret(“fd 50”).execute();

interpret(“fd 50” ){  //returns Node root;
      split(“fd 50”); 
      return parse(“fd 50”) // returns root Node
}

execute() {
… … // same as code shown above.
return performAction(parameters); // parameters is a list containing an integer 50;
}

// performAction(parameters) will return 50; will call myAction.doAction where myAction is an instance of moveForward.

// in moveForward:
double doAction(List parameters){
	turtle.moveForward(parameters);
	return parameters.get(0);
}

// in Turtle:
void moveForward(parameters){
	getMyVisual.setX(getMyVisual.getX() + parameter.get(0));
	drawTrail(true, parameters.get(0));
}

void drawTrail(boolean penDown, double length) {
	if (penDown) {
	Rectangle line = makeLine(length);
	getRoot().getChildren().add(line)
}

Rectangle makeLine(double length){
	Rectangle line = new Rectangle(lineThickness, length);
	setLocation(line);
return line;
}

```
Specific notes regarding the four APIs are presented below:
 
Front End Internal API:
 
Screens:  The AbstractClass screen is designed to be extended to create every screen that shows up in the program.  It works specifically with the RootManager to allow for easy switching between different screens.  This allows us to create a help screen and a settings screen and integrate it into the menu with ease.  It can be easily extended to create any other kind of screen required for this project (i.e. a “write your own language” screen).  This class allows for separation between the code for each screen while allowing the methods unique to all of them to be shared.
 
Elements: These classes are designed to be extended into any kind of screen element that the user could want to include on a Screen.  They will be instantiated in a Screen’s constructer, and they will have GridPanes that are placed onto the Screen’s scene when the Screen is instantiated.  This class is meant to allow for easy communication between the Screen and its elements, and to allow for easy separation between the elements of the screen.  This class allows for each of the screen elements to behave autonomously and allows for organization of the code into specific functions.
 
Turtle: Creating a separate class for the turtle will allow for easy extension into turtles with different behaviors or multiple turtles on the screen.  It will exist on the map and require information from the map to find the home location and determine what happens when the user attempts to send the turtle out of bounds.
 
Front End Public API:
 
The methods from the front end, described in the overview, are meant to allow the backend to update the front end while abstracting the details of what is appearing on the front end.  This will prevent the back end from breaking the front end, and will allow for development of the front end and back end to occur separately by two different teams.  It should also be relatively simple to create new methods that update the front end in new ways.

##Design Considerations
When thinking about possible designs for the overall project, we started by thinking about a MVC design with the majority of the functions in the controller sections. The model would only contain information such as the history, information for the display, defined functions, etc. The view would only format/display information and take in user inputs. The controller was the connection between the view and the model. The view would take in user input and pass basic information to the controller. The controller would then do everything and modify corresponding information in the model. Finally, the controller would update the view with the new data. We decided that although this minimized the interactions needed between the three sections of the MVC model, it resulted in all of the functions being placed into one area, the controller, and did not result in a clear separation of the frontend and backend of our application. Instead of this, we considered centering our design around a distinct front end and back end, without prescribing to a preset model such as the MVC. The frontend functionality deals with passing text entered into the console to the backend, updating the visuals, and updating the map once the backend parses the commands to their appropriate actions. The backend is primarily in charge of parsing text and translating them into actions that will be executed on the front end. It also updates the history of commands as well as the variables and functions defined. In this way, we have made a clear distinction between front and backend, allowing for a clearer delineation of our API structures. This will allow us to more clearly choose our public methods within the backend and frontend and create a more distinct API components.

##Team Responsibilities
David and Daniel P are working on the front end

Daniel M and Michael are working on the backend, which includes parsing commands and interpreting them, then issuing the correct actions to the front end visual elements. The backend also involves checking to see if commands are syntactically correct, and saving them to a history storage space if they are. The same process goes with defining custom commands: if the custom commands are able to be interpreted correctly, then they are deemed syntactically correct and only then would they be saved in the custom commands storage space. Therefore this team will be working with the model as well as the application controller which contains the logic that parses and interprets commands. 





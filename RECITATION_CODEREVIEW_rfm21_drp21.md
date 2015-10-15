#Code Review of SLogo 
##Reviewed by Rob Martorano (rfm21) for Daniel Pak (drp21)

#Comments
* Concerned that back-end and front-end of the code is not clearly defined. The back-end will be sending the front-end commands that the front-end will then run. 
* Thinks the MainCharacter class contains too much information and does too much. Separate it into multiple classes to ensure single functionality.
* Maybe separate the pen and the turtle so they have different functions
* Liked the separation of the GUI/display with root manager controlling everything
* Liked usage of Observer/Observable in history of commands display. 

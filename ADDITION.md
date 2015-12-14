
#SLogo Addition

###Daniel McKee

*Estimation*

I think this update might take 2 or 3 hours. My guess is that I will have to update only a few files on the back-end. I might have to change more on the front end. If I remember our implementation well enough, the only back-end additions to the project should be a class for each of the new commands and two calls to methods controlling the GUI display.

*Review *

 It took about an hour total to get the feature working. It took me a few tries to find out what I needed to change on the front-end portion. On the back-end it worked the second time I tried it (after I realized that I forgot to modify a properties file). 

In the end I had to modify 6 different files. I had to change two files on the front-end to allow for screen wrapping to be turned on and off. After that I added two very short classes extending from `Command` called `Wrap` and `Window` to which I added only the function call to the front end to change screen wrapping and the return value of each function. I also added the command and class names to two properties files. Nothing else was necessary since reflection is used to load the classes.

  *Analysis: *

I think this exercise revealed that our project's design was very extensible. Adding two commands essentially involved adding only around 10 lines of functional code to the back-end. I remember thinking that our design was quite extensible and and I think this exercise confirmed that. It was easy to see what needed to be changed in the front-end classes as well, since each of the lines conveniently made a call to a method called `wrap()`. Something negative I noticed was that all of the 40 or so commands were together in one package rather than divided into sub-packages for ease of access. In addition, a class using reflection was accessing a file called `English3.properties` to get class names. This was confusing since there was already an 	`English.properties` file. If I were not at all familiar with the code it could have been slightly confusing to add this feature to the back end. However, I think it would be easy enough after examining examples of some of the other command classes to figure out what is necessary to implement a command.
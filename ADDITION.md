### Addition.md

by Michael Daou (md199)

##### Estimation:

At first, I thought that this will take around two to three hours to implement, and I came up with an outline of what I wanted to do to implement it: use interchangeable interfaces that define a different wrapping algorithm.

##### Review:

Trying to get my strategy desing pattern implemented in this code was close to what I would call a nightmare. The MainCharacter class is almost 400 lines long and contains so many primitive instance variables that I would have had to pass them all into the algorithm in order to move the turtle (unless I'm missing a much better way to do this.) Not to mention the fact that the `move()` method does not encapsulate the necessary data that defines how the turtle moves. 

So after hours of wrestling with the code, I decided to implement the strategy design pattern partially, such that the turtle defines these movement methods in its class body (so now they have access to all the data in the class), and an outside setter tells the turtle which class to call upon in its `move()` method. If I had more time, I would have worked to refactor MainCharacter to allow for swappable movement interfaces the way I thought of originally. 

Once I decided to implement the pattern partially, things fell into place and the design took about 1.5 hours to implement. 

I had to change around 6 classes to get this working, as well as add the strings for the commands to the resource file.

##### Analysis:

This exercise revealed that the back end of our code was quite extensible, but the front-end was not at all closed to modification. I had to go in and modify individual methods in a 400 line class in order to undo wrapping and have normal movment, which goes to show that the code is not as good as I remember it being.

To improve this code, division of responsibility among different classes would have been useful instead of having all the logic reside in one class.

To answer the very last question in this exercise, I was in fact unfamiliar with the wrapping code that was implemented on the front end, so this exercise proved difficult. However, being familiar with the backend of the project helped me implement the features quickly and easily after everything else was sorted out.
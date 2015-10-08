David Zhou
Partner: Bridget Dou

FRONT END API REVIEW

## Part 1

### What about your API/design is intended to be flexible?
The APIs are designed so that if the front end was to be scrapped (for example, if someone wanted to make this program run on an iPhone instead of javaFX) the backend would be completely functional.  Conversely, if someone wanted to implement a new method for interpretation (one that runs using a faster algorithm, perhaps) it would be possible to take out the backend and implement a new one using our format.  This code is flexible because its parts are designed to be interchangable.

### How is your API/design encapsulating your implementation decisions?
The backend solely handles the language parsing.  The front end shows everything that is displayed to the user.  The front end sends the inputted strings to the backend to be interpretted. Upon interpretation, the backend is able to tell the front end to update the screen appropriately.

### What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
The front end with display an error message.  It will not attempt to move the turtle or update one of our lists because the backend detected an error.

### Why do you think your API/design is good (also define what your measure of good is)?
From a modular perspective (that is, how separated the sections of our program are from each other), our program is quite good because the two components can be changed without changing how they interact with each other.

## Part 2

### Demo what you currently have running (it could be anything, but it should definitely be something).
I demoed the user interface and the working parts of the front end.  Work on the front end is almost complete; all that is left is error handling and turtle moving.  As far as I know, the backend group has not even started work on their section yet.

### Come up with at least four use cases for your part (it is absolutely fine if they are useful for both teams).  

Specific use cases seem more relevant to the backend.  Instead, I discussed several possible extensions.

Dynamic highlighting (like in Eclipse): when the user hovers over the text, the text becomes highlighted with a description of the selected method or variable.  This would require the front end to be able to look things up from the back end.

Switching between toroidal and infinite/finite canvas: This would require similar extension as in cell society.

Save the current canvas to an image file: This would be sweet, but I do not know how JavaFX handles this

Suggestions: make the program suggest commands or words based on what the in the language or commands list.  This seems like the most ambitious of the extensions and would require us to look into how technology such as autocorrect works.

### What feature or design are you most excited to work on?
Turtle movement!  We want to be able to control the speed of the turtle using the settings parameters, as well as the line thickness, and we're still thinking about ways to do this.

### What feature/design problem are you most worried about working on?
Coordinating things with the back end team; they haven't started yet and I don't know if they will finish in time for us to talk to each other, especially with fall break coming up.
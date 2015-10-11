Michael’s Design:

## Part 1

#### What about your API/design is intended to be flexible?
The flexibility in our design is in our intention to make the interpretation process work with different languages without having to modify the code for the interpret method.

#### How is your API/design encapsulating your implementation decisions?
Back end handles parsing, interpreting, and issuing commands to turtle. Front end handles visual elements and menus.
Front end never sees the interpretation process, and back end doesn’t see properties in the front end unless unless they are relevant to the way the interpretation works (such as setting the language of the interpretation.)

Back end and front end communicate through public methods that represent the API.

#### What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
Syntax errors: handle while parsing the string input into a string array input
Invalid variable error: handle this by setting the variable to a preset value (0).
Insufficient parameters: handle this by throwing an error in the console, inputting string back into console and allowing user to modify the command to add more parameters.

#### Why do you think your API/design is good (also define what your measure of good is)?
Our API design is good because it separates the front end from backend and then adds a distinct middle part that allows the two ends to communicate. 

## Part 2

#### Demo what you currently have running (it could be anything, but it should definitely be something).
We have the user interface running but the backend is still unimplemented.

#### Come up with at least four use cases for your part (it is absolutely fine if they are useful for both teams).
A calculator that teaches children about order of operations
Any command line environment
Script processing
Grammar processing: check sentence structure and syntax. The rules for grammar would be more complex.

#### What feature or design are you most excited to work on?
The part that I am most excited to work on is the creation of the tree which will definitely be a challenge, and the execution of it, which shouldn’t be too much of a challenge.

#### What feature/design problem are you most worried about working on?
In building the tree, returning when the node has received all of its parameters.
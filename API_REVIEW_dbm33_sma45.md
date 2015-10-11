


##API Review

Daniel McKee - dbm33

Sally Al. - sma45

Flexibility:
We construct the design so that the interpreter and and the GUI are nondependent on each other. Either could be replaced. 

The back-end must allow for easy addition of new commands. Both commands that are inputted by the user and commands that might be included in an extension. The user commands are added using a class called UserAction. We will allow for easy extension of preset commands

Discussed what should be kept in tree. Should our command classes be the nodes or should there be separate nodes that represent? 

Exceptions: 
Most of the exceptions with have to do with syntax errors. Do variable or command names called exist? Are commands properly formatted? We need to check for these types of errors as the input is parsed. Additionally, once we know whether the variables and commands are legitimate, we need to process

Most excited to work on syntax tree.

Worried about working on loops and user defined functions.

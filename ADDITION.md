


##API Review

David Zhou - dz54

NOTE: I will be implementing both AbstractDockElements and Debugging instead of the given extension, because I have already completed it (Click the Settings Button with turtles on the screen).

Estimation:

Time: 4 hours total

Files Required: MainCharacter (contains movement logic)
			    Palette and Console (need to change to AbstractDockElements)
			    AbstractDockElement (Port from VoogaSalad)
			    Monitor (need to add link to debugging)
			    Debug (new Screen)
			    Movement (extract class from MainCharacter and feed into DebugList Cell)
			    
Review:

Time: 5 hours or so total

Tries: Needed to debug many, many times (I don't think the debugging was trivial at all).

Files: Exact Files I mentioned, but I also forgot about resource files and SlogoScreen/SlogoTab.

Analysis:

-The files are worse than I remembered.  Specifically, there is a lot of unused stuff that is a relic from times before
-Daniel really butchered SlogoScreen when he implemented tabs, and I did not realize.
-The code could definitely benefit from refactoring.  If I did not write this stuff and use a lot of the concepts to build VoogaSalad, implementing debugging might have been impossible
-It would have taken at least an entire day to do this if I were not familiar with the code at all, if not longer

Instructions: Drag the words "Console" and "Palette" to test the AbstractDockElements
		      In the monitor (Settings -> the ListView containing turtle information), right click a turtle's cell to open debugging.
		      The debug window lists all recent movements.  Select one and click the "revert" button to revert the turtle to that previous 			 			  state.
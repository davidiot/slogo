#API Review
##Reviewed by Wuming Zhang (wz48)

Discussed the overall structure of front end and how it interacted with back end. Agreed with how everything was organized in general. Some questions about flexibility of the front end as some things such as pane sizes were fixed. If one were to adjust the size, it might break the UI. Discussed different methods of passing the parsed code from back end to front end, which was slightly different in our APIs. In ours, we have various methods in the front end that the back end will use to update the map. Wuming's team is packaging all the methods into a class in the back end to be forwarded to the front end. The front end would then update the display by parsing through all the commands in the class pushed forward and running it accordingly. The API was generally agreed to be concise and clear, making it easy to use. 

Four use cases discussed were implementing the wrap, hiding the turtle, showing the turtle, and clearing the screen. 

Most excited and worried about implementing updating the display. Seems to have difficulties, but should be challenging and interesting as well. 

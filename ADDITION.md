#Addition Document

###Estimation
I will be adding a save/feature to the front end. I estimate it will take approximately an hour. I will hopefully only have to update the XMLEditor/Reader classes and the AbstractScreen class. I hope to store everything in a model upon saving and directly save that XML. Then I would have to load the model back into the SLogo environment. 

###Review
Took 2 hours to complete the new feature. Did not end up being completely correct the first time. Still does not load the serialization properly. Needed to add a new model class to serialize, the XMLEditor class, and the SlogoTab class. This is to implement the actual saving feature and add the buttons on the screen.

###Analysis
Documentation was not as good as I remembered. I found it difficult to find things. Our screens were very nested, so it was difficult to navigate and some of the methods were poorly named. Comments at the top describing what each of the screens did would have helped. It would have been very difficult if I was not familiar with the code at all, as some of the screens' names did not make sense. 
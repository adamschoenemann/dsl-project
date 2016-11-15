# An android Application for a Configurator DSL

## Configurator3
this version organize the configurator using activities. The current version does not save the radio button's state of the current activity. A possibility could be to use Bundle and put the toggle buton state in an ArrayList. 


## TODO
* pass state to other activities to remember the checked radio buttons DONE!
* implement constrain if then else DONE!
* 


## Constraints
If-then-else constraint expression is now implemented, where
if the user check 32 bits machines, the application updates the list of
radio buttons of RAM accordingly, showing more than 4 gigabytes if the
architecture is 64 bits.

We are using a static class called MyApp, that contains the state of the application.

This kind of constrint is implemented using the visibility of the
radioubuttons:

## Resources

using radioButton.setVisibility(View.GONE); 
those elements that have if then else constrains can be translated to radiobuttons that can be set to invisible[http://stackoverflow.com/questions/19108686/hiding-a-radiobutton-in-android], but probably most important, this one[http://stackoverflow.com/questions/4850238/how-to-make-ui-components-disappear-when-a-certain-radiobutton-is-selected]

 
## Other Possibilities


Another possoble solutions :
  * everything placed in a scroll view
    Configurator4 is a project that explores this approach using also
    a dropdown button (spinner) instead
	of radiobutons. This approach do not require the use of buttons to
	navigate by different activities.   
	
  * swipe between fragments(similar to Configurator3 but without buttons)

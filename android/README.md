# An android Application for a Configurator DSL

## Configurator3
this version organize the configurator using activities. The current version does not save the radio button's state of the current activity. A possibility could be to use Bundle and put the toggle buton state in an ArrayList. 


## TODO
* pass state to other activities to remember the checked radio buttons
* implement constrains.


## Constraints
Constraint could be implemented using the visibility of the radioubuttons
using radioButton.setVisibility(View.GONE); 
those elements that have constrains should be translated to radiobuttons that can be 
set to invisible[http://stackoverflow.com/questions/19108686/hiding-a-radiobutton-in-android]
but probably most important, this one[http://stackoverflow.com/questions/4850238/how-to-make-ui-components-disappear-when-a-certain-radiobutton-is-selected]


in this case we have to change the visibility of some of the Ram and CPUS radioobuttons according to the architecture
 
## Other Possibilities
Another possoble solutions :
  * everything in a top down scrolling view
  * swipe between fragments(similar to Configurator3 but without buttons)

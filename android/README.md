# An android Application for a Configurator DSL

## Configurator3
The current version organizes the configurator using activities and uses an Object called MyApp to save the overall state. (for now a simple constraint)
Another possibility could be to use Bundle and put the toggle buton state in
an ArrayList. 


## TODO
* implement Configurator4. The single page version of Configurator3
* consider which of the two versions is less anoying to implement
* investigate [json2view]() project and how to implement an interpreter
* decide whether an interpreter is easier to implement than a generator 
* implement constrain if-else DONE!
* implement constaraint > 0 (bigger than) 
* implement Title generation
* implement Label generation
* implement list of products generation
* implement what is implemented in the HTML Generator...




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
those elements that have if then else constrains can be translated to radiobuttons that can be set to
[invisible](http://stackoverflow.com/questions/19108686/hiding-a-radiobutton-in-android), but probably most important, [this one](http://stackoverflow.com/questions/4850238/how-to-make-ui-components-disappear-when-a-certain-radiobutton-is-selected)

 
## Other Possibilities


Another possible solutions :
  * everything placed in a scroll view
    Configurator4 is a project that explores this approach using also
    a dropdown button (spinner) instead
	of radiobutons. This approach do not require the use of buttons to
	navigate by different activities.
	
  * swipe between fragments(similar to Configurator3 but without buttons)

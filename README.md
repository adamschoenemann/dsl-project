Domain Specific Languages
=========================

In `scala-model` you can find the files for the meta-model I (Adam) built in
Scala. There is also a primitive user interface :)


Using the Eclipse Projects
----------------------------
In the `eclipse` folder there are some projects.

- `dk.itu.chomsky.configurator.model` contains the Ecore project
- `dk.itu.chomsky.configurator.*` are the XText projects

You have to open them all in Eclipse in the same workspace. Use
`Import -> Existing Projects Into Workspace`

You must find the directory where the projects are and select that directoy.
Mark them all (but not the one just called "eclipse" if it is there).

Your Eclipse must have installed the Scala-IDE and the EMF modeling framework
and XText plugins.

When you have imported the projects there will be many errors - relax!

To build, do this:

- Make sure that `dk.itu.chomsky.configurator.model` is a `Modeling Project`
- Make sure that `dk.itu.chomsky.configurator` is an `XText` and `Scala` project
- Create a `.genmodel` file for the `.ecore` if it is not there
- `Reload` and `Generate code` using the `.genmodel`
- In the `dk.itu.chomsky.configurator` project, right-click the `ConfigDSL.xtext`
  file and `Generate XText Artifacts`
- In the `dk.itu.chomsky.configurator.ide` project, right-click and `Run as Eclipse Application`

It will open up a new eclipse workspace with our DSL plugin loaded.
Create a new Java project - call it whatever you want.
Create a new file in `src` or whatever and call it something, but its file
extension **must end be cnfgdsl**. It will maybe ask you if you want to
convert the project to an XText project - you do!

Create a model by hand or copy one from `example-syntax.txt` and watch the
magic.

Troubleshooting
---------------
Remember to do `Project -> Clean` and select all. Eclipse can be slow to pick up stuff.

Sometimes, right-click a project and select `Plugin Tools -> Update Classpath` to
help resolve errors.

If there are build-path errors because source folders are missing; create the folders.


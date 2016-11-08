Domain Specific Languages
=========================

In `scala-model` you can find the files for the meta-model I (Adam) built in
Scala. There is also a primitive user interface :)


Running the Eclipse Projects
----------------------------
In the `eclipse` folder there are some projects.

- `dk.itu.chomsky.configurator.model` contains the Ecore project
- `dk.itu.chomsky.configurator.*` are the XText projects

You have to open them all in Eclipse in the same workspace.
To build, do this:

- Make sure that `dk.itu.chomsky.configurator.model` is a `Modeling Project`
- Make sure that `dk.itu.chomsky.configurator` is an `XText` and `Scala` project
- Create a `.genmodel` file for the `.ecore` if it is not there
- `Reload` and `Generate code` using the `.genmodel`
- In the `dk.itu.chomsky.configurator` project, right-click the `ConfigDSL.xtext`
  file and `Generate XText Artifacts`
- In the `dk.itu.chomsky.configurator.ide` project, right-click and `Run as Eclipse Application`

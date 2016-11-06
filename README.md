Domain Specific Languages
=========================

In `scala-model` you can find the files for the meta-model I (Adam) built in
Scala. There is also a primitive user interface :)

'ConfiguratorModel1' contains an EMF meta-model for the project (first version - inspired by Adams code-first model). The Constraint class (in a separate class diagram) is not really a constraint in this version. It is a way to model and connect the if-then-else construct to the Parameter class.
Still some work to be done to statically verify constraints ...


Running the Eclipse Projects
----------------------------
In the `eclipse` folder there are some projects.

- `Configurator` contains the Ecore project
- `dk.itu.chomsky.configurator.*` is the XText projects

You have to open them all in Eclipse in the same workspace.
To build, do this:

- Make sure that `Configurator` is a `Modeling Project` and a `XText` project
- Create a `.genmodel` file for the `.ecore`
- `Reload` and `Generate code` using the `.genmodel`
- In the `dk.itu.chomsky.configurator` project, right-click the `ConfigDSL.xtext`
  file and `Generate XText Artifacts`
- In the `dk.itu.chomsky.configurator.ide` project, right-click and `Run as Eclipse Application`

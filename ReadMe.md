
# A Oomph Task for importing gradle projects using Buildship

These plugins provide an oomph setup task to import gradle projects into eclipse using the buildship project-import wizard.
After the project has been successfully imported an optional gradle task may be executed.

For the moment consider this to be in alpha state. The task seems to work with all of my setups i tried so far, but problems might still exist.

To build the project you need a workspace with both oomph and buildship installed (sorry, no setup file yet). 
Import the projects into the workspace, use the genmodel file to generate the model and edit code, then export the feature.

Add the feature to the workspace you use to edit your setup files and to the workspace in which the task will be exeuted.



# Usage


The task provides the following properties:

`ProjectRootDirectory` this is the only mandatory property. Set it to a file url pointing to the folder containing the gradle project to be imported.

`JavaHome` set this to a file url to be passed on to the buildship import task as the JRE to be used.

`GradleUserHome` the file url to be passed on to the buildship import task as the gradle user home directory to be used.

`ImportWaitTime` if set to 0 the task creates and starts a job to import the project and then continues. If set to a positive number (the default is 30) the task waits these number of seconds for the import to complete before continuing. If the import does not complete in time this is considered as an error.

`GradleTask` - if not empty this is the name of the task to be executed after the project has been imported. The property is preset to "eclipse".

`GradleBuildDirectory` - the directory from which `GradleTask` will be executed. If not set `ProjectRootDirectory` will be used.

`Arguments` and `JvmArguments` are currently not used.


# License

The project is licensed under the Eclipse Public License 1.0.











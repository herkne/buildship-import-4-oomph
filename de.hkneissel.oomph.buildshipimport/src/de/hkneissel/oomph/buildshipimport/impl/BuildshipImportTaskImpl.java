/*
 * Copyright (c) 2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package de.hkneissel.oomph.buildshipimport.impl;

import org.eclipse.oomph.setup.SetupTaskContext;
import org.eclipse.oomph.setup.impl.SetupTaskImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.buildship.core.CorePlugin;
import org.eclipse.buildship.core.launch.GradleRunConfigurationAttributes;
import org.eclipse.buildship.core.util.progress.AsyncHandler;
import org.eclipse.buildship.core.workspace.SynchronizeGradleProjectJob;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.gradleware.tooling.toolingclient.GradleDistribution;
import com.gradleware.tooling.toolingmodel.repository.FixedRequestAttributes;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import de.hkneissel.oomph.buildshipimport.BuildshipImportPackage;
import de.hkneissel.oomph.buildshipimport.BuildshipImportTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buildship Import Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getProjectRootDirectory <em>Project Root Directory</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getJavaHome <em>Java Home</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getGradleUserHome <em>Gradle User Home</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getJvmArguments <em>Jvm Arguments</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getImportWaitTime <em>Import Wait Time</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getGradleTask <em>Gradle Task</em>}</li>
 *   <li>{@link de.hkneissel.oomph.buildshipimport.impl.BuildshipImportTaskImpl#getGradleBuildDirectory <em>Gradle Build Directory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BuildshipImportTaskImpl extends SetupTaskImpl implements BuildshipImportTask
{
  /**
   * The default value of the '{@link #getProjectRootDirectory() <em>Project Root Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjectRootDirectory()
   * @generated
   * @ordered
   */
  protected static final URI PROJECT_ROOT_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProjectRootDirectory() <em>Project Root Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjectRootDirectory()
   * @generated
   * @ordered
   */
  protected URI projectRootDirectory = PROJECT_ROOT_DIRECTORY_EDEFAULT;

  /**
   * The default value of the '{@link #getJavaHome() <em>Java Home</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaHome()
   * @generated
   * @ordered
   */
  protected static final URI JAVA_HOME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJavaHome() <em>Java Home</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaHome()
   * @generated
   * @ordered
   */
  protected URI javaHome = JAVA_HOME_EDEFAULT;

  /**
   * The default value of the '{@link #getGradleUserHome() <em>Gradle User Home</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGradleUserHome()
   * @generated
   * @ordered
   */
  protected static final URI GRADLE_USER_HOME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGradleUserHome() <em>Gradle User Home</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGradleUserHome()
   * @generated
   * @ordered
   */
  protected URI gradleUserHome = GRADLE_USER_HOME_EDEFAULT;

  /**
   * The default value of the '{@link #getJvmArguments() <em>Jvm Arguments</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJvmArguments()
   * @generated
   * @ordered
   */
  protected static final String JVM_ARGUMENTS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJvmArguments() <em>Jvm Arguments</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJvmArguments()
   * @generated
   * @ordered
   */
  protected String jvmArguments = JVM_ARGUMENTS_EDEFAULT;

  /**
   * The default value of the '{@link #getArguments() <em>Arguments</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected static final String ARGUMENTS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected String arguments = ARGUMENTS_EDEFAULT;

  /**
   * The default value of the '{@link #getImportWaitTime() <em>Import Wait Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportWaitTime()
   * @generated
   * @ordered
   */
  protected static final int IMPORT_WAIT_TIME_EDEFAULT = 30;

  /**
   * The cached value of the '{@link #getImportWaitTime() <em>Import Wait Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportWaitTime()
   * @generated
   * @ordered
   */
  protected int importWaitTime = IMPORT_WAIT_TIME_EDEFAULT;

  /**
   * The default value of the '{@link #getGradleTask() <em>Gradle Task</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGradleTask()
   * @generated
   * @ordered
   */
  protected static final String GRADLE_TASK_EDEFAULT = "eclipse";

  /**
   * The cached value of the '{@link #getGradleTask() <em>Gradle Task</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGradleTask()
   * @generated
   * @ordered
   */
  protected String gradleTask = GRADLE_TASK_EDEFAULT;

  /**
   * The default value of the '{@link #getGradleBuildDirectory() <em>Gradle Build Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGradleBuildDirectory()
   * @generated
   * @ordered
   */
  protected static final URI GRADLE_BUILD_DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGradleBuildDirectory() <em>Gradle Build Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGradleBuildDirectory()
   * @generated
   * @ordered
   */
  protected URI gradleBuildDirectory = GRADLE_BUILD_DIRECTORY_EDEFAULT;

  private static final int PRIORITY = PRIORITY_DEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BuildshipImportTaskImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URI getProjectRootDirectory()
  {
    return projectRootDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProjectRootDirectory(URI newProjectRootDirectory)
  {
    URI oldProjectRootDirectory = projectRootDirectory;
    projectRootDirectory = newProjectRootDirectory;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY, oldProjectRootDirectory,
          projectRootDirectory));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URI getJavaHome()
  {
    return javaHome;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaHome(URI newJavaHome)
  {
    URI oldJavaHome = javaHome;
    javaHome = newJavaHome;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JAVA_HOME, oldJavaHome, javaHome));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URI getGradleUserHome()
  {
    return gradleUserHome;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGradleUserHome(URI newGradleUserHome)
  {
    URI oldGradleUserHome = gradleUserHome;
    gradleUserHome = newGradleUserHome;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME, oldGradleUserHome, gradleUserHome));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * The contents of this attribute is currently ignored.
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJvmArguments()
  {
    return jvmArguments;
  }

  /**
   * <!-- begin-user-doc -->
   * The contents of this attribute is currently ignored.
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJvmArguments(String newJvmArguments)
  {
    String oldJvmArguments = jvmArguments;
    jvmArguments = newJvmArguments;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS, oldJvmArguments, jvmArguments));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArguments()
  {
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArguments(String newArguments)
  {
    String oldArguments = arguments;
    arguments = newArguments;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__ARGUMENTS, oldArguments, arguments));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getImportWaitTime()
  {
    return importWaitTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportWaitTime(int newImportWaitTime)
  {
    int oldImportWaitTime = importWaitTime;
    importWaitTime = newImportWaitTime;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME, oldImportWaitTime, importWaitTime));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGradleTask()
  {
    return gradleTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGradleTask(String newGradleTask)
  {
    String oldGradleTask = gradleTask;
    gradleTask = newGradleTask;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_TASK, oldGradleTask, gradleTask));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URI getGradleBuildDirectory()
  {
    return gradleBuildDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGradleBuildDirectory(URI newGradleBuildDirectory)
  {
    URI oldGradleBuildDirectory = gradleBuildDirectory;
    gradleBuildDirectory = newGradleBuildDirectory;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY, oldGradleBuildDirectory,
          gradleBuildDirectory));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY:
      return getProjectRootDirectory();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JAVA_HOME:
      return getJavaHome();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME:
      return getGradleUserHome();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS:
      return getJvmArguments();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__ARGUMENTS:
      return getArguments();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME:
      return getImportWaitTime();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_TASK:
      return getGradleTask();
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY:
      return getGradleBuildDirectory();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY:
      setProjectRootDirectory((URI)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JAVA_HOME:
      setJavaHome((URI)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME:
      setGradleUserHome((URI)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS:
      setJvmArguments((String)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__ARGUMENTS:
      setArguments((String)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME:
      setImportWaitTime((Integer)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_TASK:
      setGradleTask((String)newValue);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY:
      setGradleBuildDirectory((URI)newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY:
      setProjectRootDirectory(PROJECT_ROOT_DIRECTORY_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JAVA_HOME:
      setJavaHome(JAVA_HOME_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME:
      setGradleUserHome(GRADLE_USER_HOME_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS:
      setJvmArguments(JVM_ARGUMENTS_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__ARGUMENTS:
      setArguments(ARGUMENTS_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME:
      setImportWaitTime(IMPORT_WAIT_TIME_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_TASK:
      setGradleTask(GRADLE_TASK_EDEFAULT);
      return;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY:
      setGradleBuildDirectory(GRADLE_BUILD_DIRECTORY_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY:
      return PROJECT_ROOT_DIRECTORY_EDEFAULT == null ? projectRootDirectory != null : !PROJECT_ROOT_DIRECTORY_EDEFAULT.equals(projectRootDirectory);
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JAVA_HOME:
      return JAVA_HOME_EDEFAULT == null ? javaHome != null : !JAVA_HOME_EDEFAULT.equals(javaHome);
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME:
      return GRADLE_USER_HOME_EDEFAULT == null ? gradleUserHome != null : !GRADLE_USER_HOME_EDEFAULT.equals(gradleUserHome);
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS:
      return JVM_ARGUMENTS_EDEFAULT == null ? jvmArguments != null : !JVM_ARGUMENTS_EDEFAULT.equals(jvmArguments);
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__ARGUMENTS:
      return ARGUMENTS_EDEFAULT == null ? arguments != null : !ARGUMENTS_EDEFAULT.equals(arguments);
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME:
      return importWaitTime != IMPORT_WAIT_TIME_EDEFAULT;
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_TASK:
      return GRADLE_TASK_EDEFAULT == null ? gradleTask != null : !GRADLE_TASK_EDEFAULT.equals(gradleTask);
    case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY:
      return GRADLE_BUILD_DIRECTORY_EDEFAULT == null ? gradleBuildDirectory != null : !GRADLE_BUILD_DIRECTORY_EDEFAULT.equals(gradleBuildDirectory);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy())
    {
      return super.toString();
    }

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (ProjectRootDirectory: ");
    result.append(projectRootDirectory);
    result.append(", JavaHome: ");
    result.append(javaHome);
    result.append(", GradleUserHome: ");
    result.append(gradleUserHome);
    result.append(", JvmArguments: ");
    result.append(jvmArguments);
    result.append(", Arguments: ");
    result.append(arguments);
    result.append(", ImportWaitTime: ");
    result.append(importWaitTime);
    result.append(", GradleTask: ");
    result.append(gradleTask);
    result.append(", GradleBuildDirectory: ");
    result.append(gradleBuildDirectory);
    result.append(')');
    return result.toString();
  }

  @Override
  public int getPriority()
  {
    return PRIORITY;
  }

  public boolean isNeeded(SetupTaskContext context) throws Exception
  {
    return true;
  }

  public void perform(final SetupTaskContext context) throws Exception
  {
    final File projectRootDir = asFile(getProjectRootDirectory(), "ProjectRootDirectory");
    if (projectRootDir == null)
    {
      throw new NullPointerException("ProjectRootDirectory not set");
    }

    final GradleDistribution gradleDistribution = GradleDistribution.fromBuild();
    final File gradleUserDir = asFile(getGradleUserHome(), "GradleUserHome");
    final File javaHomeDir = asFile(getJavaHome(), "JavaHome");

    // TODO: initialize argument lists
    final List<String> jvmArguments = Collections.emptyList();
    final List<String> arguments = Collections.emptyList();

    FixedRequestAttributes requestAttributes = new FixedRequestAttributes(projectRootDir, gradleUserDir, gradleDistribution, javaHomeDir, jvmArguments,
        arguments);

    // Working sets are handled by oomph, so we do not need to handle them here.
    List<String> workingSets = Collections.emptyList();

    final CountDownLatch latch = new CountDownLatch(1);
    AsyncHandler initializer = AsyncHandler.NO_OP;

    context.log("Importing gradle projects from " + projectRootDir);

    WorkspaceJob synchronizeJob = new SynchronizeGradleProjectJob(requestAttributes, workingSets, initializer);
    synchronizeJob.addJobChangeListener(new JobChangeAdapter()
    {
      @Override
      public void done(IJobChangeEvent event)
      {
        try
        {
          if (event.getResult().isOK())
          {
            context.log("Import completed successfuly.");

            ensureGradleViewsAreVisible();

            // Run the initial gradle task ...

            String task = getGradleTask();
            if (task != null && task.length() > 0)
            {
              List<String> tasks = new ArrayList<String>();
              tasks.add(task);

              File workingDir = asFile(getGradleBuildDirectory(), "GradleBuildDirectory");
              if (workingDir == null)
              {
                workingDir = projectRootDir;
              }

              context.log("Executing gradle task '" + task + "' in " + workingDir);

              GradleRunConfigurationAttributes attr = GradleRunConfigurationAttributes.with(tasks, workingDir.toString(), gradleDistribution,
                  gradleUserDir == null ? "" : gradleUserDir.toString(), javaHomeDir == null ? "" : javaHomeDir.toString(), jvmArguments, arguments, true,
                  true);

              // Create/reuse a launch configuration for the given attributes ...
              ILaunchConfiguration launchConfiguration = CorePlugin.gradleLaunchConfigurationManager().getOrCreateRunConfiguration(attr);

              // ... and launch the launch configuration.
              DebugUITools.launch(launchConfiguration, ILaunchManager.RUN_MODE);
            }
            else
            {
              context.log("No gradle task defined.");
            }
          }
          else
          {
            throw new RuntimeException("Buildship import failed for " + projectRootDir);
          }
        }
        finally
        {
          latch.countDown();
        }
      }
    });

    synchronizeJob.schedule();

    int timeout = getImportWaitTime();
    if (timeout > 0)
    {
      context.log("Waiting up to " + timeout + " seconds for import to complete");
      if (!latch.await(timeout, TimeUnit.SECONDS))
      {
        throw new RuntimeException("Timeout waiting for import task to complete");
      }
    }
  }

  private File asFile(URI uri_, String name_)
  {
    if (uri_ == null || "".equals(uri_.toString()))
    {
      return null;
    }

    String scheme = uri_.scheme();
    if (scheme == null)
    {
      // The property may be set to the path directly, not to the locations uri.
      // We will accept this too.
      return new File(uri_.path());
    }

    if ("file".equals(scheme))
    {
      return new File(uri_.toFileString());
    }

    throw new IllegalArgumentException(name_ + " must use 'file:' scheme, not '" + scheme + ":' (" + uri_ + ")");
  }

  @Override
  public void dispose()
  {
  }

  // ----------------------------------------------------------------------
  // The code below is copied from the buildship ui plugin -
  // not nice, but the plugin does not export anything, so i don't know
  // how to access it else.
  // ----------------------------------------------------------------------

  private void ensureGradleViewsAreVisible()
  {
    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable()
    {
      public void run()
      {
        showView("org.eclipse.buildship.ui.views.taskview", null, IWorkbenchPage.VIEW_ACTIVATE);
        showView("org.eclipse.buildship.ui.views.executionview", null, IWorkbenchPage.VIEW_VISIBLE);
      }
    });
  }

  /**
   * Shows the view with the given id and secondary id in the given mode.
   *
   * @param viewId the id of the view
   * @param secondaryId the secondary id of the view, or {@code null} for no secondary id
   * @param mode the activation mode, must be {@link org.eclipse.ui.IWorkbenchPage#VIEW_ACTIVATE},
   *            {@link org.eclipse.ui.IWorkbenchPage#VIEW_VISIBLE} or
   *            {@link org.eclipse.ui.IWorkbenchPage#VIEW_CREATE}
   * @param <T> the expected type of the view
   * @return the shown view, never null
   * @throws RuntimeException thrown if the view cannot be initialized correctly
   */
  public static <T extends IViewPart> T showView(String viewId, String secondaryId, int mode)
  {
    IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    try
    {
      @SuppressWarnings("unchecked")
      T view = (T)activeWorkbenchWindow.getActivePage().showView(viewId, secondaryId, mode);
      return view;
    }
    catch (PartInitException e)
    {
      throw new RuntimeException(String.format("Cannot show view with id %s and secondary id %s.", viewId, secondaryId));
    }
  }

}

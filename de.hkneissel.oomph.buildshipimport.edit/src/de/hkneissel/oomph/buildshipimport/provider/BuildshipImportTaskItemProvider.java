/**
 */
package de.hkneissel.oomph.buildshipimport.provider;

import org.eclipse.oomph.setup.provider.SetupTaskItemProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.Collection;
import java.util.List;

import de.hkneissel.oomph.buildshipimport.BuildshipImportPackage;
import de.hkneissel.oomph.buildshipimport.BuildshipImportTask;

/**
 * This is the item provider adapter for a {@link de.hkneissel.oomph.buildshipimport.BuildshipImportTask} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildshipImportTaskItemProvider extends SetupTaskItemProvider
{
  /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public BuildshipImportTaskItemProvider(AdapterFactory adapterFactory)
  {
        super(adapterFactory);
    }

  /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addProjectRootDirectoryPropertyDescriptor(object);
            addJavaHomePropertyDescriptor(object);
            addGradleUserHomePropertyDescriptor(object);
            addJvmArgumentsPropertyDescriptor(object);
            addArgumentsPropertyDescriptor(object);
            addImportWaitTimePropertyDescriptor(object);
            addGradleTaskPropertyDescriptor(object);
            addGradleBuildDirectoryPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

  /**
     * This adds a property descriptor for the Project Root Directory feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addProjectRootDirectoryPropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_ProjectRootDirectory_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_ProjectRootDirectory_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Java Home feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addJavaHomePropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_JavaHome_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_JavaHome_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__JAVA_HOME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Gradle User Home feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addGradleUserHomePropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_GradleUserHome_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_GradleUserHome_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Jvm Arguments feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addJvmArgumentsPropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_JvmArguments_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_JvmArguments_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Arguments feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addArgumentsPropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_Arguments_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_Arguments_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__ARGUMENTS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Import Wait Time feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addImportWaitTimePropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_ImportWaitTime_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_ImportWaitTime_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Gradle Task feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addGradleTaskPropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_GradleTask_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_GradleTask_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__GRADLE_TASK,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This adds a property descriptor for the Gradle Build Directory feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addGradleBuildDirectoryPropertyDescriptor(Object object)
  {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_BuildshipImportTask_GradleBuildDirectory_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_BuildshipImportTask_GradleBuildDirectory_feature", "_UI_BuildshipImportTask_type"),
                 BuildshipImportPackage.Literals.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
   * This returns BuildshipImportTask.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/gradle_logo"));
  }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected boolean shouldComposeCreationImage()
  {
        return true;
    }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public String getText(Object object)
  {
    BuildshipImportTask task = (BuildshipImportTask)object;
    if (task.getProjectRootDirectory() == null)
    {
      return getString("_UI_BuildshipImportTask_type");
    }

    return task.getProjectRootDirectory().toString() + " [" + task.getGradleTask() + "]";
  }

  /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public void notifyChanged(Notification notification)
  {
        updateChildren(notification);

        switch (notification.getFeatureID(BuildshipImportTask.class)) {
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__PROJECT_ROOT_DIRECTORY:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JAVA_HOME:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_USER_HOME:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__JVM_ARGUMENTS:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__ARGUMENTS:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__IMPORT_WAIT_TIME:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_TASK:
            case BuildshipImportPackage.BUILDSHIP_IMPORT_TASK__GRADLE_BUILD_DIRECTORY:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

  /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}

package org.openmrs.module.licensemanagement.ui;

import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.web.taglib.fieldgen.LicenseHandler;
import org.openmrs.module.licensemanagement.web.taglib.fieldgen.LicenseTypeHandler;
import org.openmrs.ui.framework.StandardModuleUiConfiguration;
import org.openmrs.ui.framework.fragment.FragmentFactory;
import org.openmrs.ui.framework.page.PageFactory;
import org.openmrs.ui.framework.resource.ResourceFactory;
import org.openmrs.web.taglib.fieldgen.FieldGenHandlerFactory;

/**
 * The LicenseManagementModuleUiConfiguration Class.
 * <p>
 * Responsible for adding {@link LicenseTypeHandler} and {@link LicenseHandler} to OpenMRS framework, to make the
 * dynamic editors (e.g.: attribute value) support these types.
 * </p>
 */
public class LicenseManagementModuleUiConfiguration extends StandardModuleUiConfiguration {

    @Override
    public void afterContextRefreshed(PageFactory pageFactory, FragmentFactory fragmentFactory,
                                      ResourceFactory resourceFactory) {
        super.afterContextRefreshed(pageFactory, fragmentFactory, resourceFactory);

        FieldGenHandlerFactory
                .getSingletonInstance()
                .getHandlers()
                .put(LicenseType.class.getName(), LicenseTypeHandler.class.getName());

        FieldGenHandlerFactory
                .getSingletonInstance()
                .getHandlers()
                .put(License.class.getName(), LicenseHandler.class.getName());
    }
}

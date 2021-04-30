package org.openmrs.module.licensemanagement.web.taglib.fieldgen;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.api.LicenseService;

import java.util.List;

/**
 * The LicenseHandler Class.
 * <p>
 * This is handler used to initialize model for 'OpenMRS field gen' fields. These inputs are dynamically created
 * depending on the type of model data, e.g.: for inputs for attribute values.
 * </p>
 *
 * @see fieldGen/license.jsp
 */
public class LicenseHandler extends BaseFieldGenHandler {
    /**
     * This path is a workaround!
     * <p>
     * OpenMRS doesn't copy the license.field in the correct place in WEB-INF. Instead in
     * ./fieldGen/module/licensemanagement/*, it's in ./module/licensemanagement/fieldGen/*.
     * </p>
     */
    private final static String DEFAULT_URL = "../module/licensemanagement/fieldGen/license.field";

    public LicenseHandler() {
        super(DEFAULT_URL);
    }

    @Override
    void loadAdditionalData() {
        final LicenseService licenseService = Context.getService(LicenseService.class);
        final List<License> licenses = licenseService.getAllLicenses();
        setParameter("licenses", licenses);
    }
}

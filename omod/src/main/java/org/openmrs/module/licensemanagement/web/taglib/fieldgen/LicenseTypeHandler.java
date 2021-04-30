package org.openmrs.module.licensemanagement.web.taglib.fieldgen;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.api.LicenseTypeService;

import java.util.List;

/**
 * The LicenseTypeHandler Class.
 * <p>
 * This is handler used to initialize model for 'OpenMRS field gen' fields. These inputs are dynamically created
 * depending on the type of model data, e.g.: for inputs for attribute values.
 * </p>
 *
 * @see fieldGen/licenseType.jsp
 */
public class LicenseTypeHandler extends BaseFieldGenHandler {
    /**
     * This path is a workaround!
     * <p>
     * OpenMRS doesn't copy the license.field in the correct place in WEB-INF. Instead in
     * ./fieldGen/module/licensemanagement/*, it's in ./module/licensemanagement/fieldGen/*.
     * </p>
     */
    private final static String DEFAULT_URL = "../module/licensemanagement/fieldGen/licenseType.field";

    public LicenseTypeHandler() {
        super(DEFAULT_URL);
    }

    @Override
    void loadAdditionalData() {
        final LicenseTypeService licenseTypeService = Context.getService(LicenseTypeService.class);
        final List<LicenseType> licenseTypes = licenseTypeService.getAllLicenseTypes();
        setParameter("licenseTypes", licenseTypes);
    }
}

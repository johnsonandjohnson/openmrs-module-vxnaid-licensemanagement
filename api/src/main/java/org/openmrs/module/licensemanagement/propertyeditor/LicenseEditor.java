package org.openmrs.module.licensemanagement.propertyeditor;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.api.LicenseService;

/**
 * The LicenseEditor class.
 * <p>
 * Used at Form controllers to convert License to text.
 * </p>
 */
public class LicenseEditor extends BasePropertyEditorSupport<License> {

    public LicenseEditor() {
        super(License.class.getSimpleName());
    }

    @Override
    Integer getEntityId(License license) {
        return license.getLicenseId();
    }

    @Override
    License getEntityById(Integer id) {
        return Context.getService(LicenseService.class).getLicense(id);
    }

    @Override
    License getEntityByName(String text) {
        return Context.getService(LicenseService.class).getLicense(text);
    }
}

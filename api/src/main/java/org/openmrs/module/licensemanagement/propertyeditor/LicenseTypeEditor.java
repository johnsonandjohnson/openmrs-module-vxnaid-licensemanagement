package org.openmrs.module.licensemanagement.propertyeditor;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.api.LicenseTypeService;

/**
 * The LicenseEditor class.
 * <p>
 * Used at Form controllers to convert LicenseType to text.
 * </p>
 */
public class LicenseTypeEditor extends BasePropertyEditorSupport<LicenseType> {

    public LicenseTypeEditor() {
        super(LicenseType.class.getSimpleName());
    }

    @Override
    Integer getEntityId(LicenseType licenseType) {
        return licenseType.getLicenseTypeId();
    }

    @Override
    LicenseType getEntityById(Integer id) {
        return Context.getService(LicenseTypeService.class).getLicenseType(id);
    }

    @Override
    LicenseType getEntityByName(String text) {
        return Context.getService(LicenseTypeService.class).getLicenseType(text);
    }
}

package org.openmrs.module.licensemanagement.web.attribute.handler;

import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.customdatatype.datatype.LicenseTypeDatatype;
import org.openmrs.module.licensemanagement.propertyeditor.LicenseTypeEditor;
import org.springframework.stereotype.Component;

/**
 * Handler for the LicenseType custom datatype.
 * <p>
 * This is used by OpenMRS for singleCustomValue.tag, for example for Attribute Value Inputs.
 * </p>
 */
@Component
public class LicenseTypeFieldGenDatatypeHandler extends BaseFieldGenDatatypeHandler<LicenseTypeDatatype, LicenseType> {

    public LicenseTypeFieldGenDatatypeHandler() {
        super(new LicenseTypeEditor());
    }

    @Override
    public String getWidgetName() {
        return LicenseType.class.getName();
    }
}

package org.openmrs.module.licensemanagement.web.attribute.handler;

import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.customdatatype.datatype.LicenseDatatype;
import org.openmrs.module.licensemanagement.propertyeditor.LicenseEditor;
import org.springframework.stereotype.Component;

/**
 * Handler for the LicenseType custom datatype.
 * <p>
 * This is used by OpenMRS for singleCustomValue.tag, for example for Attribute Value Inputs.
 * </p>
 */
@Component
public class LicenseFieldGenDatatypeHandler extends BaseFieldGenDatatypeHandler<LicenseDatatype, License> {

    public LicenseFieldGenDatatypeHandler() {
        super(new LicenseEditor());
    }

    @Override
    public String getWidgetName() {
        return License.class.getName();
    }
}

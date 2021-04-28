package org.openmrs.module.licensemanagement.attribute.handler;

import org.openmrs.customdatatype.CustomDatatypeHandler;
import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.customdatatype.datatype.LicenseDatatype;
import org.springframework.stereotype.Component;

/**
 * The LicenseDatatypeHandler Class.
 * <p>
 * This ia an empty CustomDatatypeHandler for {@link LicenseDatatype}. Required by OpenMRS to exist.
 * </p>
 */
@Component
public class LicenseDatatypeHandler implements CustomDatatypeHandler<LicenseDatatype, License> {

    @Override
    public void setHandlerConfiguration(String handlerConfig) {
        // nothing to do
    }
}

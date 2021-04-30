package org.openmrs.module.licensemanagement.customdatatype.datatype;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.context.Context;
import org.openmrs.customdatatype.SerializingCustomDatatype;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.api.LicenseTypeService;
import org.springframework.stereotype.Component;

/**
 * The LicenseTypeDatatype Class.
 */
@Component
public class LicenseTypeDatatype extends SerializingCustomDatatype<LicenseType> {

    @Override
    public Summary doGetTextSummary(LicenseType licenseType) {
        return new Summary(licenseType.getName(), true);
    }

    @Override
    public String serialize(LicenseType licenseType) {
        if (licenseType == null) {
            return null;
        }
        return licenseType.getUuid();
    }

    @Override
    public LicenseType deserialize(String licenseTypeUuid) {
        if (StringUtils.isBlank(licenseTypeUuid)) {
            return null;
        }

        return Context.getService(LicenseTypeService.class).getLicenseTypeByUuid(licenseTypeUuid);
    }
}

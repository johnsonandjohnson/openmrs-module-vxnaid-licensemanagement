package org.openmrs.module.licensemanagement.api.dao;

import org.openmrs.module.licensemanagement.LicenseType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("licensemanagement.LicenseTypeDAO")
public class LicenseTypeDAO extends BaseLicenseManagementOpenmrsMetadataDAO<LicenseType> {

    public LicenseTypeDAO() {
        super(LicenseType.class);
    }

    public LicenseType getLicenseType(final Integer licenseTypeId) {
        return internalRead(licenseTypeId);
    }

    public LicenseType getLicenseType(final String name) {
        return internalReadByName(name);
    }

    public LicenseType getLicenseTypeByUuid(final String uuid) {
        return internalReadByUuid(uuid);
    }

    public List<LicenseType> getAllLicenseTypes(boolean includeRetired) {
        return internalReadAll(includeRetired);
    }

    public LicenseType saveLicenseType(final LicenseType licenseType) {
        return internalSave(licenseType);
    }

    public void deleteLicenseType(final LicenseType licenseType) {
        internalDelete(licenseType);
    }
}

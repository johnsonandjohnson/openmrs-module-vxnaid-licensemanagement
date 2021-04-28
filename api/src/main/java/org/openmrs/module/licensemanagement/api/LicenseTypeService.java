package org.openmrs.module.licensemanagement.api;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.api.dao.LicenseTypeDAO;
import org.openmrs.module.licensemanagement.util.PrivilegeConstants;

import java.util.List;

public interface LicenseTypeService {

    void setLicenseTypeDAO(LicenseTypeDAO licenseTypeDAO);

    @Authorized(PrivilegeConstants.GET_LICENSE_TYPES)
    LicenseType getLicenseType(Integer licenseTypeId) throws APIException;

    @Authorized(PrivilegeConstants.GET_LICENSE_TYPES)
    LicenseType getLicenseType(String name) throws APIException;

    @Authorized(PrivilegeConstants.GET_LICENSE_TYPES)
    LicenseType getLicenseTypeByUuid(String uuid) throws APIException;

    @Authorized(PrivilegeConstants.GET_LICENSE_TYPES)
    List<LicenseType> getAllLicenseTypes() throws APIException;

    @Authorized(PrivilegeConstants.GET_LICENSE_TYPES)
    List<LicenseType> getAllLicenseTypes(boolean includeRetired) throws APIException;

    @Authorized(PrivilegeConstants.MANAGE_LICENSE_TYPES)
    LicenseType saveLicenseType(LicenseType licenseType) throws APIException;

    @Authorized(PrivilegeConstants.MANAGE_LICENSE_TYPES)
    LicenseType retireLicenseType(LicenseType licenseType, String reason) throws APIException;

    @Authorized(PrivilegeConstants.MANAGE_LICENSE_TYPES)
    LicenseType unretireLicenseType(LicenseType licenseType) throws APIException;

    @Authorized(PrivilegeConstants.PURGE_LICENSE_TYPES)
    void purgeLicenseType(LicenseType licenseType) throws APIException;
}

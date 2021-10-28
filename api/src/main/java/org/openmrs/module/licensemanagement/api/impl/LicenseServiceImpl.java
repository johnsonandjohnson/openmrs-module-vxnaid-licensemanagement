package org.openmrs.module.licensemanagement.api.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.licensemanagement.DeviceAttribute;
import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.UsedLicense;
import org.openmrs.module.licensemanagement.api.LicenseService;
import org.openmrs.module.licensemanagement.api.dao.LicenseDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class LicenseServiceImpl extends BaseOpenmrsService implements LicenseService {
    private LicenseDAO licenseDAO;

    @Override
    public void setLicenseDAO(final LicenseDAO licenseDAO) {
        this.licenseDAO = licenseDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public License getLicense(final Integer licenseId) throws APIException {
        return licenseDAO.getLicense(licenseId);
    }

    @Override
    @Transactional(readOnly = true)
    public License getLicense(final String name) throws APIException {
        return licenseDAO.getLicense(name);
    }

    @Override
    @Transactional(readOnly = true)
    public License getLicenseByUuid(final String uuid) throws APIException {
        return licenseDAO.getLicenseByUuid(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<License> getAllLicenses() throws APIException {
        return licenseDAO.getAllLicenses(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<License> getAllLicenses(boolean includeRetired) throws APIException {
        return licenseDAO.getAllLicenses(includeRetired);
    }

    @Override
    @Transactional(readOnly = true)
    public List<License> getLicenses(final LicenseType licenseType) throws APIException {
        return licenseDAO.getLicensesByType(licenseType);
    }

    @Override
    public License saveLicense(final License license) throws APIException {
        return licenseDAO.saveLicense(license);
    }

    @Override
    public License retireLicense(final License license, final String retireReason) throws APIException {
        // Fields are set by org.openmrs.aop.RequiredDataAdvice
        return licenseDAO.saveLicense(license);
    }

    @Override
    public License unretireLicense(final License license) throws APIException {
        // Fields are set by org.openmrs.aop.RequiredDataAdvice
        return licenseDAO.saveLicense(license);
    }

    @Override
    public void purgeLicense(final License license) throws APIException {
        licenseDAO.deleteLicense(license);
    }

    @Override
    public List<UsedLicense> getUsedLicenses(LicenseType licenseType) throws APIException {
        final List<DeviceAttribute> deviceAttributes = licenseDAO.getDeviceAttributeWithLicense(licenseType);

        final List<UsedLicense> result = new ArrayList<UsedLicense>();

        for (final DeviceAttribute attribute : deviceAttributes) {
            result.add(new UsedLicense((License) attribute.getValue(), attribute.getDevice()));
        }

        return result;
    }

    @Override
    public License getAnyFreeLicense(LicenseType licenseType) throws APIException {
        final List<License> licenses = licenseDAO.getLicenseNotLinkedByDeviceAttribute(licenseType);
        return licenses.size() > 0 ? licenses.get(0) : null;
    }
}

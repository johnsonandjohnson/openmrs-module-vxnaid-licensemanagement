package org.openmrs.module.licensemanagement.api.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.licensemanagement.Device;
import org.openmrs.module.licensemanagement.DeviceError;
import java.util.List;

public class DeviceErrorDAO extends BaseLicenseManagementOpenmrsObjectDAO<DeviceError> {

    DeviceErrorDAO() {
        super(DeviceError.class);
    }

    public DeviceError getDeviceError(final Integer id) {
        return internalRead(id);
    }

    public DeviceError getDeviceErrorByUuid(final String uuid) {
        return internalReadByUuid(uuid);
    }

    public List<DeviceError> getDeviceErrorsByKey(Device device, final String key, boolean includeVoided) {
        final Criteria criteria = getSession().createCriteria(DeviceError.class).add(Restrictions.eq("device", device))
                                              .add(Restrictions.eq("key", key));
        if (!includeVoided) {
            criteria.add(Restrictions.eq("voided", false));
        }
        return criteria.list();
    }

    public List<DeviceError> getDeviceErrorsByType(String type, boolean includeVoided) {
        final Criteria criteria = getSession().createCriteria(DeviceError.class).add(Restrictions.eq("type", type));
        if (!includeVoided) {
            criteria.add(Restrictions.eq("voided", false));
        }
        return criteria.list();
    }

    public DeviceError saveDeviceError(final DeviceError deviceError) {
        return internalSave(deviceError);
    }

    public void deleteDeviceError(final DeviceError deviceError) {
        internalDelete(deviceError);
    }
}

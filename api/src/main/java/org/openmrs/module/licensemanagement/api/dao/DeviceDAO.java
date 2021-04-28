package org.openmrs.module.licensemanagement.api.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.licensemanagement.Device;
import org.openmrs.module.licensemanagement.DeviceAttribute;
import org.openmrs.module.licensemanagement.DeviceAttributeType;

import java.util.List;

public class DeviceDAO extends BaseLicenseManagementOpenmrsMetadataDAO<Device> {

    public DeviceDAO() {
        super(Device.class);
    }

    public Device getDevice(final Integer deviceId) {
        return internalRead(deviceId);
    }

    public Device getDevice(final String name) {
        return internalReadByName(name);
    }

    public Device getDeviceByUuid(final String uuid) {
        return internalReadByUuid(uuid);
    }

    public Device getDeviceByMac(final String deviceMac) {
        final Criteria criteria = getSession().createCriteria(Device.class).add(Restrictions.eq("deviceMac", deviceMac));
        return firstResult(criteria, Device.class);
    }

    public List<Device> getAllDevices(boolean includeRetired) {
        return internalReadAll(includeRetired);
    }

    public List<Device> getDeviceByNameFragment(final String nameFragment) {
        return internalReadByNameFragment(nameFragment);
    }

    public Device saveDevice(final Device device) {
        return internalSave(device);
    }

    public void deleteDevice(final Device device) {
        internalDelete(device);
    }

    public DeviceAttributeType getDeviceAttributeType(final Integer deviceAttributeTypeId) {
        return (DeviceAttributeType) getSession().get(DeviceAttributeType.class, deviceAttributeTypeId);
    }

    public DeviceAttributeType getDeviceAttributeType(final String name) {
        final Criteria criteria = getSession().createCriteria(DeviceAttributeType.class).add(Restrictions.eq("name", name));
        return firstResult(criteria, DeviceAttributeType.class);
    }

    public DeviceAttributeType getDeviceAttributeTypeByUuid(final String uuid) {
        final Criteria criteria = getSession().createCriteria(DeviceAttributeType.class).add(Restrictions.eq("uuid", uuid));
        return firstResult(criteria, DeviceAttributeType.class);
    }

    public List<DeviceAttributeType> getAllDeviceAttributeTypes(final boolean includeRetired) {
        final Criteria criteria = getSession().createCriteria(DeviceAttributeType.class);

        if (!includeRetired) {
            criteria.add(Restrictions.eq("retired", false));
        }

        return criteria.list();
    }

    public DeviceAttributeType saveDeviceAttributeType(final DeviceAttributeType deviceAttributeType) {
        getSession().saveOrUpdate(deviceAttributeType);
        return deviceAttributeType;
    }

    public void deleteDeviceAttributeType(final DeviceAttributeType deviceAttributeType) {
        getSession().delete(deviceAttributeType);
    }

    public DeviceAttribute getDeviceAttributeByUuid(final String uuid) {
        final Criteria criteria = getSession().createCriteria(DeviceAttribute.class).add(Restrictions.eq("uuid", uuid));
        return firstResult(criteria, DeviceAttribute.class);
    }

    public DeviceAttribute getDeviceAttributeByDeviceAndType(final Device device,
                                                             final DeviceAttributeType deviceAttributeType) {
        final Criteria criteria = getSession()
                .createCriteria(DeviceAttribute.class)
                .add(Restrictions.eq("voided", false))
                .add(Restrictions.eq("device", device))
                .add(Restrictions.eq("attributeType", deviceAttributeType));

        return firstResult(criteria, DeviceAttribute.class);
    }

    public List<DeviceAttribute> getDeviceAttributes(final DeviceAttributeType deviceAttributeType) {
        final Criteria criteria = getSession()
                .createCriteria(DeviceAttribute.class)
                .add(Restrictions.eq("voided", false))
                .add(Restrictions.eq("attributeType", deviceAttributeType));

        return criteria.list();
    }
}

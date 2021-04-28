package org.openmrs.module.licensemanagement;

import org.openmrs.attribute.AttributeType;
import org.openmrs.attribute.BaseAttributeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The DeviceAttributeType Class.
 * <p>
 * This entity represents a kind of attribute a Device can have.
 * </p>
 */
@Entity(name = "licensemanagement.DeviceAttributeType")
@Table(name = "licensemgmt_device_attribute_type")
public class DeviceAttributeType extends BaseAttributeType<Device> implements AttributeType<Device> {

    @Id
    @GeneratedValue
    @Column(name = "device_attribute_type_id")
    private Integer deviceAttributeTypeId;

    @Override
    public Integer getId() {
        return getDeviceAttributeTypeId();
    }

    @Override
    public void setId(Integer deviceAttributeTypeId) {
        setDeviceAttributeTypeId(deviceAttributeTypeId);
    }

    /**
     * Gets DeviceAttributeType ID. Take notice, that this is the same value as {@link #getId()}.
     *
     * @return deviceAttributeTypeId, or null if this object is not persisted yet
     */
    public Integer getDeviceAttributeTypeId() {
        return deviceAttributeTypeId;
    }

    /**
     * Sets DeviceAttributeType ID, Take notice, that this sets the same property as
     * {@link #setId(Integer)}.
     *
     * @param deviceAttributeTypeId, the ID to set
     */
    public void setDeviceAttributeTypeId(Integer deviceAttributeTypeId) {
        this.deviceAttributeTypeId = deviceAttributeTypeId;
    }
}

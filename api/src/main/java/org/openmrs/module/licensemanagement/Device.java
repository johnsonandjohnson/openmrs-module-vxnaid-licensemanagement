package org.openmrs.module.licensemanagement;

import org.apache.commons.lang3.ObjectUtils;
import org.openmrs.Attributable;
import org.openmrs.BaseCustomizableMetadata;
import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.api.DeviceService;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The Device Class.
 * <p>
 * This entity represents a single device.
 * </p>
 */
@Entity(name = "licensemanagement.Device")
@Table(name = "licensemgmt_device")
public class Device extends BaseCustomizableMetadata<DeviceAttribute> implements Serializable, Attributable<Device> {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "device_mac", length = 255)
    private String deviceMac;

    // Repeat the field from BaseCustomizableMetadata to add Hibernate mapping (unfortunately the BaseCustomizableMetadata
    // has no annotations)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "device")
    @OrderBy("voided asc")
    private Set<DeviceAttribute> deviceAttributes = new LinkedHashSet<DeviceAttribute>();

    @Override
    public Integer getId() {
        return getDeviceId();
    }

    @Override
    public void setId(Integer deviceId) {
        setDeviceId(deviceId);
    }

    /**
     * Gets Device ID. Take notice, that this is the same value as {@link #getId()}.
     *
     * @return deviceId, or null if this object is not persisted yet
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * Sets Device ID, Take notice, that this sets the same property as {@link #setId(Integer)}.
     *
     * @param deviceId, the ID to set
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the Device MAC
     */
    public String getDeviceMac() {
        return deviceMac;
    }

    /**
     * Sets Device MAC.
     *
     * @param deviceMac, the Device MAC to set
     */
    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    @Override
    public Set<DeviceAttribute> getAttributes() {
        return deviceAttributes;
    }

    @Override
    public void setAttributes(Set<DeviceAttribute> attributes) {
        this.deviceAttributes = attributes;
        super.setAttributes(deviceAttributes);
    }

    @Override
    public Device hydrate(String deviceId) {
        try {
            return Context.getService(DeviceService.class).getDevice(Integer.valueOf(deviceId));
        } catch (Exception any) {
            return new Device();
        }
    }

    @Override
    public String serialize() {
        return ObjectUtils.toString(this.getId(), "");
    }

    @Override
    public List<Device> getPossibleValues() {
        try {
            return Context.getService(DeviceService.class).getAllDevices();
        } catch (Exception any) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Device> findPossibleValues(String searchText) {
        try {
            return Context.getService(DeviceService.class).getDevices(searchText);
        } catch (Exception any) {
            return Collections.emptyList();
        }
    }

    @Override
    public String getDisplayString() {
        return this.getName();
    }
}

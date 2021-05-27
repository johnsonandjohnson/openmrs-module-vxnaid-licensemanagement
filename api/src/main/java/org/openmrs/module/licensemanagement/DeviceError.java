/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.licensemanagement;

import org.openmrs.BaseOpenmrsData;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * The Device Error Class.
 * <p>
 * This entity represents an error reported by a device.
 * </p>
 */

@Entity(name = "licensemanagement.DeviceError")
@Table(name = "licensemgmt_device_error")
public class DeviceError extends BaseOpenmrsData implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "device_error_id")
    private Integer deviceErrorId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(name = "error_type", nullable = false)
    private String type;

    @Column(name = "error_key", nullable = false)
    private String key;

    @Column(name = "meta", columnDefinition = "text", length = 2000, nullable = false)
    private String meta;

    @Column(name = "stack_trace", columnDefinition = "text", length = 2000)
    private String stackTrace;

    @Column(name = "reported_date", nullable = false)
    private Date reportedDate;

    /**
     * @see org.openmrs.OpenmrsObject#getId()
     */
    @Override
    public Integer getId() {
        return getDeviceErrorId();
    }

    @Override
    public void setId(Integer deviceErrorId) {
        setDeviceErrorId(deviceErrorId);
    }

    public Integer getDeviceErrorId() {
        return deviceErrorId;
    }

    public void setDeviceErrorId(Integer deviceErrorId) {
        this.deviceErrorId = deviceErrorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }
}

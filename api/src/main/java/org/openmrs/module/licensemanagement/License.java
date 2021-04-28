package org.openmrs.module.licensemanagement;

import org.openmrs.BaseOpenmrsMetadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The License Class.
 * <p>
 * This entity represents a single license.
 * </p>
 */
@Entity(name = "licensemanagement.License")
@Table(name = "licensemgmt_license")
public class License extends BaseOpenmrsMetadata {

    @Id
    @GeneratedValue
    @Column(name = "license_id")
    private Integer licenseId;

    @Column(name = "serial_no", columnDefinition = "text", length = Integer.MAX_VALUE)
    private String serialNo;

    @Column(name = "online")
    private String online;

    @ManyToOne(optional = false)
    @JoinColumn(name = "license_type_id", nullable = false)
    private LicenseType licenseType;

    @Override
    public Integer getId() {
        return getLicenseId();
    }

    @Override
    public void setId(Integer licenseId) {
        setLicenseId(licenseId);
    }

    /**
     * Gets License ID. Take notice, that this is the same value as {@link #getId()}.
     *
     * @return licenseId, or null if this object is not persisted yet
     */
    public Integer getLicenseId() {
        return licenseId;
    }

    /**
     * Sets License ID, Take notice, that this sets the same property as {@link #setId(Integer)}.
     *
     * @param licenseId, the ID to set
     */
    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }
}

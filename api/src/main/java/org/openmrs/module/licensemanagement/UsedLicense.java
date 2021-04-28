package org.openmrs.module.licensemanagement;

/**
 * The UsedLicense Class.
 * <p>
 * The immutable data class which stores the License and the Device the License is assigned to.
 * </p>
 */
public final class UsedLicense {
    private final License license;
    private final Device device;

    public UsedLicense(License license, Device device) {
        this.license = license;
        this.device = device;
    }

    public License getLicense() {
        return license;
    }

    public Device getDevice() {
        return device;
    }
}

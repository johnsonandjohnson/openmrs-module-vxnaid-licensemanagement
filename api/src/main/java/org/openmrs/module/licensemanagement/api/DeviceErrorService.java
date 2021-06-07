package org.openmrs.module.licensemanagement.api;

import org.openmrs.module.licensemanagement.Device;
import org.openmrs.module.licensemanagement.DeviceError;
import java.util.List;

public interface DeviceErrorService {

    DeviceError getDeviceError(Integer deviceErrorId);

    DeviceError getDeviceErrorByUuid(String uuid);

    List<DeviceError> getDeviceErrorsByKey(Device device, String key, boolean includeVoided);

    DeviceError saveDeviceError(DeviceError deviceError);
}

package org.openmrs.module.licensemanagement.api;

import org.openmrs.module.licensemanagement.Device;
import org.openmrs.module.licensemanagement.DeviceError;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface DeviceErrorService {

    DeviceError getDeviceError(Integer deviceErrorId);

    DeviceError getDeviceErrorByUuid(String uuid);

    List<DeviceError> getDeviceErrorsByKey(Device device, boolean includeVoided, String key);

    DeviceError saveDeviceError(DeviceError deviceError);
}

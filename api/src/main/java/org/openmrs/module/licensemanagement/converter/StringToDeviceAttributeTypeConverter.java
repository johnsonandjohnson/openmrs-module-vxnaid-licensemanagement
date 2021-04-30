package org.openmrs.module.licensemanagement.converter;

import org.apache.commons.lang.StringUtils;
import org.openmrs.module.licensemanagement.DeviceAttributeType;
import org.openmrs.module.licensemanagement.api.DeviceService;
import org.springframework.core.convert.converter.Converter;

import java.util.regex.Pattern;

public class StringToDeviceAttributeTypeConverter implements Converter<String, DeviceAttributeType> {
    private static Pattern onlyDigits = Pattern.compile("\\d+");

    private DeviceService deviceService;

    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public DeviceAttributeType convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        } else if (onlyDigits.matcher(source).matches()) {
            return deviceService.getDeviceAttributeType(Integer.valueOf(source));
        }
        return deviceService.getDeviceAttributeTypeByUuid(source);
    }
}

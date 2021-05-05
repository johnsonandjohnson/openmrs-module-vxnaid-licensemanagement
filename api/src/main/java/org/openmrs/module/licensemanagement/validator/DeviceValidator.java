package org.openmrs.module.licensemanagement.validator;

import org.openmrs.module.licensemanagement.Device;
import org.openmrs.validator.ValidateUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DeviceValidator implements Validator {
    @Override
    public boolean supports(Class c) {
        return c.equals(Device.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        final Device device = (Device) obj;
        if (device == null) {
            errors.rejectValue("device", "error.general");
        } else {
            ValidateUtil.validateFieldLengths(errors, obj.getClass(), "name", "description", "retireReason", "deviceMac");
        }
    }
}

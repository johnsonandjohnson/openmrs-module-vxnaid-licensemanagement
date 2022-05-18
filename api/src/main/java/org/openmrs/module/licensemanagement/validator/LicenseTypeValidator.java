package org.openmrs.module.licensemanagement.validator;

import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.validator.ValidateUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LicenseTypeValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return c.equals(LicenseType.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        final LicenseType licenseType = (LicenseType) obj;
        if (licenseType == null) {
            errors.rejectValue("licenseType", "error.general");
        } else {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name");
            ValidateUtil.validateFieldLengths(errors, obj.getClass(), "name", "description", "retireReason");
        }
    }
}

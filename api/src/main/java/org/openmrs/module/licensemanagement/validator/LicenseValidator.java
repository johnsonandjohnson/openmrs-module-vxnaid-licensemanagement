package org.openmrs.module.licensemanagement.validator;

import org.openmrs.module.licensemanagement.License;
import org.openmrs.validator.ValidateUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LicenseValidator implements Validator {
    @Override
    public boolean supports(Class c) {
        return c.equals(License.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        final License license = (License) obj;
        if (license == null) {
            errors.rejectValue("license", "error.general");
        } else {
            ValidateUtil.validateFieldLengths(errors, obj.getClass(), "name", "description", "retireReason", "serialNo",
                    "online");
        }
    }
}

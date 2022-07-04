/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.licensemanagement.web.attribute.handler;

import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.customdatatype.datatype.LicenseDatatype;
import org.openmrs.module.licensemanagement.propertyeditor.LicenseEditor;
import org.springframework.stereotype.Component;

/**
 * Handler for the LicenseType custom datatype.
 * <p>
 * This is used by OpenMRS for singleCustomValue.tag, for example for Attribute Value Inputs.
 * </p>
 */
@Component
public class LicenseFieldGenDatatypeHandler extends BaseFieldGenDatatypeHandler<LicenseDatatype, License> {

    public LicenseFieldGenDatatypeHandler() {
        super(new LicenseEditor());
    }

    @Override
    public String getWidgetName() {
        return License.class.getName();
    }
}

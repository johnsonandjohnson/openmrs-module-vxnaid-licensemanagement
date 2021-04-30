package org.openmrs.module.licensemanagement.extension.html;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class defines the links that will appear on the administration page under the
 * "licensemanagement.title" heading. This extension is enabled by defining (uncommenting) it in the config.xml file.
 */
public class AdminList extends AdministrationSectionExt {

    @Override
    public Extension.MEDIA_TYPE getMediaType() {
        return Extension.MEDIA_TYPE.html;
    }

    @Override
    public String getTitle() {
        return "licensemanagement.title";
    }

    @Override
    public Map<String, String> getLinks() {
        final Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("module/licensemanagement/admin/licenseType.list", "licensemanagement.licenseTypes.manage.title");
        map.put("module/licensemanagement/admin/license.list", "licensemanagement.licenses.manage.title");
        map.put("module/licensemanagement/admin/deviceAttributeType.list",
                "licensemanagement.deviceAttributeTypes.manage.title");
        map.put("module/licensemanagement/admin/device.list", "licensemanagement.devices.manage.title");
        return map;
    }

}

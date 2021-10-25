package org.openmrs.module.licensemanagement.web.controller.admin;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.DeviceAttributeType;
import org.openmrs.module.licensemanagement.api.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "module/licensemanagement/admin/deviceAttributeType.list")
public class DeviceAttributeTypeListController {
    private static final String VIEW = "/module/licensemanagement/admin/deviceAttributeTypeList";

    @RequestMapping(method = RequestMethod.GET)
    public String onGet() {
        return VIEW;
    }

    @ModelAttribute("deviceAttributeTypes")
    protected List<DeviceAttributeType> getLicenseTypes() {
        return Context.getService(DeviceService.class).getAllDeviceAttributeTypes(true);
    }
}

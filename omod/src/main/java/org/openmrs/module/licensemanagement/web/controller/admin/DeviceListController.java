package org.openmrs.module.licensemanagement.web.controller.admin;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.Device;
import org.openmrs.module.licensemanagement.api.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("${rootrootArtifactId}.DeviceListController")
@RequestMapping(value = "module/licensemanagement/admin/device.list")
public class DeviceListController {
    private static final String VIEW = "/module/licensemanagement/admin/deviceList";

    @RequestMapping(method = RequestMethod.GET)
    public String onGet() {
        return VIEW;
    }

    @ModelAttribute("devices")
    protected List<Device> getDevices() throws Exception {
        return Context.getService(DeviceService.class).getAllDevices(true);
    }
}

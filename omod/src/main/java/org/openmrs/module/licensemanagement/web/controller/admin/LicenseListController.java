package org.openmrs.module.licensemanagement.web.controller.admin;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.License;
import org.openmrs.module.licensemanagement.api.LicenseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("${rootrootArtifactId}.LicenseListController")
@RequestMapping(value = "module/licensemanagement/admin/license.list")
public class LicenseListController {
    private static final String VIEW = "/module/licensemanagement/admin/licenseList";

    @RequestMapping(method = RequestMethod.GET)
    public String onGet() {
        return VIEW;
    }

    @ModelAttribute("licenses")
    protected List<License> getLicenses() {
        return Context.getService(LicenseService.class).getAllLicenses(true);
    }
}

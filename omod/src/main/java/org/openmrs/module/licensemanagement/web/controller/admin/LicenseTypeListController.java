package org.openmrs.module.licensemanagement.web.controller.admin;

import org.openmrs.api.context.Context;
import org.openmrs.module.licensemanagement.LicenseType;
import org.openmrs.module.licensemanagement.api.LicenseTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("${rootrootArtifactId}.LicenseTypeListController")
@RequestMapping(value = "module/licensemanagement/admin/licenseType.list")
public class LicenseTypeListController {
    private static final String VIEW = "/module/licensemanagement/admin/licenseTypeList";

    @RequestMapping(method = RequestMethod.GET)
    public String onGet() {
        return VIEW;
    }

    @ModelAttribute("licenseTypes")
    protected List<LicenseType> getLicenseTypes() throws Exception {
        return Context.getService(LicenseTypeService.class).getAllLicenseTypes(true);
    }
}

<ul id="menu">
    <li class="first">
        <a href="${pageContext.request.contextPath}/admin/index.htm"><openmrs:message code="admin.title.short"/></a>
    </li>

    <openmrs:hasPrivilege privilege="Manage License Types,Get License Types">
        <li id="licensemanagement-manageLicenseTypes"
            <c:if test='<%= request.getRequestURI().contains("licenseTypeList") %>'>class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/module/licensemanagement/admin/licenseType.list">
                <openmrs:message code="licensemanagement.licenseTypes.manage.title"/>
            </a>
        </li>
    </openmrs:hasPrivilege>

    <openmrs:hasPrivilege privilege="Manage Licenses,Get Licenses">
        <li id="licensemanagement-manageLicenses"
            <c:if test='<%= request.getRequestURI().contains("licenseList") %>'>class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/module/licensemanagement/admin/license.list">
                <openmrs:message code="licensemanagement.licenses.manage.title"/>
            </a>
        </li>
    </openmrs:hasPrivilege>

    <openmrs:hasPrivilege privilege="Manage Device Attribute Types,Get Device Attribute Types">
        <li id="licensemanagement-manageDeviceAttributeTypes"
            <c:if test='<%= request.getRequestURI().contains("deviceAttributeTypeList") %>'>class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/module/licensemanagement/admin/deviceAttributeType.list">
                <openmrs:message code="licensemanagement.deviceAttributeTypes.manage.title"/>
            </a>
        </li>
    </openmrs:hasPrivilege>

    <openmrs:hasPrivilege privilege="Manage Devices,Get Devices">
        <li id="licensemanagement-manageDevices"
            <c:if test='<%= request.getRequestURI().contains("deviceList") %>'>class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/module/licensemanagement/admin/device.list">
                <openmrs:message code="licensemanagement.devices.manage.title"/>
            </a>
        </li>
    </openmrs:hasPrivilege>
</ul>

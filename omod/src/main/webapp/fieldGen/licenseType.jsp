<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ taglib prefix="licensemanagement" tagdir="/WEB-INF/tags/module/licensemanagement" %>

<licensemanagement:licenseTypeField licenseTypes="${model.licenseTypes}" formFieldName="${model.formFieldName}"
                                    initialValue="${model.initialValue}"/>

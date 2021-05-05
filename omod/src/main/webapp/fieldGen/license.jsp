<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ taglib prefix="licensemanagement" tagdir="/WEB-INF/tags/module/licensemanagement" %>

<licensemanagement:licenseField formFieldName="${model.formFieldName}" initialValue="${model.initialValue}"
                                optionHeader="${model.optionHeader}" licenses="${model.licenses}"/>

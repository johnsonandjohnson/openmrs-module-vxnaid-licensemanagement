<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ attribute name="formFieldName" required="true" %>
<%@ attribute name="licenseTypes" required="true" type="java.util.List" %>
<%@ attribute name="initialValue" required="false" %>
<%@ attribute name="optionHeader" required="false" %>

<c:if test="${empty licenseTypes}">
    <openmrs:message code="licensemanagement.licenseType.list.empty"/>
</c:if>
<c:if test="${not empty licenseTypes}">
    <select name="${formFieldName}">
        <c:if test="${optionHeader != ''}">
            <c:if test="${optionHeader == '[blank]'}">
                <option value=""></option>
            </c:if>
            <c:if test="${optionHeader != '[blank]'}">
                <option value="">${optionHeader}</option>
            </c:if>
        </c:if>
        <c:forEach var="licenseType" items="${licenseTypes}">
            <option value="${licenseType.licenseTypeId}"
                    <c:if test="${licenseType.licenseTypeId == initialValue}">selected</c:if>>${licenseType.name}</option>
        </c:forEach>
    </select>
</c:if>

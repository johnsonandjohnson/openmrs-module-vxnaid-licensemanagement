<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ attribute name="formFieldName" required="true" %>
<%@ attribute name="initialValue" required="false" %>
<%@ attribute name="optionHeader" required="false" %>
<%@ attribute name="licenses" required="true" type="java.util.List" %>

<c:if test="${empty licenses}">
    <openmrs:message code="licensemanagement.license.list.empty"/>
</c:if>
<c:if test="${not empty licenses}">
    <select name="${formFieldName}">
        <c:if test="${optionHeader != ''}">
            <c:if test="${optionHeader == '[blank]'}">
                <option value=""></option>
            </c:if>
            <c:if test="${optionHeader != '[blank]'}">
                <option value="">${optionHeader}</option>
            </c:if>
        </c:if>
        <c:forEach var="license" items="${licenses}">
            <option value="${license.licenseId}"
                    <c:if test="${license.licenseId == initialValue}">selected</c:if>>${license.displayString}</option>
        </c:forEach>
    </select>
</c:if>

<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Get License Types" otherwise="/login.htm"
                 redirect="/module/licensemanagement/admin/licenseType.list"/>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="localHeader.jsp" %>

<h2><spring:message code="licensemanagement.licenseTypes.manage.title"/></h2>

<a href="licenseType.form"><openmrs:message code="licensemanagement.licenseType.add"/></a>

<br/><br/>

<b class="boxHeader"><openmrs:message code="licensemanagement.licenseType.list.title"/></b>
<form method="post" class="box">
    <table>
        <tr>
            <th><openmrs:message code="general.name"/></th>
            <th><openmrs:message code="general.description"/></th>
        </tr>
        <c:forEach var="licenseType" items="${licenseTypes}">
            <tr>
                <td valign="top">
                    <a href="licenseType.form?licenseTypeId=${licenseType.licenseTypeId}">
                        <c:choose>
                            <c:when test="${licenseType.retired == true}">
                                <del><c:out value="${licenseType.name}"/></del>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${licenseType.name}"/>
                            </c:otherwise>
                        </c:choose>
                    </a>
                </td>
                <td valign="top"><c:out value="${licenseType.description}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>

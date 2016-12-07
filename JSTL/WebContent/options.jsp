<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- drop-down box -->
<select name="${param.variable}">
	<c:forEach var="temp" items="${param.items}">
		<option>${temp}</option>
	</c:forEach>
</select>
<!-- checkbox -->
<c:forEach var="temp" items="${param.items}">
	<input type="checkbox" value="${temp}" name="goodDay" />
	<c:out value="${temp}" />
</c:forEach>
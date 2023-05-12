<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${accountants}" var="accountant">
    <p>Accountant ID: ${accountant.accountant_id}</p>
    <p>First Name: ${accountant.first_name}</p>
    <!-- Display other accountant details -->
</c:forEach>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="_header.jsp"/>

<h1>All Users!!!</h1>


<table>
    <thead>
        <th>Name</th>
        <th>Email</th>
    </thead>
    <tbody>
        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    
<a href="new.jsp">New User</a>

<jsp:include page="_footer.jsp"/>
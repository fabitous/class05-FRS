<%@page import="br.edu.ifsp.blog.models.User"%>
<jsp:include page="_header.jsp"/>

<h1>Show User</h1>

<%
    User user = (User) request.getAttribute("user");
%>

Name: <%= user.getName() %> <br/>
Email: <%= user.getEmail() %>

<jsp:include page="_footer.jsp"/>
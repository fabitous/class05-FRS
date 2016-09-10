<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifsp.blog.models.User"%>
<jsp:include page="_header.jsp"/>

<h1>All Users!!!</h1>

<%
    ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
%>

<table>
    <thead>
        <th>Name</th>
        <th>Email</th>
    </thead>
    <tbody>
        <%
            for (User user : list) {
        %>
            <tr>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
            </tr>
        <%
        }
        %>
    </tbody>
</table>
    
<a href="new.jsp">New User</a>

<jsp:include page="_footer.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html>

            <head>
                <title>
                    Person CRUD - GNSMK
                </title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            </head>

            <body>
                <div class="container well">
                    <c:if test="${empty newPerson}">
                        <form:form action="/add" method="post">
                            <input style="width:35%; margin: 1px;" type="text" name="name" class="form-control" placeholder="Person Name" autofocus required/>
                            <input style="width:35%; margin: 1px;" type="text" name="age" class="form-control" placeholder="Person Age" required/>
                            <input style="width:23%; margin: 1px;" type="submit" class="btn btn-primary btn-md" value="Add Person" />
                        </form:form>
                    </c:if>
                    <c:if test="${!empty newPerson}">
                        <form:form action="/update" method="post">
                            <input style="width:35%; margin: 1px;" type="text" name="name" class="form-control" value="${newPerson.name}" autofocus required/>
                            <input style="width:35%; margin: 1px;" type="text" name="age" class="form-control" value="${newPerson.age}" required/>
                            <input style="width:23%; margin: 1px;" type="submit" class="btn btn-primary btn-md" value="Update Person" />
                        </form:form>
                    </c:if>
                </div>

                <div class="container well">
                    <c:if test="${!empty list}">
                        <c:forEach items="${list}" var="x">
                            <p style="width:35%; margin: 1px;" class="form-control">${x.name}</p>
                            <p style="width:35%; margin: 1px;" class="form-control">${x.age}</p>
                            <input style="width:15%; margin: 1px;" type="button" onclick="location.href='/edit/${x.id}';" value="Edit" class="btn btn-warning btn-md"
                            />
                            <input style="width:15%; margin: 1px;" type="button" onclick="location.href='/delete/${x.id}';" value="Delete" class="btn btn-danger btn-md"
                            />
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty list}">
                        <p style="text-align-last:center; color:grey">List Empty</p>
                    </c:if>
                </div>
            </body>

            </html>
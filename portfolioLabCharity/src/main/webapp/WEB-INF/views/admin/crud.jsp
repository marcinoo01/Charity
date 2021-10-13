<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <style>
        .change-descripiton {
            color: blue;
        }

        .delete {
            color: red;
        }

        .change-name {
            color: plum;
        }

        .add {
            color: green;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<section class="help">
    <h2>Komu pomagamy?</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>
        <c:forEach begin="0" step="1" end="${count}" items="${institutions}" varStatus="c" var="ins">
            <ul class="help--slides-items">
                <li>
                    <c:if test="${c.index lt c.end}">
                        <div class="col">
                            <div class="title">Fundacja: ${names[c.index]} <a href="/admin/foundation/delete/${ins.id}"
                                                                              class="change-name">Zmien
                                nazwe</a>
                                <div class="subtitle">Cel i misja: ${descriptions[c.index]} <a
                                        href="/admin/foundation/edit/{id}" class="change-descripiton"> Zmien opis</a>
                                </div>
                                <a href="/admin/foundation/delete/{id}" class="delete">Usun</a>
                            </div>
                        </div>
                    </c:if>
                </li>
            </ul>
        </c:forEach>
        <h1><a href="/admin/foundation/add" class="add" >Dodaj nowa fundacje</a></h1>
    </div>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>

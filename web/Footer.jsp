
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/footer.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="footer">
            <div class="link">
                <a href="#">Created with SimpleSite </a>
                <c:forEach items="${totalViewsNumber}" var="i" varStatus="loop">
                    <span class="footer-page-counter-item">${i}</span>
                </c:forEach>
            </div>

        </div>
    </body>
</html>

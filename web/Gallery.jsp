<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${galery.name}</h3>
                    </div>
                    <c:if test="${error != null}">
                        <h3 style="margin-bottom: 600px"> ${error}</h3>
                    </c:if>
                    <c:if test="${error == null}">
                        <div class="imageGaler">
                            <div class="images" id="slides">
                                <c:forEach items="${slideShow}" var="i" varStatus="loop">
                                        <img class="${i.id == 1 ? "slide showing" : "slide"}" src="${i.imageUrl}">
                                </c:forEach>
                            </div>
                            <div class="btn leftShow showing">
                                <span class="button fas fa-pause" id="pause" aria-hidden="true"></span>
                            </div>
                        </div>
                        <div class="contentGalery">
                            <c:if test="${error == null}">
                                <ul >
                                    <c:if test="${index <= maxPage}">
                                        <c:forEach items="${listImage}" var="i" varStatus="loop">
                                            <li class="span4">
                                                <a href="PhotoDeailPageController?index=${index}&galeryID=${galeryID}&imgID=${i.id}"><img src="${i.imageUrl}"></a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                            </c:if>    
                            <div class="paging">
                                <c:if test="${maxPage > 1}">
                                    <c:forEach begin="1" end="${maxPage}" var="i">
                                        <a class="${i==index?"active":""}" href="GaLeryServlet?index=${i}&galeryID=${galeryID}">${i}</a>
                                        <c:set var="index" value="${index}" />
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </c:if>

                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
    <script>
    var slides = document.querySelectorAll('#slides .slide');
    var currentSlide = 0;
    var slideInterval = setInterval(nextSlide, 2000);

    function nextSlide() {
        slides[currentSlide].className = 'slide';
        currentSlide = (currentSlide + 1) % slides.length;
        slides[currentSlide].className = 'slide showing';
    }

    var playing = true;
    var pauseButton = document.getElementById('pause');

    function pauseSlideshow() {
        playing = false;
        clearInterval(slideInterval);
    }

    function playSlideshow() {
        playing = true;
        slideInterval = setInterval(nextSlide, 2000);
    }

    pauseButton.onclick = function () {
        if (playing) { pauseSlideshow(); }
        else { playSlideshow(); }
    };

    $(document).ready(function () {
        var btn = $(".button");
        btn.click(function () {
            btn.toggleClass("fas fa-play");
            btn.toggleClass("fas fa-pause");
            return false;
        });
    });

    
</script>
</html>

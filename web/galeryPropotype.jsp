

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
   
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>Gallery name</h3>
                    </div>

                    <div class="imageGaler">
                        <div class="images" id="slides">


                            <img class="#" src="images/img1.jpg">

                        </div>
                        <div class="btn leftShow showing">
                            <span class="button fas fa-pause" id="pause" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="contentGalery">

                        <ul >


                            <li class="span4">
                                <a href="#"><img src="images/img3.jpg"></a>

                            </li>
                            <li class="span4">
                                <a href="#"><img src="images/img3.jpg"></a>

                            </li>
                            <li class="span4">
                                <a href="#"><img src="images/img3.jpg"></a>

                            </li>


                        </ul>

                        1 &nbsp;2
                    </div>


                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
   
</html>

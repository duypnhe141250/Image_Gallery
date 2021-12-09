

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
                    <div class="image">
                        <img src="images/img1.jpg" alt="First">
                    </div>
                    <div class="description">
                        Lorem ipsum dolor sit amet
                    </div>
                    <div class="content">

                        <ul >

                            <li class="span4">
                                <div class="image">
                                    <img src="images/img2.jpg">
                                </div>
                                <h4>
                                    <a href="">Gallery 1</a>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore
                                    magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
                                    quis nostrud exerci tation1fdsffdsdffdsdfsdfdsfdsfdsfdfds</p>
                            </li>
                            <li class="span4">
                                <div class="image">
                                    <img src="images/img2.jpg">
                                </div>
                                <h4>
                                    <a href="">Gallery 1</a>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore
                                    magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
                                    quis nostrud exerci tation1</p>
                            </li>
                            <li class="span4">
                                <div class="image">
                                    <img src="images/img2.jpg">
                                </div>
                                <h4>
                                    <a href="">Gallery 1</a>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore 
                                    magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
                                    quis nostrud exerci tation1</p>
                            </li>



                        </ul>


                        1 &nbsp;2
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                        About me Lorem ipsum dolor sit amet, consectetuer adipiscing elit
                        , sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna

                        aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud 
                        exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea 
                        commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
                        vulputate velit esse molestie consequat, vel illum dolore eu feugiat
                        nulla facilisis at vero eros et accumsan et iusto odio dignissim qui 
                        blandit praesent luptatum zzril delenit augue duis dolore te feugait 
                        nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue 
                        nihil imperdiet doming id quod mazim
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

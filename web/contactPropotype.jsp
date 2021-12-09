
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
                        <h3>Contact</h3>
                    </div>
                    <div class="content-contact">
                        <h4>PHOTOGRAPHER</h4>
                        <div class="country">
                            <p>Address: adádsadsad<br>City:<span class="tab-1"></span>agraggradga<br>Country:  agsgàdsfầ</p>
                        </div>
                        <div class="infor">
                            <table>
                                <tr>
                                    <td>Tel: </td>
                                    <td>01515105</td>
                                </tr>
                                <tr>
                                    <td>Email: </td>
                                    <td>duypnhe141250@gmail.com</td>
                                </tr>

                            </table>
                            <label> </label> <span></span>
                        </div> 
                        <div class="map">
                            
                            
                            
                        </div>
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

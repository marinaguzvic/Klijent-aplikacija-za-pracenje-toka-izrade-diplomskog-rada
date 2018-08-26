<%-- 
    Document   : login
    Created on : Apr 18, 2018, 12:34:55 PM
    Author     : FON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="/app/resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="/app/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/app/resources/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="bg">
            <div class="container content">
                <jsp:include page="/WEB-INF/template/template.jsp"></jsp:include>
                    <form action="/app/controller" method="POST">
                        <c:if test="${requestScope.errorMessage != null}">
                        <div class="alert alert-danger alert-dismissable fade show" role="alert">
                            <strong>Greška!</strong> ${requestScope.errorMessage}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    <div class="input-group input" >
                        <span class="input-group-addon input-lbl custom-active" id="basic-addon1">Korisničko ime</span>
                        <input type="text" name="korisnickoIme" class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="input-group input">
                        <span class="input-group-addon input-lbl custom-active" id="basic-addon1">Šifra</span>
                        <input type="password" name="sifra" class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <input type="hidden" name="action" value="login" />
                    <button type="submit" class="btn btn-lg btn-block space">Prijavi se</button>
                </form>
            </div>
        </div>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>


    </body>
</html>

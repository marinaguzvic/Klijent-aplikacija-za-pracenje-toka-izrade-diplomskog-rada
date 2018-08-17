<%-- 
    Document   : landingpage
    Created on : Aug 14, 2018, 7:12:56 PM
    Author     : Marina Guzvic
--%>

<%@page import="rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <table class="table table-striped">
                   
                    <tbody>
                    <c:forEach var="property" items="${sessionScope.nalog.getProperties()}">
                        <tr>
                            <td>${property}</td>
                            <td>${sessionScope.nalog.getPropertyByName(property)}</td>
                        </tr>
                    </c:forEach>
                      
                    </tbody>
                </table>
            </div>
        </div>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../resources/js/npm.js" type="text/javascript"></script>

    </body>
</html>

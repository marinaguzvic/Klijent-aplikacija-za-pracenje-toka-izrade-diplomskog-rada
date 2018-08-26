<%-- 
    Document   : diplomskirad
    Created on : Aug 15, 2018, 10:58:32 PM
    Author     : Marina Guzvic
--%>

<%@page import="rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants"%>
<%@page import="rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diplomski rad</title>

        <link href="/app/resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="/app/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/app/resources/css/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="bg">
            <div class="container content">
                <jsp:include page="/WEB-INF/template/template.jsp"></jsp:include>
                <c:if test="${requestScope.errorMessage != null}">
                    <div class="alert alert-danger alert-dismissable fade show" role="alert">
                        <strong>Greška!</strong> ${requestScope.errorMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <c:if test="${requestScope.successMessage != null}">
                    <div class="alert alert-success alert-dismissable fade show" role="alert" >
                        <strong>Uspešno!</strong> ${requestScope.successMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <table class="table table-striped">

                    <tbody>
                        <c:forEach var="diplomskiProp" items="${sessionScope.diplomskiRad.getNotNullProperties()}">
                            <tr>
                                <td>${diplomskiProp}</td>
                                <td>${sessionScope.diplomskiRad.getPropertyByName(diplomskiProp)}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>Predate datoteke</td>
                            <td>

                                <c:forEach var="dokument" items="${sessionScope.diplomskiRad.getDokuments()}">
                            <tr>
                                <td>
                                    ${dokument.getNazivDokumenta()}
                                </td>
                                <td>
                                    <a class="btn btn-info" href="${'localhost:8080/'.concat(sessionScope.diplomskiRad.generateUrl().concat(dokument.generateUrl()))}" target="_blank" download>Preuzmi</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </td>
                        </tr>
                    </tbody>
                </table>
                <c:if test="${sessionScope.diplomskiRad.status.equalsIgnoreCase('ODREDJENA_KOMISIJA')}">
                    <form action="/app/controller" method="post" enctype="multipart/form-data" id="js-upload-form">
                        <label class="btn btn-outline-info" for="my-file-selector">
                            Izaberite datoteku <input style="display: none;" type="file" name="file" id="my-file-selector" onchange="$('#upload-file-info').html(this.files[0].name)"/>
                        </label>

                        <input type="hidden" name="action" value="upload" />
                        <span id="upload-file-info"></span>
                        <button type="submit" class="btn btn-smd btn-outline-info pull-right" id="js-upload-submit">Predajte</button>

                    </form>
                </c:if>
            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>

<%-- 
    Document   : diplomskipromenakomisije
    Created on : Aug 27, 2018, 2:41:42 PM
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
                    <div class="alert alert-danger alert-dismissable" role="alert">
                        <strong>Greška!</strong> ${requestScope.errorMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <c:if test="${requestScope.successMessage != null}">
                    <div class="alert alert-success alert-dismissable" role="alert" >
                        <strong>Uspešno!</strong> ${requestScope.successMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>
                                Član komisije
                            </th>
                            <th>
                                Uloga
                            </th>
                            <th>
                                Novi član komisije
                            </th>
                            <th>
                                Promeni
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="clan" items="${requestScope.clans}">
                            <tr>
                        <form action="/app/controller" method="POST">
                            <input type="hidden" name="clanid" value="${clan.clanKomisijeRb}">
                            <input type="hidden" name="diplomskiid" value="${requestScope.diplomskiid}">
                            <td>${clan.nastavnikIdFk.ime.concat(' ').concat(clan.nastavnikIdFk.prezime)}</td>
                            <td>${clan.ulogaClanaKomisije}</td>
                            <td><select class="selectpicker form-control" name="nastavnik" data-show-subtext="true" data-live-search="true" >
                                    <c:forEach var="nastavnik" items="${requestScope.nastavniks}">
                                        <option data-subtext="${nastavnik.katedra}" value="${nastavnik.clanSistemaId}" ${(nastavnik.amongClanovi(requestScope.clans))?'disabled':''}>${nastavnik.ime.concat(' ').concat(nastavnik.prezime)}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <button type="submit" name="action" value="potvrdipromenuclana" class="btn btn-smd space">Promeni člana</button>
                            </td>
                        </form>




                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>
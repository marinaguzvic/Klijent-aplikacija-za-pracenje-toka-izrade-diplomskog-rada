<%-- 
    Document   : diplomskikomisija
    Created on : Aug 25, 2018, 10:23:22 PM
    Author     : Marina Guzvic
--%>

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
                <form action="/app/controller" method="POST">
                    <c:if test="${!sessionScope.odredjen}">
                        <div class="row-fluid">
                            <label>Nastavnik</label>
                            <select class="selectpicker form-control" name="nastavnik" data-show-subtext="true" data-live-search="true" >
                                <c:forEach var="nastavnik" items="${sessionScope.nastavniks}">
                                    <option data-subtext="${nastavnik.katedra}" value="${nastavnik.clanSistemaId}" ${sessionScope.clans.contains(nastavnik)?'disabled':''}>${nastavnik.ime.concat(' ').concat(nastavnik.prezime)}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                    <button type="submit" name="action" value="dodajclana" class="btn btn-lg btn-block space">Dodaj člana</button>
                    <table class="table table-striped">
                        <c:forEach var = "clan" items="${sessionScope.clans}">
                            <tr>
                                <td>${clan.ime.concat(' ').concat( clan.prezime)}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button type="submit" name="action" value="potvrdiclanove" class="btn btn-lg btn-block space" ${(sessionScope.clans.size() != 3 && sessionScope.clans.size() != 5)?'disabled':''} ${sessionScope.odredjen?'hidden':''}>Potvrdi članove</button>
                    <c:if test="${sessionScope.odredjen}">
                        <div class="row-fluid">
                            <label>Nastavnik</label>
                            <select class="selectpicker form-control" name="mentor" data-show-subtext="true" data-live-search="true" >
                                <c:forEach var="clan" items="${sessionScope.clans}">
                                    <option value="${clan.clanSistemaId}">${clan.ime.concat(' ').concat(clan.prezime)}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                    <button type="submit" name="action" value="potvrdikomisiju" class="btn btn-lg btn-block space">Potvrdi promene</button>
                </form>
                    <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>


<%-- 
    Document   : login
    Created on : Apr 18, 2018, 12:34:55 PM
    Author     : FON
--%>
<%@page import="rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div clas="page-header">
    <div class="media">
        <div class="media-left">
            <a href="#">
                <img class="media-object" src="/KlijentAplikacijaZaPracenjeTokaIzradeDiplomskogRada/resources/images/logo.png" alt="FON Logo"/>
            </a>
        </div>
        <div class="media-body">
            <h4 class="media-heading text-right naslov"></br>Servis za praćenje toka</br>izrade diplomskog rada</h4>
        </div>
    </div>
</div>
<nav class="navbar navbar-default custom-color" style="margin: 10px 0px;">
    <ul class="nav navbar-nav">
        <c:choose>
            <c:when test="${sessionScope.nalog == null}">
                <li class="custom-active"><a href="#">Prijavite se<span class="sr-only">(current)</span></a></li></ul>
                </c:when>
                <c:otherwise>
            <li class="${requestScope.page.equalsIgnoreCase("Moj nalog") ? "custom-active":"non-active"}"><a href="/app/controller?action=landingpage">Moj nalog</a></li>
            <c:choose>    
            <c:when test="${sessionScope.nalog.getTipClana() == 'S'}">
                    <jsp:include page="templatemenustudent.jsp"></jsp:include>
                </c:when>
                <c:when test="<${sessionScope.nalog.getTipClana() == 'N'}">
                    <jsp:include page="templatemenunastavnik.jsp"></jsp:include>
                </c:when>
                <c:when test="${sessionScope.nalog.getTipClana() == 'R'}">
                    <jsp:include page="templatemenuradnik.jsp"></jsp:include>
                </c:when>
            </c:choose>
                </ul><ul class="nav navbar-nav navbar-right" style="padding-right: 20px;">
            <li><a href="/app/controller?action=logout">Odjavite se</a></li></ul>
                </c:otherwise>  

</c:choose>


</nav>
<div class="container-fluid custom-color" style="margin-bottom: 10px;">
    <div class="pull-left"><h2>${requestScope.page != null ? requestScope.page:"Prijavite se"}</h2></div>
    <div class="pull-right"><h2>${sessionScope.nalog != null? sessionScope.nalog.getPotpisClana():""}</h2></div>
</div>



<%-- 
    Document   : temeunos
    Created on : Aug 24, 2018, 7:36:35 PM
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
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
    </head>

    <body>
        <div class="bg">
            <div class="container content">
                <jsp:include page="/WEB-INF/template/template.jsp"></jsp:include>
                <c:if test="${requestScope.errorMessage != null}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <strong>Greška!</strong> ${requestScope.errorMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <c:if test="${requestScope.successMessage != null}">
                    <div class="alert alert-success alert-dismissible" role="alert" >
                        <strong>Uspešno!</strong> ${requestScope.successMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <form action="/app/controller" method="POST">
                    <fieldset class="upd" disabled="true">
                        <jsp:include page="../template/temaform.jsp"></jsp:include>
                    </fieldset>
                    <button id="tog" onclick="$(function toggleEnabledDisabled(parameters) {
                                if ($('.upd').prop('disabled') === true) {
                                    $('.upd').prop('disabled', false);
                                    $('#tog').html('Omogući izmene');
                                } else {
                                    $('.upd').prop('disabled', true);
                                    $('#tog').html('Onemogući izmene');
                                }
                            })"  class="btn btn-lg btn-block space" type="button">Omogući izmene</button>


                    <button type="submit" name="action" value="updatetema" class="btn btn-lg btn-block space upd">Potvrdi izmene</button>
                    <button type="reset" class="btn btn-lg btn-block space">Poništi promene</button>
                </form>
            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
    </body>
</html>


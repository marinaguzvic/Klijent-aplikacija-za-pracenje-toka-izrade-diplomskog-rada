<%-- 
    Document   : students
    Created on : Aug 19, 2018, 10:45:16 AM
    Author     : Marina Guzvic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div>

                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#student" aria-controls="student" role="tab" data-toggle="tab">Student</a></li>
                            <li role="presentation"><a href="#diplomski" aria-controls="diplomski" role="tab" data-toggle="tab">Diplomski rad</a></li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade in active" id="student">
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

                                <div class="form-group">
                                    <fieldset class="upd" disabled="true">
                                        <jsp:include page="/WEB-INF/template/studentform.jsp"></jsp:include>
                                        </fieldset>
                                    </div>

                                    <button id="tog" onclick="$(function toggleEnabledDisabled(parameters) {
                                                if ($('.upd').prop('disabled') === true) {
                                                    $('.upd').prop('disabled', false);
                                                    $('#tog').html('Onemogući izmene');
                                                } else {
                                                    $('.upd').prop('disabled', true);
                                                    $('#tog').html('Omogući izmene');
                                                }
                                            })"  class="btn btn-lg btn-block space" type="button">Omogući izmene</button>


                                            <button type="submit" name="action" value="updatestudent" class="btn btn-lg btn-block space upd" disabled onclick="$($('.upd').prop('disabled', true);$('#tog').html('Omogući izmene');)">Potvrdi izmene</button>
                                            <button type="reset" class="btn btn-lg btn-block space upd" disabled>Poništi promene</button>
                                </form>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="diplomski">
                            <c:if test="${requestScope.errorMessage != null}">
                                <div class="alert alert-danger alert-dismissible" role="alert">
                                    <strong>Greška!</strong>Sistem ne može da pronađe diplomski rad
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </c:if>
                            <c:if test="${requestScope.successMessage != null}">
                                <div class="alert alert-success alert-dismissible" role="alert">
                                    <strong>Uspešno!</strong> Sistem je pronašao diplomski rad
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </c:if>
                            <table class="table table-striped">

                                <tbody>
                                    <c:forEach var="diplomskiProp" items="${requestScope.diplomskiRad.getNotNullProperties()}">
                                        <tr>
                                            <td>${diplomskiProp}</td>
                                            <td>${requestScope.diplomskiRad.findPropertyByName(diplomskiProp)}</td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${!(requestScope.diplomskiRad.getDokuments() == null) && !requestScope.diplomskiRad.getDokuments().isEmpty()}">
                                        <tr>
                                            <td>Predate datoteke</td>
                                            <td>

                                                <c:forEach var="dokument" items="${requestScope.diplomskiRad.getDokuments()}">
                                            <tr>
                                                <td>
                                                    ${dokument.getNazivDokumenta()}
                                                </td>
                                                <td>
                                                    <a class="btn btn-info" href="${'localhost:8080/'.concat(requestScope.diplomskiRad.generateUrl().concat(dokument.generateUrl()))}" target="_blank" download>Preuzmi</a>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </td>
                                        </tr>
                                    </c:if>

                                </tbody>
                            </table>


                            <form action="/app/controller" method="POST">
                                <input type="hidden" name="studentid" value="${requestScope.student.clanSistemaId}">
                                <input type="hidden" name="diplomskiid" value="${requestScope.diplomskiRad.diplomskiRadId}">

                                <c:choose>
                                    <c:when test="${requestScope.student.godinaStudija < 4}">
                                        <h4>Diplomski rad nije moguce prijaviti</h4>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${requestScope.diplomskiRad == null}">
                                                <table class="table table-striped">
                                                    <tbody>
                                                        <tr>
                                                            <td>${requestScope.student.ime.concat(' ').concat(requestScope.student.prezime).concat(' ').concat(requestScope.student.brojIndeksa)}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <button name="action" value="prijavidiplomski" class="btn btn-lg btn-block space">Prijavi diplomski rad</button>
                                            </c:when>
                                            <c:otherwise>
                                                <c:choose>
                                                    <c:when test="${requestScope.diplomskiRad.status == 'PRIJAVLJEN'}">
                                                        <button name="action" value="odobridiplomski" class="btn btn-lg btn-block space">Odobri</button>
                                                    </c:when>
                                                    <c:when test="${requestScope.diplomskiRad.status == 'ODOBREN'}">
                                                        <button name="action" value="newkomisija" class="btn btn-lg btn-block space">Odredi komisiju</button>
                                                    </c:when>
                                                    <c:when test="${requestScope.diplomskiRad.status == 'ODREDJENA_KOMISIJA'}">
                                                        <button name="action" value="predajdiplomski" class="btn btn-lg btn-block space">Predaj diplomski rad</button>
                                                        <button name="action" value="promeniclana" class="btn btn-lg btn-block space">Promeni člana komisije</button>
                                                    </c:when>
                                                    <c:when test="${requestScope.diplomskiRad.status == 'PREDAT' && requestScope.diplomskiRad.datumOdbrane == null}">
                                                        <button name="action" value="odredidatumodbrane" class="btn btn-lg btn-block space">Odredi datum odbrane</button>
                                                        <button name="action" value="promeniclana" class="btn btn-lg btn-block space">Promeni člana komisije</button>
                                                    </c:when>
                                                    <c:when test="${requestScope.diplomskiRad.status == 'PREDAT' && requestScope.diplomskiRad.datumOdbrane != null}">
                                                        <button name="action" value="odbranidiplomski" class="btn btn-lg btn-block space">Evidentiraj odbranu</button>
                                                    </c:when>
                                                </c:choose>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                        </div>

                    </div>

                </div>
                <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
    </body>
</html>
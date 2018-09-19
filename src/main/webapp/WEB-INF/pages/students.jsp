<%-- 
    Document   : students
    Created on : Aug 20, 2018, 7:14:37 PM
    Author     : Marina Guzvic
--%>

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
                <div class="panel-group" id="accordion">
                    <div class="space panel">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1" style="text-decoration: none;">
                                    Pretraživanje
                                    <span class="glyphicon glyphicon-search pull-right" aria-hidden="true"></span>
                                </a>
                            </h4>
                        </div>  
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <form method="POST" action="/app/controller">
                            <div class="container-fluid" >
                                <div class="row panel" style="background-color: white;margin: 15px 0px;" >
                                    <div class="col-sm-3 col-md-6" ><h3>Osnovna pretraga</h3></div>
                                    <div class="col-sm-3 col-md-6" ><h3>Napredna pretraga</h3></div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3 col-md-6" >
                                        <div class="form-check form-check-inline">
                                            <label for="exampleFormControlInput1">Ime</label>
                                            <input type="text" class="form-control" name = "ime" id="exampleFormControlInput1" placeholder="Ime" value="${requestScope.studentsearchcriteria != null?requestScope.studentsearchcriteria.ime:''}">
                                            <label for="exampleFormControlInput2">Prezime</label>
                                            <input type="text" class="form-control" name = "prezime" id="exampleFormControlInput2" placeholder="Prezime" value="${requestScope.studentsearchcriteria != null?requestScope.studentsearchcriteria.prezime:''}">
                                            <label for="exampleFormControlInput3">Broj indeksa</label>
                                            <input type="text" class="form-control" name = "brojindeksa" id="exampleFormControlInput3" placeholder="Broj indeksa" value="${requestScope.studentsearchcriteria != null?requestScope.studentsearchcriteria.brojIndeksa:''}">
                                        </div>
                                    </div>
                                    <div class="col-sm-3 col-md-6" >
                                        <div class="form-check form-check-inline">
                                            <label for="exampleFormControlInput4">JMBG</label>
                                            <input type="text" class="form-control" name = "jmbg" id="exampleFormControlInput4" placeholder="JMBG" value="${requestScope.studentsearchcriteria != null?requestScope.studentsearchcriteria.jmbg:''}">
                                            <label for="exampleFormControlInput5">Broj telefona</label>
                                            <input type="text" class="form-control" name = "brojtelefona" id="exampleFormControlInput5" placeholder="Broj telefona" value="${requestScope.studentsearchcriteria != null?requestScope.studentsearchcriteria.brojTelefona:''}">
                                            <label for="exampleFormControlInput4">Godina studija</label>
                                            <div class="form-check form-check-inline">
                                                <c:forEach var="godina" begin="1" end="4" step="1">
                                                    <label class="form-check-label" for="inlineCheckbox${godina}">${godina}</label>

                                                    <c:if test="${requestScope.studentsearchcriteria != null}">
                                                         <% boolean found = false; %>
                                                        <c:forEach var="godinacriteria" items="${requestScope.studentsearchcriteria.godineStudija}">
                                                            <c:if test="${godinacriteria == godina}">
                                                                <% found = true; %>
                                                                <input class="form-check-input" type="checkbox" name = "godinestudija" id="inlineCheckbox${godina}" value="${godina}" checked/>
                                                                
                                                            </c:if>
                                                        </c:forEach>
                                                            <c:if test="<%= !found%>">
                                                            <input class="form-check-input" type="checkbox" name = "godinestudija" id="inlineCheckbox${godina}" value="${godina}"/>
                                                        </c:if>
                                                    </c:if>
                                                    <c:if test="${requestScope.studentsearchcriteria == null}">  
                                                        <input class="form-check-input" type="checkbox" name = "godinestudija" id="inlineCheckbox${godina}" value="${godina}"/>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" name="action" value="searchstudents" class="btn btn-lg btn-block space">Pronađi</button>
                    </div>
                </div>
                </form>
                <c:choose>
                    <c:when test="${(requestScope.students == null || requestScope.students.isEmpty()) && (sessionScope.students == null || sessionScope.students.isEmpty()) }">
                        <h3>Trenutno ne postoji ni jedan student koji odgovara zadatim kriterijumima</h3>
                    </c:when>
                    <c:otherwise>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <c:forEach var="prop" items="${sessionScope.students.get(0).findCrucialProperties()}">
                                        <th>
                                            ${prop}
                                        </th>
                                    </c:forEach>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="student" items="${requestScope.students != null? requestScope.students:sessionScope.students}">
                                    <tr onclick="window.location = '/app/controller?studentid=${student.getClanSistemaId()}&action=viewstudent';">
                                        <c:forEach var="prop" items="${student.findCrucialProperties()}">
                                            <td>
                                                ${student.findPropertyByName(prop)}
                                            </td>
                                        </c:forEach>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
                <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>

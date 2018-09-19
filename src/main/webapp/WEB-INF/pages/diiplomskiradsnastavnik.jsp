<%-- 
    Document   : diiplomskiradsnastavnik
    Created on : Aug 19, 2018, 8:03:46 AM
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
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                    Pretraživanje
                                </a>
                            </h4>
                        </div>  
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <form method="POST" action="/app/controller">
                            <div class="container-fluid" >
                                <div class="row panel" style="background-color: white;margin: 15px 0px;" >
                                    <div class="col-sm-3 col-md-4" ><h3>Status</h3></div>
                                    <div class="col-sm-3 col-md-4" ><h3>Uloga u komisiji</h3></div>
                                    <div class="col-sm-3 col-md-4" ><h3>Student</h3></div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3 col-md-4" >
                                        <c:forEach var="status" items="${sessionScope.statuses}">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox" name = "stat" id="inlineCheckbox1" value="${status}">
                                                <label class="form-check-label" for="inlineCheckbox1">${status}</label>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="col-sm-9 col-md-4">
                                        <c:forEach var="uloga" items="${sessionScope.ulogas}">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox" name = "uloge" id="inlineCheckbox1" value="${uloga}">
                                                <label class="form-check-label" for="inlineCheckbox1">${uloga}</label>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="col-sm-9 col-md-4" >
                                        <div class="form-group">
                                            <label for="exampleFormControlInput1">Ime</label>
                                            <input type="text" class="form-control" name = "ime" id="exampleFormControlInput1" placeholder="Ime">
                                            <label for="exampleFormControlInput1">Prezime</label>
                                            <input type="text" class="form-control" name = "prezime" id="exampleFormControlInput1" placeholder="Prezime">
                                            <label for="exampleFormControlInput1">Broj indeksa</label>
                                            <input type="text" class="form-control" name = "brojindeksa" id="exampleFormControlInput1">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" name="action" value="diplomskisearch" class="btn btn-lg btn-block space">Pronađi</button>
                        </form>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${requestScope.diplomskiRads == null || requestScope.diplomskiRads.isEmpty()}">

                        <h3>Trenutno ne postoji ni jedan diplomski rad koji odgovara zadatim kriterijumima</h3>
                    </c:when>
                    <c:otherwise>



                        <!--Dodati c if, kako bih obezbedila da postoje podaci, ako ne postoje, treba da ispise da ne postoje-->
                        <table class="table table-striped table-hover">


                            <thead>
                                <tr>
                                    <c:forEach var="p" items="${requestScope.diplomskiRads.get(0).findCrucialProperties()}">
                                        <th>
                                            ${p}
                                        </th>
                                    </c:forEach>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="diplomski" items="${requestScope.diplomskiRads}">
                                    <tr onclick="window.location = '/app/controller?diplomskiid=${diplomski.getDiplomskiRadId()}&action=diplomskiviewnastavnik';">
                                        <c:forEach var="prop" items="${diplomski.findCrucialProperties()}">
                                            <td>
                                                ${diplomski.findPropertyByName(prop)}
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

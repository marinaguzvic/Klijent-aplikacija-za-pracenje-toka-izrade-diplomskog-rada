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
                    <div id="collapse1" class="panel-collapse collapse in">
                        <form method="POST" action="/app/controller">
                            <div class="container-fluid" >
                                <div class="row panel" style="background-color: white;margin: 15px 0px;" >
                                    <div class="col-sm-3 col-md-6" ><h3>Pretraga</h3></div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3 col-md-12" >
                                        <div class="form-check form-check-inline">
                                            <label for="exampleFormControlInput1">Naziv</label>
                                            <input type="text" class="form-control" name = "ime" id="exampleFormControlInput1" placeholder="Naziv">
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>

                </div>
                <button type="submit" name="action" value="temasearch" class="btn btn-lg btn-block space">Pronađi</button>
                </form>
                <c:choose>
                    <c:when test="${requestScope.teme == null || requestScope.teme.isEmpty()}">

                        <h3>Trenutno ne postoji ni jedna tema koja odgovara zadatim kriterijumima</h3>
                    </c:when>
                    <c:otherwise>



                        <!--Dodati c if, kako bih obezbedila da postoje podaci, ako ne postoje, treba da ispise da ne postoje-->
                        <table class="table table-striped table-hover">


                            <thead>
                                <tr>
                                    <c:forEach var="prop" items="${requestScope.teme.get(0).getCrucialProperties()}">
                                        <th>
                                            ${prop}
                                        </th>
                                    </c:forEach>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tema" items="${requestScope.teme}">
                                    <tr onclick="window.location = '/app/controller?temaid=${tema.temaId}&action=viewtema';">
                                        <c:forEach var="prop" items="${tema.getCrucialProperties()}">
                                            <td>
                                                ${tema.getPropertyByName(prop)}
                                            </td>
                                        </c:forEach>

                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <script src="/app/resources/js/jquery.js" type="text/javascript"></script>
        <script src="/app/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
    </body>
</html>

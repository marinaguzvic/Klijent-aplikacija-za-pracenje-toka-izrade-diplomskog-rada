<%-- 
    Document   : temaform
    Created on : Aug 24, 2018, 8:07:46 PM
    Author     : Marina Guzvic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<label for="exampleFormControlInput1">Naziv</label>
<input type="text" class="form-control" name = "nazivTeme" id="exampleFormControlInput1" placeholder="Naziv" value="${requestScope.tema == null? '':requestScope.tema.nazivTeme}">
<label for="exampleFormControlInput2">Opis</label>

<textarea class="form-control" name = "opisTeme" placeholder="Opis" aria-label="With textarea" id="exampleFormControlInput2">${requestScope.tema == null? '':requestScope.tema.opisTeme}</textarea>
<label for="exampleFormControlInput3">Predmet</label>
<div class="row-fluid">
    <select class="selectpicker form-control" name="predmet" data-show-subtext="true" data-live-search="true" >
        <c:forEach var="predmet" items="${sessionScope.predmeti}">
            <option data-subtext="${predmet.katedra}" value="${predmet.predmetId}" ${requestScope.tema == null? ((predmet.predmetId == sessionScope.predmeti.get(0).predmetId)?'selected':''):((predmet.predmetId == requestScope.tema.predmetIdFk.predmetId)?'selected':'')}>${predmet.nazivPredmeta}</option>
        </c:forEach>
    </select>
</div>
<input type="hidden" name="id" value="${requestScope.tema.temaId}">
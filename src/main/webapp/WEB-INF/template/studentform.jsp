<%-- 
    Document   : studentform
    Created on : Aug 20, 2018, 5:11:07 PM
    Author     : Marina Guzvic
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<label for="exampleFormControlInput1">Ime</label>
<input type="text" class="form-control" name = "ime" id="exampleFormControlInput1" placeholder="Ime" value="${requestScope.student == null? '':requestScope.student.ime}">
<label for="exampleFormControlInput2">Prezime</label>
<input type="text" class="form-control" name = "prezime" id="exampleFormControlInput2" placeholder="Prezime" value="${requestScope.student == null? '':requestScope.student.prezime}">
<label for="exampleFormControlInput3">Broj indeksa</label>
<input type="text" class="form-control" name = "brojindeksa" id="exampleFormControlInput3" placeholder="Broj indeksa se automatski generiše"  value="${requestScope.student == null? '':requestScope.student.brojIndeksa}" disabled>
<label for="exampleFormControlInput4">Broj telefona</label>
<input type="tel" class="form-control" name = "brojtelefona" id="exampleFormControlInput4"  value="${requestScope.student == null? '':requestScope.student.brojTelefona}">
<label for="exampleFormControlInput5">JMBG</label>
<input type="text" class="form-control" name = "jmbg" id="exampleFormControlInput5"  value="${requestScope.student == null? '':requestScope.student.jmbg}">
<label for="exampleFormControlInput6">Datum rođenja</label>
<input type="date" class="form-control" name = "datumrodjenja" id="exampleFormControlInput6"  value="${requestScope.student == null? '':requestScope.student.datumRodjenja}">
<label for="exampleFormControlInput7">Godina studija</label>
<input type="number" min="1" max="4" class="form-control" name = "godinastudija" id="exampleFormControlInput7" value="${requestScope.student == null? '':requestScope.student.godinaStudija}">
<input type="hidden" name="id" value="${requestScope.student.clanSistemaId}">
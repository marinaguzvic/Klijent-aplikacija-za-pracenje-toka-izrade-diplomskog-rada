<%-- 
    Document   : templatemenuradnik
    Created on : Aug 14, 2018, 7:22:25 PM
    Author     : Marina Guzvic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Dodati ul-->
<li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Studenti<span class="caret"></span></a>
    <ul class="dropdown-menu custom-active">
        <li class="custom-active"><a href="/app/controller?action=newstudent">Unos</a></li>
        <li class="custom-active"><a href="/app/controller?action=viewstudents">Pretraga</a></li>
    </ul>
</li>
<li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Teme<span class="caret"></span></a>
    <ul class="dropdown-menu custom-active">
        <li class="custom-active"><a href="/app/controller?action=newtema">Unos</a></li>
        <li class="custom-active"><a href="/app/controller?action=viewalltemas">Pretraga</a></li>
    </ul>
</li>



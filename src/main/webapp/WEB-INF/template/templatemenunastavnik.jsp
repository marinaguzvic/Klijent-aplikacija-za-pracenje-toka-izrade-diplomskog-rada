<%-- 
    Document   : templatemenunastavnik
    Created on : Aug 14, 2018, 7:22:14 PM
    Author     : Marina Guzvic
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<li class="${requestScope.page.equalsIgnoreCase("Pregled diplomskih radova") ? "custom-active":"non-active"}"><a href="/app/controller?action=diplomskiviewall">Diplomski radovi</a></li>
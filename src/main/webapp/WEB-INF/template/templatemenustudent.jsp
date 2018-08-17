<%-- 
    Document   : templatemenustudent
    Created on : Aug 14, 2018, 7:21:53 PM
    Author     : Marina Guzvic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<li  class="${requestScope.page.equalsIgnoreCase("Diplomski rad") ? "custom-active":"non-active"}"><a href="/app/controller?action=diplomskiview">Moj diplomski rad</a></li>


<%-- 
    Document   : templatemenunastavnik
    Created on : Aug 14, 2018, 7:22:14 PM
    Author     : Marina Guzvic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<li class="${requestScope.page.equalsIgnoreCase("diplomskiradsnastavnik") ? "custom-active":"non-active"}"><a href="/app/controller?action=diplomskisearch">Diplomski radovi</a></li>
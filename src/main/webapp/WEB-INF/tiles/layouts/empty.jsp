<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles"    uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	</head>
    <body>  
        <div>
            <tiles:insertAttribute name="body" />
        </div>
    <body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
    <head>
    		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <style>
            div {
                border: 1px solid;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div id="top" style="height:100px;">
            <tiles:insertAttribute name="header" />
        </div>
 
        <div id="body">
            <div id="lnb" style="position:absolute;  height:300px; width: 350px">
                <tiles:insertAttribute name="menu" />
            </div>
             
            <div id="contents" style="margin-left:351px; height:300px;">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
 
        <div id="footer" style="height:100px;">
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>


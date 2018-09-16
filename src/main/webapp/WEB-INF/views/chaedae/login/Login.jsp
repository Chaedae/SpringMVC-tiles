<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
	table, td {
		margin: auto;
		text-align: center;
	}
</style>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
	function fnLogin() {
		$.ajax({      
	        type : "POST",  
	        url  : "/chaedae/login/loginProc.json",
	        data : $('#loginForm').serialize(),
	        success:function(response){   
	            if (response == "SUCCESS") {
	            		location.href = "/chaedae/main/main.cd";
	            } else {
	            		alert(response);
	            }
	        },   
	        error:function(response){  
	            alert(response.responseText);  
	        }  
	    }); 
	}

</script>

<form id="loginForm">
	<table>
		<tr>
			<td>
				<h1>
					Welcome to Chaedae World 
				</h1>
			</td>
		</tr>
		<tr>
			<td>
				<label for="userId">ID</label>	
				<input type="text" id="userId" name="userId" title="ID" />
			</td>
		</tr> 
		<tr>
			<td>
				<label for="pwd">PW</label>	
				<input type="password" id="pwd" name="pwd" title="패스워드" />
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" style="height: 50px; width:100px" onclick="fnLogin();">Login</button>
			</td>
		</tr>
	</table>
</form>
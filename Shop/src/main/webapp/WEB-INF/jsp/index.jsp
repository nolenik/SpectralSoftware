<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" 
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
		crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" 
	crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" 
	crossorigin="anonymous"></script>
<title>Main</title>
</head>
    <body class="bg-light">
    
    		<nav class="navbar navbar-dark bg-dark">
  
    			<img style="width:100px"  class="p-3" src="https://aily.team/img/about_logo.png">
    			<a class="float-right" href="/">Home</a>
    		</nav>
    <div class="row m-3">	
    	<div class="col-md-12">
    		<a class="btn btn-primary " href="/add">Add</a>
    	</div>
    </div>
    <div class="row m-3">
    <div class="col-md-12">
     <table class="table table-striped table-dark table-bordered ">
     <thead>
     	<th class="text-center" >Name</th>
     	<th class="text-center">Description</th>
     	<th class="text-center"><a href="/sort">Price</a></th>
     	<th class="text-center">Picture</th>
     	<th class="text-center" colspan=2>Change</th>
     </thead>
      <c:forEach var="product" items="${products}">
       <tr>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
        <td><img src="${product.id}"  alt="Picture not found"}></td>
        <td><a href="/edit/${product.id}">Edit</a></td>
        <td><a href="/delete/${product.id}">Delete</a></td>
       </tr>
      </c:forEach>
     </table>
     </div>
     </div>
    </body>
</html>
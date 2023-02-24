<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="page">
		<h3>Liste des Produits</h3>
		
		
		<table border="1"  >
 			<tr>
 			<th style="width:10em">idProduit </th>
		   		<th  style="width:15em">nomProduit</th>
		   		<th style="width:15em">prixProduit</th>
		   		
		   	</tr>
		   	
		   	<c:forEach var="addProduits" items="${ListeProduits}">
   			<tr>
   				<td><c:out value="${addProduits.getNomProduit()}"/></td>
   				<td><c:out value="${addProduits.getPrixProduit()}"/></td>
		
   			<tr>
				
   			</tr>
			</c:forEach>
		</table>

		
		<form action="AddProduitsServlet" method="GET">
		<!-- <input class="button-ajout" type="submit" value="ajouter"></input> -->
		</form>
	</div>
</body>
</html>
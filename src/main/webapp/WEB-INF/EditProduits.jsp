<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="produits" items="${listeProduit}">
		<table>
			<tr>
				<th>Id Produits</th>
				<th>Nom Produits</th>
				<th>Prix Produits</th>
				<th>Supprimer</th>
				<th>Editer</th>
			</tr>


			<tr>
				<th><c:out value="${produits.getIdProduits()}"></c:out></th>
				<th><c:out value="${emp.getNomProduits()}"></c:out></th>
				<th><c:out value="${emp.getPrixProduits()}"></c:out></th>
				<th><a href=""> Supprimer</a></th>
				<th><a href=""> Editer</a></th>

			</tr>
		</table>
	</c:forEach>
</body>
</html>
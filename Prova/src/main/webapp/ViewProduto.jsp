<%@page import="br.ucdb.utils.Produto"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>
	<h1>Lista de Produtos</h1>

	<a href= 'Produto.html' > Novo Cadastro </a> <br> <br>
	<%
		List<Produto> produtos = (List<Produto>) request.getAttribute("prod");

		for (Produto p : produtos) {
			out.print("Descrição: " + p.getDescricao());
			out.print("<br>");
			out.print("Valor: " + p.getValor());
			out.print("<br><br>");
		}

	%>

	

		 
		 
</body>
</html>
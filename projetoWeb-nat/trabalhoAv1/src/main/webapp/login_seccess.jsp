<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Sucesso</title>
</head>
<body>
    <h2>Login Realizado com Sucesso!</h2>
    <p>Bem-vindo, seu email é <%= request.getParameter("email") %>!</p>
    <p><%= (request.getParameter("remember") != null) ? "Você escolheu ser lembrado!" : "Você não escolheu ser lembrado." %></p>
    <a href="index.jsp">Página principal</a>
</body>
</html>

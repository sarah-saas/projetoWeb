<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro Concluído</title>
</head>
<body>
    <h2>Registro Concluído com Sucesso!</h2>
    <p>Obrigado por se registrar, <%= request.getParameter("name") %>!</p>
    <a href="login.jsp">Clique aqui para fazer login</a>
</body>
</html>

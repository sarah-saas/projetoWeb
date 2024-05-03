<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro</title>
     <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<section id="um" class="w3-card-4">

    <div class="w3-container w3-blue">
  		<h2>Cadastro</h2>
	</div><br>
	
    <form class="w3-container" action="register_success.jsp" method="post">
    
    	<label class="w3-text-blue"><b>Nome</b></label>
        <input type="text" class="w3-input" name="name" required><br>
        <label class="w3-text-blue"><b>Email</b></label>
        <input type="email" class="w3-input" name="email" required><br>
        <label class="w3-text-blue"><b>Senha</b></label>      
        <input type="password" class="w3-input" name="password" required><br>
        <input type="submit" class="w3-btn w3-blue" value="Registrar">
    </form>
    
    </section>
    
    <section class="dois">
    	<img src="https://cdn-icons-png.flaticon.com/512/1998/1998783.png">
    </section>
    
    <style>
    	body{
    		display: flex;
    		background-color: #caf0f8;
    	}
    	#um{
    		width:50%;
    		align-text: center;
    		padding:20px;
    		margin: 80px;
    		height: 500px;
    	}
    	.dois{
    		width:50%;
    		padding: 40px;
    		margin-right: 40px;
    	}
    
    </style>
</body>
</html>

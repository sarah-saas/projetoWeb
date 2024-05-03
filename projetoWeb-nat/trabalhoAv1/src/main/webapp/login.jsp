<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
</head>
<body>

	<section id="um" class="w3-card-4">
	
    <div class="w3-container w3-green">
  		<h2>Login</h2>
	</div><br>
    
    <form class="w3-container" action="login_success.jsp" method="post">
        
        <label class="w3-text-green"><b>Email</b></label>
        <input type="email" class="w3-input" name="email" required><br>
        <label class="w3-text-green"><b>Senha</b></label>
        <input type="password" class="w3-input" name="password" required><br>
        <label class="w3-text-green"><b>Lembrar de mim</b></label>
        <input type="checkbox" name="remember"><br><br>
        <input type="submit" class="w3-btn w3-green" value="Login">
    </form>
    
    </section>
    
    <section class="dois">
    	<img src="https://cdn-icons-png.flaticon.com/512/9788/9788644.png">
    </section>
    
    <style>
    	body{
    		display: flex;
    		background-color: #f0ead2;
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="trabalhoAv1.TenorAPI" %> <!-- Atualize o import para a nova classe API -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>GIFs do Tenor</title>
</head>
<body>
    <h1>GIFs do Tenor</h1>
    <div id="gifContainer"></div>

    <script>
        // Chave de API do Tenor
        const apiKey = 'AIzaSyB-Owztw2M8nPOGxmv_HMYDLY6gTrpY35I'; // Substitua com sua chave real da API

        // Recupera a escolha do animal da sessão
        const query = '<%=session.getAttribute("penguim")%>';

        // Enviar uma solicitação HTTP GET para a API do Tenor
        fetch(`https://g.tenor.com/v1/search?q=${query}&key=${apiKey}&limit=10`)
            .then(response => response.json()) // Converter a resposta em JSON
            .then(data => {
                // Processar os dados recebidos da API
                const gifContainer = document.getElementById('gifContainer');
                data.results.forEach(gif => {
                    const img = document.createElement('img');
                    img.src = gif.media[0].gif.url; // Acessa o URL do GIF de acordo com a estrutura do JSON do Tenor
                    gifContainer.appendChild(img);
                });
            })
            .catch(error => console.error('Erro ao buscar dados da API do Tenor:', error));
    </script>

    <h1>Resultados da API do Tenor</h1>
    <ul>
        <% TenorAPI.searchGif((String) session.getAttribute("penguim")); %>
    </ul>
   
</body>
</html>
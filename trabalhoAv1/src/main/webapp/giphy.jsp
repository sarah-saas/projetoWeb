<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="trabalhoAv1.GiphyAPI" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>GIFs do Giphy</title>
</head>
<body>
    <h1>GIFs do Giphy</h1>
    <div id="gifContainer"></div>

    <script>
        // Chave de API do Giphy
        const apiKey = 'AIzaSyB-Owztw2M8nPOGxmv_HMYDLY6gTrpY35I';

        // Termo de pesquisa para os GIFs
        const query = 'penguin'; // Por exemplo, pesquisar por GIFs de pinguim

        // Enviar uma solicitação HTTP GET para a API do Giphy
        fetch(`https://api.giphy.com/v1/gifs/search?q=${query}&api_key=${apiKey}`)
            .then(response => response.json()) // Converter a resposta em JSON
            .then(data => {
                // Processar os dados recebidos da API
                const gifContainer = document.getElementById('gifContainer');
                data.data.forEach(gif => {
                    const img = document.createElement('img');
                    img.src = gif.images.original.url;
                    gifContainer.appendChild(img);
                });
            })
            .catch(error => console.error('Erro ao buscar dados da API do Giphy:', error));
    </script>

    <h1>Resultados da API do Giphy</h1>
    <ul>
        <% GiphyAPI.searchGif("pinguim"); %>
    </ul>
   
</body>
</html>

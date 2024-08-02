<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loja de Jogos</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    @include('components.header')
    
    <div class="container">
        <div class="games-list">
            <div class="game-item">
                <img src="caminho/para/imagem1.jpg" alt="Jogo 1">
                <h3>Jogo 1</h3>
                <p>Descrição do Jogo 1</p>
                <a href="#" class="btn">Comprar</a>
            </div>
            <div class="game-item">
                <img src="caminho/para/imagem2.jpg" alt="Jogo 2">
                <h3>Jogo 2</h3>
                <p>Descrição do Jogo 2</p>
                <a href="#" class="btn">Comprar</a>
            </div>
            <!-- Mais itens de jogo -->
        </div>
    </div>
    
    @include('components.footer')
</body>
</html>

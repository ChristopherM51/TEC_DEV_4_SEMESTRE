@extends('layouts.master')
<body>
    @include('components.header')
    @include('components.nav')
    
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

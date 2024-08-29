// URL da API
const apiUrl = 'http://localhost:3000/livros';

document.addEventListener('DOMContentLoaded', () => {
    const listaLivros = document.getElementById('listaLivros');
    const adicionarLivroBtn = document.getElementById('adicionarLivro');

    // Função para carregar os livros
    const carregarLivros = async () => {
        try {
            const response = await fetch(apiUrl);
            const livros = await response.json();
            listaLivros.innerHTML = ''; // Limpa a tabela antes de adicionar novos livros

            livros.forEach(livro => {
                const linha = document.createElement('tr');

                linha.innerHTML = `
                    <td>${livro._id}</td>
                    <td>${livro.titulo}</td>
                    <td>${livro.autor}</td>
                    <td>${livro.ano}</td>
                    <td>${livro.genero}</td>
                    <td>
                        <button class="editar" data-id="${livro._id}">Editar</button>
                        <button class="excluir" data-id="${livro._id}">Excluir</button>
                    </td>
                `;

                listaLivros.appendChild(linha);
            });
        } catch (error) {
            console.error('Erro ao carregar os livros:', error);
        }
    };

    // Função para excluir um livro
    const excluirLivro = async (id) => {
        try {
            const response = await fetch(`${apiUrl}/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                carregarLivros(); // Atualiza a lista de livros
            } else {
                console.error('Erro ao excluir o livro');
            }
        } catch (error) {
            console.error('Erro de rede:', error);
        }
    };

    // Função para redirecionar para a página de adicionar livro
    adicionarLivroBtn.addEventListener('click', () => {
        window.location.href = 'add.html';
    });

    // Adiciona eventos de clique aos botões de editar e excluir
    listaLivros.addEventListener('click', (event) => {
        const target = event.target;

        if (target.classList.contains('editar')) {
            const id = target.getAttribute('data-id');
            window.location.href = `edit.html?id=${id}`;
        } else if (target.classList.contains('excluir')) {
            const id = target.getAttribute('data-id');
            if (confirm('Você tem certeza que deseja excluir este livro?')) {
                excluirLivro(id);
            }
        }
    });

    // Carrega os livros ao carregar a página
    carregarLivros();
});

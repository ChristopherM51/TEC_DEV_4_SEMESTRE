// URL da API
const apiUrl = 'http://localhost:3000/livros';

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('formEditLivro');
    const botaoVoltar = document.getElementById('voltarParaLista');

    // Função para carregar os dados do livro
    async function carregarLivro(id) {
        try {
            const response = await fetch(`${apiUrl}/${id}`);
            const livro = await response.json();

            document.getElementById('livroId').value = livro._id;
            document.getElementById('titulo').value = livro.titulo;
            document.getElementById('autor').value = livro.autor;
            document.getElementById('ano').value = livro.ano;
            document.getElementById('genero').value = livro.genero;
        } catch (error) {
            console.error('Erro ao carregar o livro:', error);
        }
    }

    // Adiciona a função para atualizar o livro ao enviar o formulário
    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const id = document.getElementById('livroId').value;
        const titulo = document.getElementById('titulo').value;
        const autor = document.getElementById('autor').value;
        const ano = document.getElementById('ano').value;
        const genero = document.getElementById('genero').value;

        try {
            const response = await fetch(`${apiUrl}/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ titulo, autor, ano, genero })
            });

            if (response.ok) {
                window.location.href = 'index.html'; // Redireciona de volta para a lista de livros
            } else {
                console.error('Erro ao atualizar o livro');
            }
        } catch (error) {
            console.error('Erro de rede:', error);
        }
    });

    // Adiciona a função para voltar para a lista de livros
    botaoVoltar.addEventListener('click', () => {
        window.location.href = 'index.html';
    });

    // Obtém o ID do livro da URL e carrega os dados
    const urlParams = new URLSearchParams(window.location.search);
    const livroId = urlParams.get('id');
    if (livroId) {
        carregarLivro(livroId);
    }
});
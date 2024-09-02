const apiUrl = 'http://localhost:3000/livros';

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('formLivros');
    const botaoVoltar = document.getElementById('voltarParaLista');

    // Adiciona um novo livro ao enviar o formulário
    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const titulo = document.getElementById('titulo').value;
        const autor = document.getElementById('autor').value;
        const ano = document.getElementById('ano').value;
        const genero = document.getElementById('genero').value;

        try {
            const response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ titulo, autor, ano, genero })
            });

            if (response.ok) {
                // Limpa o formulário
                form.reset();
                // Redireciona de volta para a lista de livros
                window.location.href = 'index.html';
            } else {
                console.error('Erro ao adicionar o livro');
            }
        } catch (error) {
            console.error('Erro de rede:', error);
        }
    });

    // Adiciona a função para voltar para a página de lista de livros
    botaoVoltar.addEventListener('click', () => {
        window.location.href = 'index.html';
    });
});

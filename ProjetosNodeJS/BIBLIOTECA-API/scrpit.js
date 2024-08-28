document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('book-form');
    const bookList = document.getElementById('book-list');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const title = document.getElementById('title').value;
        const author = document.getElementById('author').value;
        const year = document.getElementById('year').value;

        try {
            const response = await fetch('/api/books', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ title, author, year })
            });

            if (response.ok) {
                // Clear the form
                form.reset();
                // Reload the book list
                loadBooks();
            } else {
                console.error('Erro ao adicionar o livro');
            }
        } catch (error) {
            console.error('Erro de rede:', error);
        }
    });

    const loadBooks = async () => {
        try {
            const response = await fetch('/api/books');
            const books = await response.json();
            bookList.innerHTML = '';

            books.forEach(book => {
                const li = document.createElement('li');
                li.textContent = `${book.title} - ${book.author} (${book.year})`;
                bookList.appendChild(li);
            });
        } catch (error) {
            console.error('Erro ao carregar os livros:', error);
        }
    };

    // Load books on page load
    loadBooks();
});

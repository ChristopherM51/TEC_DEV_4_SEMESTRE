// src/components/EditBook.js
import React, { useState, useEffect } from 'react';
import { useParams, useHistory } from 'react-router-dom';

function EditBook() {
  const { id } = useParams();
  const [livro, setLivro] = useState(null);
  const history = useHistory();

  useEffect(() => {
    async function fetchLivro() {
      const response = await fetch(`http://localhost:3000/livros/${id}`);
      const data = await response.json();
      setLivro(data);
    }
    fetchLivro();
  }, [id]);

  const handleChange = (e) => {
    setLivro({ ...livro, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await fetch(`http://localhost:3000/livros/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(livro),
    });
    history.push('/');
  };

  if (!livro) return <p>Loading...</p>;

  return (
    <main>
      <h1>Editar Livro</h1>
      <form id="formEditLivro" onSubmit={handleSubmit}>
        <input type="hidden" name="id" value={livro._id} />
        <label htmlFor="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value={livro.titulo} onChange={handleChange} required />
        <label htmlFor="autor">Autor:</label>
        <input type="text" id="autor" name="autor" value={livro.autor} onChange={handleChange} required />
        <label htmlFor="ano">Ano de Publicação:</label>
        <input type="number" id="ano" name="ano" value={livro.ano} onChange={handleChange} required />
        <label htmlFor="genero">Gênero:</label>
        <input type="text" id="genero" name="genero" value={livro.genero} onChange={handleChange} required />
        <button type="submit">Salvar Alterações</button>
      </form>
      <button id="voltarParaLista" onClick={() => history.push('/')}>Voltar para a Lista de Livros</button>
    </main>
  );
}

export default EditBook;

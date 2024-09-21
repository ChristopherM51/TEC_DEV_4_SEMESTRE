'use client';

import { useState, useEffect } from 'react';
import { useRouter } from 'next/navigation';

export default function TasksPage() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState('');
  const [editTaskId, setEditTaskId] = useState(null);
  const [editTitle, setEditTitle] = useState('');
  const [loading, setLoading] = useState(false);
  const router = useRouter();

  useEffect(() => {
    const fetchTasks = async () => {
      setLoading(true);
      const token = localStorage.getItem('token');
      if (!token) {
        router.push('/login');
        return;
      }

      try {
        const response = await fetch('/api/tasks', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });

        if (response.ok) {
          const data = await response.json();
          setTasks(data.data);
        } else {
          router.push('/login');
        }
      } catch (error) {
        console.error('Falha ao buscar tarefas:', error.message);
        router.push('/login');
      } finally {
        setLoading(false);
      }
    };

    fetchTasks();
  }, [router]);

  const addTask = async () => {
    const token = localStorage.getItem('token');
    const response = await fetch('/api/tasks', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({ title: newTask }),
    });

    if (response.ok) {
      const data = await response.json();
      setTasks([...tasks, data.data]);
      setNewTask('');
    } else {
      console.error('Falha ao adicionar tarefa');
    }
  };

  const deleteTask = async (id) => {
    const token = localStorage.getItem('token');
    await fetch(`/api/tasks`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({ id }),
    });
    setTasks(tasks.filter((task) => task._id !== id));
  };

  const startEditTask = (task) => {
    setEditTaskId(task._id);
    setEditTitle(task.title);
  };

  const updateTask = async () => {
    const token = localStorage.getItem('token');
    const response = await fetch(`/api/tasks`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({ id: editTaskId, title: editTitle }),
    });

    if (response.ok) {
      const data = await response.json();
      setTasks(
        tasks.map((task) => (task._id === data.data._id ? data.data : task))
      );
      setEditTaskId(null);
      setEditTitle('');
    } else {
      console.error('Falha ao atualizar tarefa');
    }
  };

  return (
    <div>
      <h1>To-Do List</h1>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <>
          <input
            type="text"
            placeholder="Nova tarefa"
            value={newTask}
            onChange={(e) => setNewTask(e.target.value)}
          />
          <button onClick={addTask}>Adicionar Tarefa</button>
          <ul>
            {tasks.map((task) => (
              <li key={task._id}>
                {editTaskId === task._id ? (
                  <>
                    <input
                      type="text"
                      value={editTitle}
                      onChange={(e) => setEditTitle(e.target.value)}
                    />
                    <button onClick={updateTask}>Salvar</button>
                  </>
                ) : (
                  <>
                    {task.title}
                    <button onClick={() => deleteTask(task._id)}>Excluir</button>
                    <button onClick={() => startEditTask(task)}>Editar</button>
                  </>
                )}
              </li>
            ))}
          </ul>
        </>
      )}
    </div>
  );
}

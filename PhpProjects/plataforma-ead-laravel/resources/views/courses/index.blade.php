@extends('layouts.app')


@section('content')


<div class="container">
    <h1 class="my-4">Cursos</h1>


    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif


    <a class="btn btn-success mb-2" href="{{ route('courses.create') }}"> Criar Novo Cursos</a>


    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th width="280px">Ação</th>
        </tr>
        @foreach ($courses as $course)
        <tr>
            <td>{{ $loop->iteration }}</td>
            <td>{{ $course->name }}</td>
            <td>{{ $course->category}}</td>
            <td>{{ $course->duration}}</td>
            <td>{{ $course->price }}</td>
            <td>
                <form action="{{ route('courses.destroy', $course->id) }}" method="POST">
                    {{-- <a class="btn btn-info" href="{{ route('courses.show', $course->id) }}">Mostrar</a> --}}
                    <a class="btn btn-primary" href="{{ route('courses.edit', $course->id) }}">Editar</a>


                    @csrf
                    @method('DELETE')
                    <button type="submit" class="btn btn-danger">Deletar</button>
                </form>
            </td>
        </tr>
        @endforeach
    </table>
</div>
@endsection
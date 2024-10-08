@extends('layouts.app')


@section('content')
    <div class="container">
        <h1 class="my-4">Editar Curso</h1>


        @if ($errors->any())
            <div class="alert alert-danger">
                <strong>Oops!</strong> Houve alguns problemas com sua entrada.<br><br>
                <ul>
                    @foreach ($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            </div>
        @endif


        <form action="{{ route('courses.update', $course->id) }}" method="POST">
            @csrf
            @method('PUT')


            <div class="form-group">
                <label for="name">Nome:</label>
                <input type="text" name="name" class="form-control" placeholder="Name">
            </div>


            <div class="form-group">
                <label for="description">Descrição:</label>
                <textarea name="description" class="form-control" placeholder="Description"></textarea>
            </div>


            <div class="form-group">
                <label for="category">Categoria:</label>
                <input type="text" name="category" class="form-control" placeholder="Category">
            </div>


            <div class="form-group">
                <label for="duration">Duração:</label>
                <input type="number" name="duration" class="form-control" placeholder="duration">
            </div>


            <div class="form-group">
                <label for="price">Preço:</label>
                <input type="text" name="price" class="form-control" placeholder="Preço">
            </div>

            <div class="form-group">
                <label for="img">Imagem:</label>
                <input type="image" name="img" class="form-control" placeholder="Imagem">
            </div>


            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
@endsection
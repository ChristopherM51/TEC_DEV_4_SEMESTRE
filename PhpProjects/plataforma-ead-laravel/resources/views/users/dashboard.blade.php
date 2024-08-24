@extends('layouts.app')

@section('content')
    <div class="container my-5">
        <h1 class="text-center mb-4">Dashboard de Cursos</h1>

        <form method="GET" action="{{ route('dashboard') }}" class="d-flex justify-content-center mb-4">
            <input type="text" name="search" placeholder="Pesquisar cursos..." value="{{ request('search') }}" class="form-control me-2" style="max-width: 300px;">
            <button type="submit" class="btn btn-outline-primary me-2">Pesquisar</button>
            
            <!-- Verifique se o usuário é um administrador -->
            @if (Auth::user() && Auth::user()->user_type === 'administrator')
                <a href="{{ route('courses.create') }}" class="btn btn-primary">Novo Curso</a>
            @endif
        </form>

        <div class="row">
            @foreach ($courses as $course)
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <!-- Utilize o caminho para a imagem do curso -->
                        <img src="{{ asset('assets/img/' . $course->img_path) }}" class="card-img-top" alt="{{ $course->name }}">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title">{{ $course->name }}</h5>
                            <p class="card-text">{{ $course->description }}</p>
                            <p class="card-text fw-bold">Preço: R$ {{ $course->price }}</p>
                            <a href="{{ route('courses.show', $course->id) }}" class="btn btn-primary mt-auto">Ver Curso</a>
                        </div>
                    </div>
                </div>
            @endforeach
        </div>
    </div>
@endsection

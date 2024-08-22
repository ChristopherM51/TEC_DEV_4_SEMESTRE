@extends('layouts.app')


@section('content')
    <h1>Dashboard de Cursos</h1>


    <form method="GET" action="{{ route('dashboard') }}">
        <input type="text" name="search" placeholder="Pesquisar cursos..." value="{{ request('search') }}">
        <button type="submit">Pesquisar</button>
    </form>


    <div class="row">
        @foreach ($courses as $course)
            <div class="col-md-4">
                <div class="card">
                    <img src="assets/img/img0.png" class="card-img-top" alt="{{ $course->name }}">
                    <div class="card-body">
                        <h5 class="card-title">{{ $course->name }}</h5>
                        <p class="card-text">{{ $course->description }}</p>
                        <p class="card-text">Preço: R$ {{ $course->price }}</p>
                        <a href="{{ route('courses.show', $course->id) }}" class="btn btn-primary">Ver Curso</a>
                    </div>
                </div>
            </div>
        @endforeach
    </div>
@endsection

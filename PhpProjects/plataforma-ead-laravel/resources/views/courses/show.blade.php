@extends('layouts.app')


@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="/assets/img/img0.png" class="img-fluid" alt="{{ $course->name }}">
            </div>
            <div class="col-md-6">
                <h2>{{ $course->name }}</h2>
                <p>{{ $course->category }}</p>
                <p>{{ $course->durarion }}</p>
                <p>Preço: R$ {{ $course->price }}</p>
			
                <form method="POST" action="{{ route('carrinho.add', $course->id) }}">
                    @csrf
                    <label for="duration">Selecione a duração</label>
                    <input type="number" class="" name="duration" id="">
                    <button type="submit" class="btn btn-primary">Adicionar ao Carrinho</button>
                </form>
            </div>
        </div>
    </div>
@endsection


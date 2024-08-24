@extends('layouts.app')


@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="/assets/img/img.png" class="img-fluid" alt="{{ $course->name }}">
            </div>
            <div class="col-md-6">
                <h2>{{ $course->name }}</h2>
                <p>{{ $course->category }}</p>
                <p>{{ $course->durarion }}</p>
                <p>Preço: R$ {{ $course->price }}</p>
			
                <form method="POST" action="{{ route('cart.add', $course->id) }}">
                    @csrf
                    <button type="submit" class="btn btn-primary">Finalizar compra</button>
                </form>
            </div>
        </div>
    </div>
@endsection


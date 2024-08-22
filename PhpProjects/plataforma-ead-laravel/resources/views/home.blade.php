@extends('layouts.app')


@section('content')
<div class="container">
    <div id="courseCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            @foreach ($courses as $index => $course)
                <div class="carousel-item {{ $index == 0 ? 'active' : '' }}">
                    <img src="assets/img/img{{$index}}.png" class="d-block" alt="{{ $course->name }}" style="width: 500px">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>{{ $course->name }}</h5>
                        <p>{{ $course->description }}</p>
                        <p>Preço: R$ {{ $course->price }}</p>
                    </div>
                </div>
            @endforeach
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#courseCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#courseCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
@endsection

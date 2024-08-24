@extends('layouts.app')

@section('content')
{{-- formulario --}}
<div class="container">
    <h1>Registrar-se</h1>
    <form method="POST" action="{{ route('users.registration') }}">
        @csrf


        <div class="form-group">
            <label for="name">Nome</label>
            <input type="text" name="name" class="form-control @error('name') is-invalid @enderror" value="{{old('name')}}" required>
            
            @error('name')
                <div class="invalid-feedback">{{$message}}</div>
            @enderror
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control @error('email') is-invalid @enderror" value="{{old('email')}}" required>
            @error('email')
            <div class="invalid-feedback">{{$message}}</div>
        @enderror
        </div>

        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="cpf" name="cpf" class="form-control @error('cpf') is-invalid @enderror" value="{{old('cpf')}}" required>
            @error('cpf')
            <div class="invalid-feedback">{{$message}}</div>
        @enderror
        </div>

        <div class="form-group">
            <label for="phone_number">Telefone:</label>
            <input type="phone_number" name="phone_number" class="form-control @error('phone_number') is-invalid @enderror" value="{{old('phone_number')}}" required>
            @error('phone_number')
            <div class="invalid-feedback">{{$message}}</div>
        @enderror
        </div>
        
        <div class="form-group">
            <label for="adress">Endereço:</label>
            <input type="adress" name="adress" class="form-control @error('adress') is-invalid @enderror" value="{{old('adress')}}" required>
            @error('adress')
            <div class="invalid-feedback">{{$message}}</div>
        @enderror
        </div>

        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" name="password" class="form-control @error('password') is-invalid @enderror" required>
            @error('password')
            <div class="invalid-feedback">{{$message}}</div>
        @enderror
        </div>
        
        <div class="form-group">
            <label for="password_confirmation">Confirme a Senha</label>
            <input type="password" name="password_confirmation" class="form-control" required>
            @error('password_confirmation')
            <div class="invalid-feedback">{{$message}}</div>
        @enderror
        </div>
        
        <br>

        <button type="submit" class="btn btn-primary">Registrar-se</button>
    </form>
</div>

@endsection
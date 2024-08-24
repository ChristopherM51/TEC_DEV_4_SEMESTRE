@if (Auth::check())
    <div class="container my-5">
        <div class="text-center mb-4">
            <h3>Olá, {{ Auth::user()->name }}</h3>
            <h4 class="text-muted">{{ Auth::user()->user_type }}</h4>
        </div>
        
        <div class="d-flex justify-content-center mb-4">
            <form action="/logout" method="post">
                @csrf
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>
        </div>

        @if (Auth::user()->isAdmin())
            <div class="text-center">
                <a href="/cursos" class="btn btn-primary">
                    <h3 class="m-0">Dashboard Cursos - Adm</h3>
                </a>
            </div>
        @endif
    </div>
@else
    <div class="container my-5">
        <div class="text-center">
            <ul class="list-inline">
                <li class="list-inline-item me-3">
                    <a href="/login" class="btn btn-outline-primary">Login</a>
                </li>
                <li class="list-inline-item">
                    <a href="/registration" class="btn btn-outline-secondary">Registrar-se</a>
                </li>
            </ul>
        </div>
    </div>
@endif

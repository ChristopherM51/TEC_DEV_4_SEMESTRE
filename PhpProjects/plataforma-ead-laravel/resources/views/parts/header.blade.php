@if (Auth::check())
    <div>
        <h3>Olá, {{ Auth::user()->name }}</h3>
        <h4>{{ Auth::user()->user_type }}</h4>
    </div>
    <form action="/logout" method="post">
        @csrf
        <button type="submit">Logout</button>
    </form>
    @if (@auth::user()->isAdmin())
        <div>
            <a href="/cursos">
                <h3>Dashboard Cursos - Adm</h3>
            </a>
        </div>
    @endif
@else
    <div>
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/registration">Registrar-se</a></li>
        </ul>
    </div>
@endif
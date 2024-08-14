<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use SebastianBergmann\CodeCoverage\Report\Html\Dashboard;

// Rota para exibir a homePage
Route::get('/', function () { return view('home');});

// Rota para exibir o formulário de registro
Route::get('/registro', [UserController::class, 'showRegistroForm'])->name('usuarios.registro');

// Rota para processar o registro
Route::post('/registro', [UserController::class, 'Registro'])->name('usuarios.registro');

// Rota para exibir o formulário de login
Route::get('/login', [UserController::class, 'showLoginForm'])->name('usuarios.login');

// Rota para processar o login
Route::post('/login', [UserController::class, 'Login'])->name('usuarios.login');

// Rota para pagina interna
Route::get('/dashboard', function (){
    return view('usuarios.dashboard');
})->middleware(['auth'])->name('usuarios.dashboard');

// Rota para logout
Route::post('/logout', [UserController::class, 'logout']);

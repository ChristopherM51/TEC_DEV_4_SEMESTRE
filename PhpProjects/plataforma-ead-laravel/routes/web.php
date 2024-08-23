<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use SebastianBergmann\CodeCoverage\Report\Html\Dashboard;
use App\Http\Controllers\CourseController;
use App\Http\Middleware\CoursesMiddleware;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\DashboardController;

// Página inicial com carrocel de courses
Route::get('/', [HomeController::class, 'index'])->name('home');

// Rota para exibir o formulário de registration
Route::get('/registration', [UserController::class, 'showRegistrationForm'])->name('users.registration');

// Rota para processar o registration
Route::post('/registration', [UserController::class, 'registration'])->name('users.registration');

// Rota para exibir o formulário de login
Route::get('/login', [UserController::class, 'showLoginForm'])->name('users.login');

// Rota para processar o login
Route::post('/login', [UserController::class, 'Login'])->name('users.login');

// Rota para pagina interna
Route::get('/dashboard', [DashboardController::class, 'index'])
->middleware(['auth'])->name('dashboard');

// Rota para logout
Route::post('/logout', [UserController::class, 'logout']);

// Rota para courses
Route::resource('/courses', CourseController::class)
->middleware(CoursesMiddleware::class)->except('show');

// Rota para exibir um course específico
Route::get('/courses/{course}', [CourseController::class,'show'])
->middleware('auth')->name('courses.show');

// Rota para adicionar course no cart
Route::post('cart/add/{course}',[CourseController::class, 'add'])
->middleware('auth')->name('cart.add');
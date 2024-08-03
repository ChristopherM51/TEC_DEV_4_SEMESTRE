<?php

use App\Http\Controllers\ProdutoController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('home');
});
Route::get('/Produtos', [ProdutoController::class, 'index']);

Route::get('Contato', function () {
    return view('Contato');
});
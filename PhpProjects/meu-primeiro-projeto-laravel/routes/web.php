<?php

use Illuminate\Support\Facades\Route;

Route::get('Home', function () {
    return view('Home');
});
Route::get('Produtos', function () {
    return view('Produtos');
});
Route::get('Contato', function () {
    return view('Contato');
});
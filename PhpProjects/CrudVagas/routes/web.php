<?php

use App\Http\Controllers\Vagacontroller;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::resource('vagas', VagaController::class);

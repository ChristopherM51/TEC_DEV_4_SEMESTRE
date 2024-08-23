<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Produto;

class HomeController extends Controller
{
    public function index()

    // pegue os 5 produtos mais recentes
    {
        $produtos = Produto::take(5)->get();
        return view('home', compact('produtos'));
    }
}
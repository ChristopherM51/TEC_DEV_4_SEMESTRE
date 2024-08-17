<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Produto;
use Illuminate\Support\Facades\Auth;

class CarrinhoController extends Controller
{
    public function add(Request $request, Produto $produto){
        $dados = $request -> validate([
            'quantidade' => 'required|numeric|min:1' 
        ]);
        Produto::create(['id_produto' => $produto->id,
        'id_user' => Auth::id(),
        'quantidade'=> $request->quantidade]);

        return redirect()->back()->with('success', 'item adicionado');
    }
}

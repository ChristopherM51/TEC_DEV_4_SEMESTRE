<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Course;
use Illuminate\Support\Facades\Auth;

class CartController extends Controller
{
    public function add(Request $request, Course $course){
        $dados = $request -> validate([
            'price' => 'required|numeric|min:1' 
        ]);
        Course::create(['id_course' => $course->id,
        'id_user' => Auth::id(),
        'price'=> $request->price]);
        //
        return redirect()->back()->with('success', 'item adicionado');
    }
}


<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Auth;

class UserController extends Controller

{
    // Exibir o formulário de login
    public function showLoginForm()
    {
        return view('users.login');
    }


    // Processar o login do usuário
    public function login(Request $request)
    {
        $credentials = $request->validate([
            'email' => ['required', 'email'],
            'password' => ['required'],
        ]);


        if (Auth::guard('web')->attempt($credentials)) {
            $request->session()->regenerate();
            return redirect()->intended('/dashboard');
        }


        return back()->withErrors([
            'email' => 'As credenciais não correspondem aos nossos ations.',
        ])->onlyInput('email');
    }


    // Exibir o formulário de ation
    public function showRegistrationForm()
    {
        return view('users.registration');
    }


    // Processar o ation de um novo usuário
    public function registration(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:8|confirmed',
        ]);

    
        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);
        return redirect('/');
}

    // Realizar o logout do usuário
    public function logout(Request $request)
    {
        Auth::logout();


        $request->session()->regenerateToken();
        $request->session()->invalidate();


        return redirect('/');
    }
}
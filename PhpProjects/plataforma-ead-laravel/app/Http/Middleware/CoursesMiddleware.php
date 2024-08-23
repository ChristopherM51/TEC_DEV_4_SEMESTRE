<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;
use Illuminate\Support\Facades\Auth;

class CoursesMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Closure(\Illuminate\Http\Request): (\Symfony\Component\HttpFoundation\Response)  $next
     */
    public function handle(Request $request, Closure $next): Response
    {
        if(Auth::check() && Auth::user()->user_type === 'administrator'){
        return $next($request);
        } else{
        // Se não for uma empresa, redirecionar com uma mensagem de erro
        return redirect()->route('/')->
        withErrors('access', 'Acesso restrito aos administradores.');
        }
    }
}
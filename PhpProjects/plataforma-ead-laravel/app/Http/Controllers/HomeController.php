<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Course;

class HomeController extends Controller
{
    public function index()

    // pegue os 5 courses mais recentes
    {
        $courses = Course::all();
        return view('home', compact('courses'));
    }
}

<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Course;

class DashboardController extends Controller
{
    public function index(Request $request)
    {
        $search = $request->input('search');
        $courses = Course::when($search, function ($query, $search) {
            return $query->where('name', 'like', "%{$search}%")
                         ->orWhere('description', 'like', "%{$search}%")
                         ->orWhere('category', 'like', "%{$search}%");
        })->get();


        return view('users.dashboard', compact('courses'));
    }
}

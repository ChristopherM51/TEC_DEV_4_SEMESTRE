<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Models\Course;
use Illuminate\Http\Request;

class CourseController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $courses = Course::all();
        return view('courses.index',compact('courses'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('courses.create');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'name'=> 'required',
            'description'=>'required',
            'category' =>'required',
            'duration'=>'required',
            'price'=>'required|numeric'
        ]);
        Course::create($request->all());
        return redirect()->route('courses.index')
        ->with('success','Curso cadastrado com sucesso');
    }

    // /**
    //  * Display the specified resource.
    //  */
    // public function show(Course $course)
    // {
    //     //
    // }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Course $course)
    {
        return view ('courses.edit', compact('course'));
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Course $course)
    {
        $request->validate([
            'name'=> 'required',
            'description'=>'required',
            'category' =>'required',
            'duration'=>'required',
            'price'=>'required|numeric'
        ]);
        $course->update($request->all());
        return redirect()->route('courses.index')
        ->with('success','Curso atualizado com sucesso');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Course $course)
    {
        $course->delete();
        return redirect()->route('courses.index')
        ->with('success','Curso excluído com sucesso');
    }

    // Mostrar os courses
    public function show (Course $course){
        return view('courses.show', compact('course') );
        }
}
import { updateTask, deleteTask } from "@/controllers/Taskcontroller";
import { NextResponse } from "next/server";


export async function PUT(request, { params }) {
    try {
        const data = await request.json();
        const task = await updateTask(params.id, data);
        if (!task) {
            return NextResponse.json({ success: false }, { status: 400 });
        }
        return NextResponse.json({ success: true, data: task });
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}


export async function DELETE(req,{params}) {
    try {
        const task = await deleteTask(params.id);
        if (!task) {
            return NextResponse.json({ success: false }, { status: 404 });
        }
        return NextResponse.json({success: true, message: "Deletado com Sucesso"});
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}

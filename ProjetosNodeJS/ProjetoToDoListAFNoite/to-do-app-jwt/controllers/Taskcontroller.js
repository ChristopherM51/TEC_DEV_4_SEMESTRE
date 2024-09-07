import Tasl from "mongoose";
import connectMongo from '@/utils/dbConnect';
import Task from "@/models/Task";

// CRUD
export const getTask = async() => {
    await connectMongo();
    return await Task.find();
}

export const createTask = async (data) => {
    await connectMongo();
    return await Task.create(data);
}

export const updateTask = async (id,data) => {
    await connectMongo();
    return await Task.findByIdAndUpdate(id,data,{
        new:true,
        runValidators: true
    });
}

export const deleteTask = async(id) => {
    await connectMongo();
    return await Task.deleteOne({_id:id});
}
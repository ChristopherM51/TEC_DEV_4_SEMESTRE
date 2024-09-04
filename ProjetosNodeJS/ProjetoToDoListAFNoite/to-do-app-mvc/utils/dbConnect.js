import mongoose from "mongoose";

const DATABSE_URL = process.env.DATABSE_URL;

const connectMongo = async () => {
    mongoose.connect()
    .then(()=>console.log("Conectado com MongoDB"))
    .catch(err=>console.error(err));
}

export default connectMongo;
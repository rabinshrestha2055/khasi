const express=require("express");
const bodyparser=require('body-parser');
const morgan=require('morgan');
const productApi=require('./api/routes/products');
const orderApi=require('./api/routes/order');
const mongoose=require('mongoose');
const app=express();
mongoose.connect('mongodb://localhost:27017/Product', {useNewUrlParser: true, useCreateIndex: true,useUnifiedTopology:true}); //database connection
app.use(morgan('dev'));
app.use(bodyparser.urlencoded({extended:false}));
app.use(bodyparser.json());
app.use((req,res,next)=>{
    res.header('Access-Control-Allow-Origin','*');
    res.header(
        'Access-Control-Allow-Headers',
        'Origin','X-Requested-With','Content-Type','Accept','Autorization'
        );
        if(req.method=='Options'){
            res.header('Aceess-Control-Allow-Methods','PUT,Post,Patch,Delete, Get');
             return res.status(200).json({});
        }
        next();
})
app.use('/products',productApi);
app.use('/orders',orderApi);
app.use((req,res,next)=>{
    const error=new Error('Not Found!');
    error.status=404;
    next(error);
});
app.use((error,req,res,next)=>{
   res.status(error.status||500);
   res.json({
       error:{
           message:error.message,
       }
   })
});
app.listen(8080,()=>console.log("Server running on port:8080"));
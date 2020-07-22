const express=require('express');
const router=express.Router();
const  Product=require('../models/product');
const mongoose=require('mongoose');
router.get('/',function(req,res,next){
    Product.find()
    
    .select('name price _id')
    .exec()
    .then(doc=>{
        console.log(doc);
        const response={
            count:doc.length,
            product:doc.map(docs=>{
                return{
                    name:docs.name,
                    price:docs.price,
                    _id:docs._id,
                    request:{
                        type:"GET",
                        url:"http://localhost:8080/products/"+docs._id
                    }
                }
            }) 
        }
       
        res.status(200).json(response);
       
    })
    .catch(err=>{
        console.log(err);
        res.status(500).json({error:err});
    });
    
});
router.post('/',function(req,res,next){
    const product=new Product({
        _id:new mongoose.Types.ObjectId(),
        name:req.body.name,
        price:req.body.price,
    });
    product.save()
    .then(result=>{
        console.log(result);
        res.status(201).json({
            message:"Created product sucessfully",
            createdProduct:{
                name:result.name,
                price:result.price,
                _id:result._id,
                request:{
                    type:"GET",
                    url:"http://localhost:8080/products/"+result._id

                }
            }
        });
    }) .catch(err=>{
        console.log(err);
        res.status(500).json({error:err});
    });
    
  
});
router.get('/:productId',function(req,res,next){
    const id=req.params.productId;
     Product.findById(id,(err,data)=>{
         console.log(data);
         data.save(err=>{
             if(err) throw err;
             res.json(data);
         })
     });
     
     
});
router.patch('/:productId',function(req,res,next){  
        const id=req.params.productId;
        var name=req.body.name;
        var price=req.body.price;
        Product.findById(id,(err,data)=>{
        data.name=name?name:data.name;
        data.price=price?price:data.price;
        data.save(err=>{
           if (err) throw err;
           res.send("Data update successfully!!")
        });
        });
});
router.delete('/:productId',function(req,res,next){
    const id=req.params.productId;
    Product.findByIdAndRemove(id,(err)=>{
        
            if (err) throw err;
            res.status(200).json({
                message:"Successfully Record Deleted"
            })
      
         
    })

});
module.exports=router;
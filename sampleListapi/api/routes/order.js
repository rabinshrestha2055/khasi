const express=require("express");
const router=express.Router();
router.get('/',function(req,res,next){
    res.status(200).json({
        message:'Order were feteched'
    });

});
router.post('/',function(req,res,next){
    const order={
        productId:req.body.productId,
        quantity:req.body.quantity
    }
    res.status(201).json({
        message:'Order was created',
        order:order
    });
});
router.get('/:orderId',function(req,res,next){
    res.status(200).json({
        message:'Order were feteched',
        orderId:req.params.orderId
    });

});
router.delete('/:orderId',function(req,res,next){
    res.status(200).json({
        message:'Order deleted',
        orderId:req.params.orderId
    });

});
module.exports=router;
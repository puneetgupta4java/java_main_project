<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <style>
body {
    font-family: "Lato", sans-serif;
    background: #1E547F;
    color: #fff;
}
</style>
    </head>
<body>

<div class="container">
    <div class="col-sm-offset-2"><h2>Add Product</h2></div><br><br><br>
  <form class="form-horizontal" action="AddProduct" name="addproduct" method="post">
    <div class="form-group">
      <label class="col-sm-2 control-label">Enter Name</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product Name" name="Product_name" required="required">
      </div>
    </div>
        <div class="form-group">
      <label class="col-sm-2 control-label">Enter price</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product price" name="Product_price" required="required">
      </div>
    </div>
        <div class="form-group">
      <label class="col-sm-2 control-label">Enter weight</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product weight(in grams)" name="Product_weight" required="required">
      </div>
    </div>
        <div class="form-group">
      <label class="col-sm-2 control-label">Enter dimensions</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product Dimensions(l*b*h)" name="Product_dimensions" required="required">
      </div>
    </div>
        <div class="form-group">
      <label class="col-sm-2 control-label">Enter description</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product Description" name="Product_desc" required="required">
      </div>
    </div>
         <div class="form-group">
      <label class="col-sm-2 control-label">Enter quantity</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product quantity" name="Product_quantity" required="required">
      </div>
    </div>
     <div class="form-group">
      <label class="col-sm-2 control-label">Enter seller id</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product seller id" name="Product_seller" required="required">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-2 control-label">Enter category id</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product category id" name="Product_category" required="required">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-2 control-label">Enter image path</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Product image path" name="Product_img" required="required">
      </div>
    </div>
       <div class="form-group">
      <div class="col-sm-1 col-sm-offset-2">
        <button type="reset" class="btn btn-default">Reset</button>
      </div>
           <div class="col-sm-2">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    </form>
    </div>
    
    </body>
</html>
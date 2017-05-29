<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Category</title>
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
    <div class="col-sm-offset-2"><h2>Add Category</h2></div><br><br><br>
  <form class="form-horizontal" action="AddCategory" method="get">
    <div class="form-group">
      <label class="col-sm-2 control-label">Enter Name</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Category Name" name="Category_name" required="required">
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
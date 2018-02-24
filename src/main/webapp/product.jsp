<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.sql.*"
	import="java.util.*, edu.ntut.java007.farmerCoop.model.*"%>

<jsp:useBean id="Sproduct" class="edu.ntut.java007.farmerCoop.model.SproductDao" />
<jsp:useBean id="SproductCategory" class="edu.ntut.java007.farmerCoop.model.SproductCategoryDAO" />
<jsp:useBean id="Szip" class="edu.ntut.java007.farmerCoop.model.ZipCodeDAO" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<link href="../style.css" rel="stylesheet" type="text/css" />
<title>農作物管理</title>
</head>

<body class="fix-header">
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                  <h4 class="page-title">農作物管理</h4> </div>
                </div>
                <div class="row">
                        <div class="white-box">
                            <h4 class="box-title">農作物清單</h4>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                              新增農作物
                            </button>
                           
                             <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>相片</th>
                                            <th>農作物名稱</th>
                                            <th>分類</th>
                                            <th>簡介</th>
                                            <th>修改</th>
                                            <th>刪除</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                         <form id ="form1" action="/edu.ntut.java007.farmerCoop.controller/sproduct.do" method="POST">
                                            <td>${edit.productOid}</td>
                                            <td id = "productImgUrl${edit.productOid}"><img id = "photoURL${edit.productOid}" src='${edit.productImgUrl}' width=50></td>
                                            <td id = "productName${edit.productOid}">${edit.productName}</td>
                                            <td id = "productCatId${edit.productOid}" style="width:200px">${edit.productCatId}</td>
                                            <td id = "productInfo${edit.productOid}" style="width:800px">${edit.productInfo}</td>
                                            <td>
                                              <button type = "button" id = "edit${edit.productOid}" type="button" class="btn btn-primary">修改</button>
                                            </td>
                                            <td>
                                              <button id = "delete${edit.productOid}" type="button" class="btn btn-danger">刪除</button>
                                            </td>
                                         </form>
                                        </tr>
                                     </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" style="display: none;" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">新增農作物</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <div class="modal-body">
                                <form action="new.jsp" method="post">
                                  <div class="form-group">
                                    <label for="productName" class="control-label">農作物名稱</label>
                                    <input type="text" class="form-control" id="productName" value="">
                                  </div>
                                  <div class="form-option">
                                      <label for="productCatId" class="control-label">分類</label>
                                      <input type="text" class="form-control" id="" value="">
                                  </div>
                                  <div class="form-group">
                                      <label for="productInfo" class="control-label">簡介</label>
                                      <textarea class="form-control" id="" name="productInfo"></textarea>
                                  </div>
                                  <div class="form-group">
                                      <label for="productImgUrl" class="control-label">相片連結</label>
                                      <input type="text" class="form-control" id="" value="">
                                  </div>
                                  <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
                                    <input type="submit" class="btn btn-primary" value="新增農作物">
                                  </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center">007 &copy; 爆肝體驗營</footer>
        </div>
        <!-- /#page-wrapper -->

     <script>
    $(document).ready(function(){
      $("button").on("click",function(){
        var click_text = $(this).text();
        switch(click_text){
          case "修改":
              var id = $(this).attr("id").split("edit")[1];
              $("#productName"+ id).html('<input type='text' name="productName" id = "input_productName' + id + '"value="' + $("#productName" + id).text() + '"/>"');
              $("#productImgUrl" + id).html('<input type="text" name="productImgUrl" id = "input_productImgUrl' + id + '"value="' + $("#productImgUrl" + id).attr("src") + '" />');
              $("#productInfo" + id).html('<textarea name="productInfo" id = "input_productInfo' + id + '"value="' + $("#productInfo" + id).text() + '" >' + $("#productInfo" + id).text() +'</textarea>');
              $(this).attr("id","storeEdit" + id);
              $(this).html("儲存");
          break;
          case "儲存":
        	  var id = $(this).attr("id").split("storeEdit")[1];
              var productName = $("#input_productName" + id).val();
              var productInfo = $("#input_productInfo" + id).val();
              var productImgUrl = $("#input_productImgUrl" + id).val();
              var id_input = $("<input>").attr("type", "hidden").attr("name", "id").val(id);
              $("#form" + id).append(id_input);
              $("#form" + id).append($("#input_productName" + id));
              $("#form" + id).append($("#input_productImgUrl" + id));
              $("#form" + id).append($("#input_productInfo" + id));
              $("#form" + id).submit();
          break;
          case "刪除":
        	  var id = $(this).attr("id").split("delete")[1];
              var id_input = $("<input>").attr("type", "hidden").attr("name", "id").val(id);
              var name_input = $("<input>").attr("type", "hidden").attr("name", "name").val($("#name" + id).text());
              var photo_input = $("<input>").attr("type", "hidden").attr("name", "photo").val($("#photoURL" + id).attr("src"));
              var description_input = $("<input>").attr("type", "hidden").attr("name", "description").val($("#description" + id).text());
              $("#form" + id).attr("action","delete.jsp");
              $("#form" + id).append(id_input);
              $("#form" + id).append(name_input);
              $("#form" + id).append(photo_input);
              $("#form" + id).append(description_input);
              $("#form" + id).submit();
          break;
        }
      });
    });
    </script> 
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>

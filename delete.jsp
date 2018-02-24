<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="Sproduct" class="edu.ntut.java007.farmerCoop.model.SproductDao" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet"> 
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../style.css" rel="stylesheet" type="text/css" />
<title>農作物管理</title>
</head>

<body class="fix-header">
<form  id="formd" name="formd" method="post" 
       action="/edu.ntut.java007.farmerCoop.controller/ProductDelete.do"  enctype="multipart/form-data" > 
        <!-- Page Content -->
         <div id="page-wrapper">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">${DeleteMsg}</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        
                            <li class="active">刪除農作物</li>
                       
                    </div>
                </div>
                <div class="row">
                  <div class="col-sm-12">
                      <div class="white-box">
                          <h3 class="box-title">${param.pname}</h3>
                          <p>照片：<img src="{pimg}"/></p>
                          <p>分類：${param.pcid}</p>
                          <p>簡介：${param.pinfo}</p>
                          <button class="btn btn-primary" onclick="window.open('product.jsp','_self')">刪除</button>
                        </div>
                      </div>
                </div>
            </div>
        </div>
     </div>
</form>    
</body>

</html>

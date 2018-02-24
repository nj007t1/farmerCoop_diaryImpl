<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.sql.*"
	import="java.util.*, edu.ntut.java007.farmerCoop.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet"> 
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../style.css" rel="stylesheet" type="text/css" />
<jsp:useBean class="edu.ntut.java007.farmerCoop.model.SproductDao" id="caBean" >   
</jsp:useBean>
<title>農作物管理</title>
</head>
        
<body class="fix-header">
<form  id="form1" name="form1" method="post" 
       action="/edu.ntut.java007.farmerCoop.controller/sproduct.do"  enctype="multipart/form-data" >
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">${errorMsg}</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                       <ol class="breadcrumb">
                           <li class="active">新增農作物</li>
                       </ol>
                </div>
                <div class="row">
                      <div class="white-box">
                          <h3 class="box-title"></h3>
                          <p>農作物名稱：${param.productOid}</p>
                          <p>照片：<img src='${param.productImgUrl}'/></p>
                          <p>分類：${param.productCatId}</p>
                          <p>簡介：${param.productInfo}</p>
                          <button class="btn btn-primary" onclick="window.open('product.jsp','_self')">確定</button>
                      </div>
                </div>
            </div>
</form>
</body>
</html> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.store.wholesaleStore.model.Product"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="resources/adminResources/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body class="sb-nav-fixed">
	<!-- Starter Nav ee  -->
	<nav> <jsp:include page="navbar.jsp"></jsp:include> </nav>

	<!-- End Nav ee  -->

	<!-- Start sidebar -->
	<jsp:include page="sidebar.jsp"></jsp:include>
	<!-- End sidebar -->

 <div id="layoutSidenav_content">
  <main>
   <div class="container-fluid px-4">
   <h1 class="mt-4">Add Product</h1>
   <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Add Product</li>
                        </ol>
                        
                         <div id="comment-form">
                         
                         <form:form action="products/addproduct" method="post" modelAttribute="product">
                         <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label for="name">Name<span class="required">*</span></label>
                          <form:input id="productName" name="productName" path="productName" type="text"  class="form-control"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label for="price">Price<span class="required">*</span></label>
                          <form:input id="price" name="price" path="price" type="text"  class="form-control"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label for="description">Description<span class="required">*</span></label>
                          <form:input id="description" name="description" path="description" type="text"  class="form-control"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label for="specification">Specification<span class="required">*</span></label>
                          <form:input id="specification" name="specification" path="specification" type="text"  class="form-control"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label for="quantity">Quantity<span class="required">*</span></label>
                          <form:input id="quantity" name="quantity" path="quantity" type="text"  class="form-control"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label for="photo">Image<span class="required">*</span></label>
                          <form:input id="photo" name="photo" path="photo" type="file"  class="form-control"/>
                        </div>
                      </div>
                    </div>
                   <br>
                    <div class="row">
                    
                      <div class="col-md-12 text-right">
                      
                       <form:button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i> Add Product</form:button>
                        
                      </div>
                    </div>
                         
                         </form:form>
                         </div>
   </div>
  
  </main>


	<!-- Start Footer -->
	<nav> <jsp:include page="footer.jsp"></jsp:include> </nav>
	<!-- End Footer -->
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="resources/adminResources/assets/demo/chart-area-demo.js"></script>
	<script src="resources/adminResources/assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="basic.jsp"></jsp:include>

<link rel="stylesheet" href="resources/dashboard.css">


</head>
<body>


 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="logout.html">Logout</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          
          
          <ul class="nav nav-sidebar">
          
          	<c:forEach items="${menuList}" var="row">
          	 	<li><a href="${row.menuUrl}">${row.menuName}</a></li>
          	</c:forEach>
          
           
           
          
          </ul>
          
         
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         
         
          <div class="panel panel-primary">
			 <div class="panel-heading">
			   <h3 class="panel-title">User Entry</h3>
			 </div>
			 <div class="panel-body">
		  		
		  		<form:form action="saveUser.html" method="post" modelAttribute="user" >
		  		
		  			<form:hidden path="id"/>
		  		
		  		
				  <div class="form-group">
				    <label for="name">Name</label>
				    <form:input path="name" cssClass="form-control" id="name" placeholder="Name" />
				    
				  </div>
				  <div class="form-group">
				    <label for="address">Address</label>
				    <form:input path="address" cssClass="form-control" id="address" placeholder="Address" />
				    
				  </div>
				  
				  
				  <button type="submit" class="btn btn-default">Submit</button>
				</form:form>
		  		
		  		
		  		
		  		
		  
		  	</div>
		  
		  </div>
         
         
         
         
         <div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">User details</h3>
		  </div>
		  <div class="panel-body">
		    
		    <table class="table table-bordered">
		    	<thead>
		    		<tr>
		    			<th>Name</th>
		    			<th>Address</th>
		    			<th>DOB</th>
		    			<th>Phone No</th>
		    			<th>Action</th>
		    		</tr>
		    	</thead>
		    	
		    	<tbody>
		    		<c:forEach items="${userList}" var="row">
		    			<tr>
		    				<td> ${row.name} </td>
		    				<td> ${row.address} </td>
		    				<td> ${row.dob} </td>
		    				<td> ${row.phoneNo} </td>
		    				<td> <a href="editUser.html?id=${row.id}">Edit</a>  / <a href="deleteUser.html?id=${row.id}" >Delete</a>    </td>
		    			</tr>
		    		</c:forEach>
		    	</tbody>
		    	
		    	
		    </table>
		    
		    
		    
		    
		  </div>
		</div>
         
         
         
          
        </div>
      </div>
    </div>

</body>
</html>
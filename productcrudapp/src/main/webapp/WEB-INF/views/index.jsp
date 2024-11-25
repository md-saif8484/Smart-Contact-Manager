<html>
<head>
<%@ page isELIgnored="false" %>
<%@ include file="./base.jsp"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
</head>
<body class="bg-warning">
	<div class="container mt-3">
		<div class="row">

			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">SR No.</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${products }" var="p" varStatus="status">
						<tr>
							<th scope="row">${status.index + 1}</th>
							<td>${p.name}</td>
							<td>${p.description}</td>
							<td class="font-weight-bold">&#8377; ${p.price}</td>
							<td> 
								<a href="delete/${p.id}"> <i class="fa-regular fa-trash-can text-danger"></i> </a>
								<a href="update/${p.id }" class="ml-2"> <i class="fa-solid fa-file-pen"></i> </a>
							</td>
						</tr>
					</c:forEach>	
					</tbody>
				</table>
				
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add Product</a>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>

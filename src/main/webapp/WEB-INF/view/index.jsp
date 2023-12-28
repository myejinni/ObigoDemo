<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>${appTitle}</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">	
<script src="/js/axios.min.js"></script>
<%@ include file="/WEB-INF/view/include/head.jspf"%>
<c:choose>
    <c:when test="${fn:containsIgnoreCase(ua, 'Trident')}">
        <body class="preload hold-transition skin-blue sidebar-mini">
    </c:when>
    <c:otherwise>
        <body class="hold-transition skin-blue sidebar-mini">
    </c:otherwise>
</c:choose>
</head>
<body>
	<div class="wrapper">
		<!-- nav, sidebar -->
    <%@ include file="/WEB-INF/view/include/nav.jspf"%>
		<div class="content-wrapper">
			<div class="content body">
				<section class="content container-fluid">

					<div name="searchType" style= "display: inline-block">

							name: <input type="text" value="nameKey" placeholder="">

							email: <input type="text" value="emailKey" placeholder="">

							address: <input type="text" value="addressKey" placeholder="">

						<button type="button" onclick="" id="searchBtn">SEARCH</button>
					</div>

					<div class="box box-solid">
						<div class="box-header with-border">
							<h3 class="box-title" style="font-weight: bold;">Company</h3>
						</div>
						<div class="box-body">
							<div class="row">
								<div class="col-md-12">
									<table class="table table-condensed table-hover" id="table-company">
										<thead>
											<tr>
												<th>ID</th>
												<th>Name</th>
												<th>Email</th>
												<th>Address</th>
												<th>Description</th>
											</tr>
										</thead>
										<tbody id="table-list-body"></tbody>
									</table>
								</div>
							</div>
							<button id="deleteBtn"> 삭제 </button>
						</div>
					</div>
				</section>
<%--				<form method="put" id="insert_data">--%>
<%--					<button type="button" onclick="insertCompany()" id="insert_btn">INSERT</button>--%>
<%--				</form>--%>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/include/footer.jspf"%>
	</div> 
</body>
<script>

var setCompanyTable = function(data) {
	document.getElementById('table-list-body').innerHTML = '';
	let tr = '';
	for ( let i = 0 ; i < data.length ; i++ ) {
		var td = '';
		td += "<td onclick='deleteCompany("+data[i].companySeq+")'>" + data[i].companySeq + "</td>";
		td += "<td>" + data[i].name + "</td>";
		td += "<td>" + data[i].email + "</td>";
		td += "<td>" + data[i].address + "</td>";
		td += "<td>" + data[i].description + "</td>";
		
		tr += "<tr>" + td + "</tr>";
	}
	document.getElementById('table-list-body').innerHTML = tr;
}

const selectCompanyList = function() {
	axios.get( '/company', null ).then( function (response) {
		console.log( 'response.data : ', response.data );
		setCompanyTable(response.data);

	}).catch( function (error) {
		console.log('doLogin() -> error=', error);
    });
};

function insertCompany(){
	axios.put('/company').then(function (response) {
		setCompanyTable(response.data)
			}
	).catch( function (error) {
		console.log('doInsert -> error=', error);
	});
};

// if(document.getElementById('deleteBtn') != null) {
// 	document.getElementById('deleteBtn').onclick =
//

// if(document.getElementById('companySeq') != null) {
// 	document.getElementById('companySeq').onclick =

function deleteCompany(seq) {
	console.log(seq)
		let result = confirm('삭제?');
		if (result){
			let companySeq = seq;
			let url = "/company/" + companySeq;

				axios.delete(url)
						.then(function(response){
							setCompanyTable(response.data);
							// window.location.href="/company/" + companySeq;
							console.log(response.data);
						}).catch(function(error){
					console.log(error);
			})
                }
		// }
	// }
};


// document.getElementById('deleteBtn').onclick = function deleteCompany() {
// 	let result = confirm('삭제?');
// 	if (result){
// 		axios.delete('/company', {
// 			data:{
// 				companySeq: 8
// 			}
// 		}).then(function(response){
// 			setCompanyTable(response.data)
// 			console.log(response);
// 		}).catch(function(error){
// 			console.log(error);
// 		});
// 	}
// };

// document.getElementById('insert_btn').addEventListener('onclick',function() {
// 	console.log('insert-btn clicked...');
// 	insertCompany();
// })


window.addEventListener('DOMContentLoaded', function() {
	console.log('DOMContentLoaded() called...');
	
	selectCompanyList();
	
}, false);

</script>
</html>
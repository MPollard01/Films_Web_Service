<%@ include file ="./WEB-INF/view/header.jsp" %>

<div class="page-container">
<main class="container">
<div class="jumbotron">
	<h2>Welcome to My Films Web Service</h2>
	<p id="main-text">
		This is a cloud based web service that uses RESTful architecture, AJAX, CRUD operations
		and servlets. The site allows users to view a database of films in a variety of ways
		including JSON, XML and plain text. Users can also insert, update and delete records from
		the database.
	</p>
	<a id="btn1" href="/films" class="btn btn-info btn-lg" role="button">View Films</a>
</div>
	</main>


<footer class="row text-center bg-dark text-light" id="footer">
		<div class="col-md-4">
			<small>Mark Pollard</small>
		</div>
		<div class="col-md-4">
			<small>18045588</small>
		</div>
		<div class="col-md-4">
			<small>Web Service Assignment</small>
		</div>
</footer>
</div>
</body>
</html>
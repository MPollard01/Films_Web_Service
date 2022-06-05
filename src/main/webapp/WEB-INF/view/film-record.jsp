<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-info">

	<!-- Button trigger modal -->
	<div class="btn-group btn-group-justified ml-auto mr-auto">
		<div class="btn-group">
			<select class="btn btn-info btn-sm mr-3" id="format" name="format">
				<option value="json">JSON</option>
				<option value="xml">XML</option>
				<option value="plain">Plain</option>
			</select>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-info btn-sm ml-3 mr-3"
				data-toggle="modal" data-target="#search-film">Search</button>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-info btn-sm ml-3 mr-3"
				data-toggle="modal" data-target="#create-film">Create Film</button>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-info btn-sm ml-3"
				data-toggle="modal" data-target="#update-film">Update Film</button>
		</div>
	</div>
</nav>

<div class="container">
	<section class="search-container">
		<h1 class="title">Films</h1>		
		
		<!-- Modal search -->
		<div class="modal fade" id="search-film" tabindex="-1" role="dialog"
			aria-labelledby="searchTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="searchTitle">Search Film</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="form-group" id="searchfilm">
							<label class="mr-1" for="search">Search Films:</label> <input
								type="text" class="form-control" id="search" name="search"
								required>
							<div class="form-check">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optradio" value="id" checked="checked">Search
									by ID
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optradio" value="title">Search
									by title
								</label>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Search</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal create-->
		<div class="modal fade" id="create-film" tabindex="-1" role="dialog"
			aria-labelledby="createTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="createTitle">Create Film</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="was-validated" id="create">
							<div class="form-group">
								<label for="">ID:</label> <input type="number"
									class="form-control" placeholder="Enter title" id="cid" name ="cid" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="">Title:</label> <input type="text"
									class="form-control" placeholder="Enter title" id="ctitle" name ="ctitle"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="year">Year:</label> <input type="number"
									class="form-control" placeholder="Enter year" id="cyear" name ="cyear"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="director">Director:</label> <input type="text"
									class="form-control" placeholder="Enter director" id="cdirector" name ="cdirector"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="stars">Stars:</label> <input type="text"
									class="form-control" placeholder="Enter stars" id="cstars" name ="cstars"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="review">Review:</label>
								<textarea class="form-control" rows="5" id="creview" name ="creview" required></textarea>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Create</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal update-->
		<div class="modal fade" id="update-film" tabindex="-1" role="dialog"
			aria-labelledby="updateTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="updateTitle">Update Film</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="was-validated" id="update">
							<div class="form-group">
								<label for="">ID:</label> <input type="number"
									class="form-control" placeholder="Enter title" id="uid" name="uid" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="">Title:</label> <input type="text"
									class="form-control" placeholder="Enter title" id="utitle" name="utitle"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="year">Year:</label> <input type="number"
									class="form-control" placeholder="Enter year" id="uyear" name="uyear"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="director">Director:</label> <input type="text"
									class="form-control" placeholder="Enter director" id="udirector" name="udirector"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="stars">Stars:</label> <input type="text"
									class="form-control" placeholder="Enter stars" id="ustars" name="ustars"
									required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="review">Review:</label>
								<textarea class="form-control" rows="5" id="ureview" name="ustars" required></textarea>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>

	</section>
	
	<div id="films"></div>
	<div class="text-center">
		<div id="load"></div>
	</div>
</div>

<script src="scripts/main.js"></script>
<%@ include file="footer.jsp"%>

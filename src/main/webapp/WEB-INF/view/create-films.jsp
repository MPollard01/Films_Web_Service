<%@ include file="./header.jsp"%>

<main class="container">
	<div class="row">
		<div class="col-sm-6">
			<div class="card">
				<div class="card-header">Create</div>
				<div class="card-body">
					<h5 class="card-title">Create a film!</h5>
					<p class="card-text">Fill in the forms to add a film to our
						database.</p>
					<form action="#" class="was-validated">
						<div class="form-group">
							<label for="">ID:</label> <input type="number"
								class="form-control" placeholder="Enter title" id="id" required>
							<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="">Title:</label> <input type="text"
								class="form-control" placeholder="Enter title" id="title" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="year">Year:</label> <input type="number"
								class="form-control" placeholder="Enter year" id="year" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="director">Director:</label> <input type="text"
								class="form-control" placeholder="Enter director" id="director" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="stars">Stars:</label> <input type="text"
								class="form-control" placeholder="Enter stars" id="stars" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="review">Review:</label>
							<textarea class="form-control" rows="5" id="review" required></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Create</button>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="card">
				<div class="card-header">Update</div>
				<div class="card-body">
					<h5 class="card-title">Update a film!</h5>
					<p class="card-text">Fill in the forms to update a film to our
						database.</p>
					<form action="#" class="was-validated">
						<div class="form-group">
							<label for="">ID:</label> <input type="number"
								class="form-control" placeholder="Enter title" id="id" required>
							<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="">Title:</label> <input type="text"
								class="form-control" placeholder="Enter title" id="title" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="year">Year:</label> <input type="number"
								class="form-control" placeholder="Enter year" id="year" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="director">Director:</label> <input type="text"
								class="form-control" placeholder="Enter director" id="director" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="stars">Stars:</label> <input type="text"
								class="form-control" placeholder="Enter stars" id="stars" required>
								<div class="valid-feedback">Valid.</div>
    						<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-group">
							<label for="review">Review:</label>
							<textarea class="form-control" rows="5" id="review" required></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="./footer.jsp"%>
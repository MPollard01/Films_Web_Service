var form = document.getElementById('format');
var create = document.getElementById('create');
var del;
var load = document.getElementById('load');
var update = document.getElementById('update');
var search = document.getElementById('searchfilm');
window.addEventListener('load', getFilms);
form.addEventListener('change', getFilms);
create.addEventListener('submit', insertFilm);
update.addEventListener('submit', updateFilm);
search.addEventListener('submit', searchFilm);


function getFilms() {
	var format = form.value;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'getfilms?format='+format, true);
	load.className = 'spinner-border text-secondary';
	xhr.onload = function() {
		if(this.status == 200) {
			var output = headers(); 
			console.log(this.responseXML);
			if(format === 'json') output += jsonTable(JSON.parse(this.responseText));
			else if(format === 'xml') output += xmlTable(this.responseXML);
			else {
				var strings = this.responseText.split(/[\n\r]+/);
				var rows = new Array(strings.length);
			    for(var i=0; i<strings.length; i++) {
			      rows[i] = strings[i].split("#");
			    }
				output += stringTable(rows);
			}
			
			document.getElementById('films').innerHTML = output;
			deleteFilm();
			load.className = '';
		}
		
	}
	xhr.send();
	
}

function getFormData(form) {
	var data = {
		id: document.getElementById(form+'id').value,
		title: document.getElementById(form+'title').value,
		year: document.getElementById(form+'year').value,
		director: document.getElementById(form+'director').value,
		stars : document.getElementById(form+'stars').value,
		review: document.getElementById(form+'review').value
	};
	
	return data;
}

function insertFilm(e) {
	e.preventDefault();
	var data = getFormData('c');
	var json = JSON.stringify(data);
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'createfilm', true);
	xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
	xhr.send(json);
	xhr.onload = function() {
		if(this.status == 200) {
			getFilms();
		}
	}
	
}

function updateFilm(e) {
	e.preventDefault();
	var data = getFormData('u');
	var json = JSON.stringify(data);
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'updatefilm', true);
	xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
	xhr.send(json);
	xhr.onload = function() {
		if(this.status == 200) {
			getFilms();
		}
	}
}

function deleteFilm() {
	del = document.getElementsByClassName('delete');
	for (var i = 0; i < del.length; i++) {
	    del[i].addEventListener('click', function(e) {
	    	e.preventDefault();
	    	var id = 'id='+this.id;
	        var xhr = new XMLHttpRequest();
			xhr.open('POST', 'deletefilm', true);
			xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
			xhr.send(id);
			xhr.onload = function() {
				if(this.status == 200) {
					getFilms();
				}
			}
	    });
	}
}


function searchFilm(e) {
	e.preventDefault();
	var format = form.value;
	var check = document.getElementsByName('optradio');
	var option;
	for(var i=0; i<check.length; i++) {
		if(check[i].checked) option = check[i].value;
	}
	var input = document.getElementById('search').value;
	var url = 'getfilm?format='+format+'&option='+option+'&search='+input;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	load.className = 'spinner-border text-secondary';
	xhr.onload = function() {
		if(this.status == 200) {
			console.log(this.responseXML);
			var output = headers(); 
			if(format === 'json') output += jsonTable(JSON.parse(this.responseText));
			else if(format === 'xml') output += xmlTable(this.responseXML);
			else {
				var strings = this.responseText.split(/[\n\r]+/);
				var rows = new Array(strings.length);
			    for(var i=0; i<strings.length; i++) {
			      rows[i] = strings[i].split("#");
			    }
				output += stringTable(rows);
			}
			
			document.getElementById('films').innerHTML = output;
			deleteFilm();
			load.className = '';
		}
		
	}
	xhr.send();
}

function headers() {
	var output = 
			'<table class="table">' +
			'<tr class="thead-light">' +
			'<th><b>ID</b></th>' +
			'<th><b>Title</b></th>' +
			'<th><b>Year</b></th>' +
			'<th><b>Director</b></th>' +
			'<th><b>Stars</b></th>' +
			'<th><b>Review</b></th>' +
			'<th>delete</th>' +
		 	'</tr>';
	
	return output;
}

function jsonTable(films) {
	var output = '';
	
	if(Array.isArray(films)) {		
		for(var i in films) {
			output +=
			'<tr>' +
			'<td>'+films[i].id+'</td>' +
			'<td>'+films[i].title+'</td>' +
			'<td>'+films[i].year+'</td>' +
			'<td>'+films[i].director+'</td>' +
			'<td>'+films[i].stars+'</td>' +
			'<td>'+films[i].review+'</td>' +
			'<td><form class="delete" id="'+films[i].id+'"><button type="button" class="btn btn-sm btn-danger">Delete</button></form></td>' +
			'</tr>';
		}
	}
	else {
		output +=
			'<tr>' +
			'<td>'+films.id+'</td>' +
			'<td>'+films.title+'</td>' +
			'<td>'+films.year+'</td>' +
			'<td>'+films.director+'</td>' +
			'<td>'+films.stars+'</td>' +
			'<td>'+films.review+'</td>' +
			'<td><form class="delete" id="'+films.id+'"><button type="button" class="btn btn-sm btn-danger">Delete</button></form></td>' +
			'</tr>';
	}	
	output+= '</table>';
	
	return output;
}

function xmlTable(xml) {
	var output = '';
	var films = xml.getElementsByTagName("film");
	for(var i=0; i<films.length; i++) {
		var nodes = films[i].childNodes;
		var id = films[i].childNodes[0].childNodes[0].nodeValue;
		output += '<tr>';
		for(var j=0; j<nodes.length; j++) {
			output += '<td>'+nodes[j].childNodes[0].nodeValue+'</td>';
		}
		output +=
		'<td><form class="delete" id="'+id+'"><button type="button" class="btn btn-sm btn-danger">Delete</button></form></td>' +
		'</tr>';
	}
	output+= '</table>';
	return output;
}

function stringTable(rows) {
  var body = '';
  for(var i=0; i<rows.length; i++) {
    body += '<tr>';
    var row = rows[i];
    for(var j=0; j<row.length; j++) {
      body += '<td>' + row[j] + '</td>';
    }
    body += 
    	'<td><form class="delete" id="'+row[0]+'"><button type="button" class="btn btn-sm btn-danger">Delete</button></form></td>' +
    	'</tr>';
  }
  body += '</table>';
  return(body);
}
 
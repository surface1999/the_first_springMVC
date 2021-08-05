render = (data) => {
    let html = data.map((item, index) => {
        return `<tr>
                <th scope="row">${item.id}</th>
                <td><img src="../resources/images/${item.id}.png" alt="Trulli" width="60" height="60"></td>
                <td>${item.name }</td> 
                <td>${item.category }</td> 
                <td>${item.publisher}</td> 
                <td>${item.price}</td> 
                <td>${item.addDay}</td> 
                <td>
                <span onClick = Detail(${item.id}) ><i class="fas fa-info-circle mr-2"></i></span>
                <span onClick = Edit(${item.id}) data-toggle="modal"
					data-target="#exampleModalCenter" ><i class="text-warning fas fa-edit mr-2"></i></span>
                <span onClick = Delete(${item.id}) ><i class="text-danger fas fa-trash-alt"></i></span>
                </td>
             </tr>`;
    })
    document.getElementById("list-books").innerHTML = html.join(" ");

}

fill_form = (item) => {
        let html =  `<form action="/admin/update" method="post" enctype="multipart/form-data">
						<div class="mb-3">
							<label for="file" class="form-label">Avartar</label> <input
								type="file" class="form-control" id="file"
								aria-describedby="emailHelp">
						</div>
						<div class="mb-3">
							<label for="name" class="form-label">Name</label> <input
								type="txt" class="form-control" id="name"
								aria-describedby="emailHelp" value=${item.name}>
						</div>
						<div class="mb-3">
							<label for="category" class="form-label">Category</label> <input
								type="txt" class="form-control" id="category"
								aria-describedby="emailHelp" value=${item.category}>
						</div>
						<div class="mb-3">
							<label for="publisher" class="form-label">Publisher</label> <input
								type="txt" class="form-control" id="publisher"
								aria-describedby="emailHelp" value=${item.publisher}>
						</div>
						<div class="mb-3">
							<label for="price" class="form-label">Price</label> <input
								type="txt" class="form-control" id="price"
								aria-describedby="emailHelp" value=${item.price}>
						</div>
						<div class="mb-3">
							<label for="add-day" class="form-label">Add day</label> <input
								type="date" class="form-control" id="add-day"
								aria-describedby="emailHelp" value=${item.addDay}>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>`;
         document.getElementById("form-body").innerHTML = html;

}
let Edit = (id)=>{
	getBookById(id);
}


let getBooks = () => {
    // Khoi tao doi tuong
    var xhttp = new XMLHttpRequest() || ActiveXObject();
    // Bat su kien thay doi trang thai cuar request
    xhttp.onreadystatechange = function() {
            // Kiem tra neu nhu da gui request thanh cong
            if (this.readyState == 4 && this.status == 200) {
                // In ra data nhan duoc
                var data = JSON.parse(this.responseText);
                console.log(data);
                render(data);
            }
        }
        // cau hinh request
    // xhttp.open(method, url, true);
    xhttp.open("GET", "/admin/books", true);
    // cau hinh header cho request
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    // gui request
    xhttp.send('data=true');
}

let search = (e)=>{
	let key = e.target.value;
	console.log(key);
    // Khoi tao doi tuong
    var xhttp = new XMLHttpRequest() || ActiveXObject();
    // Bat su kien thay doi trang thai cuar request
    xhttp.onreadystatechange = function() {
            // Kiem tra neu nhu da gui request thanh cong
            if (this.readyState == 4 && this.status == 200) {
                // In ra data nhan duoc
                var data = JSON.parse(this.responseText);
                console.log(data);
                render(data);
            }
        }
        // cau hinh request
    // xhttp.open(method, url, true);
    xhttp.open("GET", `/admin/search?q=${key}`, true);
    // cau hinh header cho request
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    // gui request
    xhttp.send('data=true');
}

let getBookById = (id) => {
    // Khoi tao doi tuong
    var xhttp = new XMLHttpRequest() || ActiveXObject();
    // Bat su kien thay doi trang thai cuar request
    xhttp.onreadystatechange = function() {
            // Kiem tra neu nhu da gui request thanh cong
            if (this.readyState == 4 && this.status == 200) {
                // In ra data nhan duoc
                var data = JSON.parse(this.responseText);
                console.log(data);
                fill_form(data);
            }
        }
        // cau hinh request
    // xhttp.open(method, url, true);
    xhttp.open("GET", `/admin/getbook?id=${id}`, true);
    // cau hinh header cho request
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    // gui request
    xhttp.send('data=true');
}


window.addEventListener("load", getBooks());


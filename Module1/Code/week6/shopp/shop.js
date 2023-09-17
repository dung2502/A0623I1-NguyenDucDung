let products = ["Sony Xperia", "Samsung Galaxy", "Nokia 6", "Xioami Redmi Note 4", "Apple iPhone 6S", "Xioami Mi 5s Plus", "Apple iPhone 8 Plus", "Fujitsu F-04E", "Oppo A71"];
let display = document.getElementById("showProduct");
display.addEventListener("click", show);

function show() {
    let table = "<table >"
    for (let i = 0; i < products.length; i++) {
        table +=
            "<tr>" + "<td style='width: 40%'>" + products[i] + "</td>" +
            "<td>" + "<input class='btnEdit' type='button' value='Edit' data-index='" + i + "'>" + "</td>" +
            "<td>" + "<input id='delete' class='btnDelete' type='button' value='Delete' data-index='" + i + "'>" + "</td>" +
            "</tr>";
    }
    table += "</table>";
    document.getElementById("products").innerHTML = table;
}
let add = document.getElementById("Add");
add.addEventListener('click',addProduct)
function addProduct() {
    let newProduct = document.getElementById("new").value;
    products.push(newProduct);
    console.log(newProduct);
}

function editProduct() {

}
let deletes = document.getElementById("delete");
deletes.addEventListener("click",deleteProduct)
function deleteProduct() {
    products.splice()
}
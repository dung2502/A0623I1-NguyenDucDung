function square(number){
    return number * number;
}
function calculation(){
    let input = document.getElementById("input").value;
    let total = square(input);
    document.getElementById("total").innerHTML = total;
}

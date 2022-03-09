let xValues = [-3, -2, -1, -0, 1, 2, 3, 4, 5];
let rValues = [1, 2, 3, 4, 5];

function checkX (xValue){
    return xValues.includes(xValue);
}
function checkR(rValue){
    return rValues.includes(rValue);
}

function checkY(str){
    let path = /^0*((-[0-2](\.|,)[0-9]*)|([0-4](\.|,)[0-9]*)|-3(\.|,)0|5(\.|,)0|-[0-3]|[0-5])$/
    if(path.test(str)){
    }else{
        return false
    }
    return true
}

function validate(xValue, yValue, rValue){
    let flag = true;
    console.log(xValue)
    console.log(yValue)
    console.log(rValue)
    if(!checkX(Number(xValue))){
        flag = false;
    }
    if(!checkY(yValue)){
        flag = false;
    }
    if(!checkR(Number(rValue))){
        flag = false;
    }
    if(flag){
        hideError();
    }else{
        showError();
    }

    return flag;
}

function showError(){
    console.log("Make error")
    let errorPlace = document.getElementById("errorAns");
    errorPlace.innerHTML = "Не верные данные";
    $('#myForm\\:submitButton').prop("disabled", true);
}

function hideError(){
    console.log("all good")
    let errorPlace = document.getElementById("errorAns");
    errorPlace.innerHTML = " ";
    $('#myForm\\:submitButton').prop("disabled", false);
}

function validateAll(){
    let formSelectX = $("#myForm\\:selectX").val();
    let formTextY = $("#myForm\\:formTextY").val();
    let formSelectR = $("#myForm\\:selectR").val();
    if(validate(formSelectX, formTextY, formSelectR)){
        hideError();
    }else{
        showError("Неверные данные");
    }
}

function clickSubmit(){
    $("#myForm\\:submitButton").click();
}
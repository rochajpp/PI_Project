const checkbox = document.querySelector("#show-password");
const password = document.querySelector("#pass")

function showPass(){

    if(checkbox.checked){
        checkbox.checked = false;
    } else{
        checkbox.checked = true;
    }
  
    if(checkbox.checked){
        password.type = "name";
    } else{
        password.type = "password";
    }

}

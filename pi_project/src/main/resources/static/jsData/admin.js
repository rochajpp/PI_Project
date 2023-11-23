function start(){
    listCars();
    listUsers();
}

function listCars(){
    fetch("/api/getCars")
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            let cars = data;
            const tbody = document.querySelector(".carsBody");

            for(var i = 0; i < cars.length; i++){
                const tr = document.createElement("tr");

                const id = document.createElement("td")
                id.innerHTML = cars[i].id;
                tr.appendChild(id);

                const brand = document.createElement("td");
                brand.innerHTML = cars[i].brand;
                tr.appendChild(brand);

                const model = document.createElement("td");
                model.innerHTML = cars[i].model;
                tr.appendChild(model);

                const interest = document.createElement("td");
                interest.style.padding = "1rem";
                if(cars[i].interest){
                    const interestA = document.createElement("a");
                    interestA.style.textDecoration = "none";
                    interestA.href = "/backCar?idCar=" + cars[i].id;
                    const interestButton = document.createElement("button");
                    interestButton.innerHTML = "Add back to public list";

                    interestA.appendChild(interestButton);
                    
                    interestButton.classList.add("buttonInterest");
                    interest.appendChild(interestA);                 
                } else{
                    const p = document.createElement("p");
                    p.innerHTML = "No registered interest"
                    interest.appendChild(p);
                }
                tr.appendChild(interest);

                const manufactureYear = document.createElement("td");
                manufactureYear.innerHTML = cars[i].manufactureYear;
                tr.appendChild(manufactureYear);

                const modelYear = document.createElement("td");
                modelYear.innerHTML = cars[i].modelYear;
                tr.appendChild(modelYear);

                const registerDate = document.createElement("td");
                registerDate.innerHTML = cars[i].registerDate;
                tr.appendChild(registerDate);

                const actions = document.createElement("td");
                actions.style.display = "flex";
                actions.style.flexDirection = "column";
                actions.style.gap = "2rem";

                const set = document.createElement("a");
                const rm = document.createElement("a");


                set.innerHTML = "Set";
                rm.innerHTML = "Remove";

                set.href = "/setCar?idCar=" + cars[i].id;
                rm.href = "/rmCar?idCar=" + cars[i].id;

                actions.appendChild(set);
                actions.appendChild(rm);

                tr.appendChild(actions);

                tbody.appendChild(tr);
            }
        })
}


function listUsers(){
    fetch("/api/getUsers")
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            let users = data;
            const idUser = document.querySelector("#idUser").innerHTML;
            
            for(var i = 0; i < users.length; i++){
                const tbody = document.querySelector(".usersBody");
                if(users[i].id != idUser){
                    
                    const user = document.createElement("tr");
                    

                    const id= document.createElement("td");
                    id.innerHTML = users[i].id;
                    const name = document.createElement("td");
                    name.innerHTML = users[i].name;
                    const username = document.createElement("td");
                    username.innerHTML = users[i].login;

                    const fieldset = document.createElement("fieldset");
                    fieldset.style.width = "14px";
                    fieldset.style.height = "14px";
                    fieldset.style.border = "1px solid black";
                    fieldset.style.borderRadius = "2rem";
                    if(users[i].active){
                        fieldset.style.backgroundColor = "green";
                    } else{
                        fieldset.style.backgroundColor = "red";
                    }

                    const active = document.createElement("td");
                    active.appendChild(fieldset);

                    const registerDate = document.createElement("td");
                    registerDate.innerHTML = users[i].registerDate;

                    const actions = document.createElement("td");
                    actions.style.display = "flex";
                    actions.style.gap = "2rem";

                    const set = document.createElement("a");
                    set.innerHTML = "Set";
                    set.href = "/alterUser?id=" + users[i].id;
                

                    const remove = document.createElement("a");
                    remove.innerHTML = "Remove";
                    remove.href = "/removeUser?id=" + users[i].id;
                

                    actions.appendChild(set);
                    actions.appendChild(remove);
                    
                    user.appendChild(id);
                    user.appendChild(name);
                    user.appendChild(username);
                    user.appendChild(active);
                    user.appendChild(registerDate);
                    user.appendChild(actions);

                    tbody.appendChild(user);

                
                }

                
            }

        });

}
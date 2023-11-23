const body = document.querySelector("body");

function scrollHeader(){
    body.classList.toggle("scroll-header", scrollY > 0);
}

document.addEventListener("scroll", scrollHeader);
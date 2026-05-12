function loadCode(file,id){
    fetch(file)
    .then(res => res.text())
    .then(data=>{
        document.getElementById(id).textContent=data;
    });
}

function copyCode(id,btn){
    const code=document.getElementById(id).innerText;

    navigator.clipboard.writeText(code);

    btn.innerText="Copied";

    setTimeout(()=>{
        btn.innerText="Copy";
    },1500);
}
let form = document.querySelector('form')
data = document.querySelector('#data-aula')
form.addEventListener('submit',(e)=>{
    e.preventDefault();
    if(document.querySelector('#data-aula').value==''){
        Swal.fire({
            icon:'warning',
            title:'Cuidado!',
            text:'Lembre-se de selecionar uma data!'
        });
    } else {
        e.target.submit();
    }
})
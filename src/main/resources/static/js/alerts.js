document.querySelector('#cadastroAluno').addEventListener('submit',function(e){
    e.preventDefault()
    Swal.fire({
        title:'Cadastro efetuado!',
        text:'Verifique a caixa de entrada e caixa de spam do e-mail informado para prosseguir com a criação de sua senha!',
        icon:'success',
        allowOutsideClick: false,
        allowEscapeKey: false
    }).then((result)=>{
        if(result.isConfirmed){
            e.target.submit()
        }
    })
})
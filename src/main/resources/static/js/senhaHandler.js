let senha = document.querySelectorAll('input')[1];
let confirme = document.querySelectorAll('input')[2];
let form = document.querySelector('form');

let erro_senha = document.querySelectorAll('.mensagem-erro')[0];
erro_senha.textContent = '';
let erro_confirme = document.querySelectorAll('.mensagem-erro')[1];
erro_confirme.textContent = '';

senha.addEventListener('input',function(){  
    if(senha.value.length<8 && senha.value.length!=0){
        erro_senha.textContent = 'mínimo de 8 caractéres';
    } else {
        erro_senha.textContent = '';
    }
})

form.addEventListener('submit',function(e){
    e.preventDefault();
    if(senha.value!=confirme.value) {
        erro_confirme.textContent = 'as senhas não coincidem';
    } else {
        erro_confirme.textContent = '';
        e.target.submit();
    }
})
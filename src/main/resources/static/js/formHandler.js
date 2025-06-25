function mascaraCPF(campo) {
    let cpf = campo.value

    cpf = cpf.replace(/\D/g, '')

    cpf = cpf.substring(0, 11);

    if (cpf.length <= 11) {
        cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2')
        cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2')
        cpf = cpf.replace(/(\d{3})(\d{1,2})$/, '$1-$2')
    }

    campo.value = cpf
}

function mascaraCEP(campo) {
    let cep = campo.value;


    cep = cep.replace(/\D/g, '');

    cep = cep.substring(0, 8);

    if (cep.length <= 8) {
        cep = cep.replace(/(\d{5})(\d)/, '$1-$2');
    }

    campo.value = cep;
    if(campo.value.length==9){
        fetch(`https://viacep.com.br/ws/${cep}/json/`)
        .then(response => response.json())
        .then(data => {
            document.querySelector('#endereco-logradouro').value = data.logradouro
            document.querySelector('#endereco-bairro').value = data.bairro
            document.querySelector('#endereco-cidade').value = data.localidade
            document.querySelector('#endereco-estado').value = data.estado
        })
        .catch(error => console.error('Erro na requisição:', error));
    }
}

function mascaraCelular(campo) {
    let tel = campo.value;

    tel = tel.replace(/\D/g, '');

    if (tel.length > 11) tel = tel.slice(0, 11);

    if (tel.length >= 2) {
        tel = tel.replace(/^(\d{2})(\d)/g, '($1) $2');
    }
    if (tel.length >= 7) {
        tel = tel.replace(/(\d{5})(\d{1,4})$/, '$1-$2');
    }

    campo.value = tel;
}

function atualizarAssinaturaSelecionada() {
    try {   
        let assinatura = document.querySelector("#select-assinatura")
        document.querySelector("#form-assinatura").innerText = ` Você selecionou a assinatura ${assinatura.options[assinatura.selectedIndex].text}`;
    } catch (error) {
        
    }
}

function mascaraData(data){
    let split_d = data.split('-')
    return `${split_d[2]}/${split_d[1]}/${split_d[0]}`
}

window.addEventListener("DOMContentLoaded", atualizarAssinaturaSelecionada);
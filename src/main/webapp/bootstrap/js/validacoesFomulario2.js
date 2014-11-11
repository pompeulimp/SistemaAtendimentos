/**
 *     Cod erro.
 * 1 - Campo nulo.
 * 2 - Telefone invalido.
 * 3 - E-mail invalido.
 * 4 - Nome invalido.
 * 5 - Data invalida.
 * 6 - CPF/CNPJ invalido.
 * 7 - Endereço invalido.
 * @author Marcelo
 */


function validacao(campo){
    var valor = document.getElementById(campo).value;

    if(valor =="" || valor == null){
        erro(campo,1);
        return null;
    }else {
        erro(campo, 0);
    }

    if(campo == "nome"){
        validaNome(valor,campo);
    }else
        if(campo == "nascimento"){
            validata(valor,campo);
        }else
            if(campo == "email"){
                validaEmail(valor,campo);
            }else
            if(campo == "telefone"){
                validafone(valor,campo);
            }else
            	if(campo == "cpf"){
            		validaCPF(valor,campo);
            	}else
            		if(campo == "endereco"){
            			validaEndereco(valor,campo);
            		}
}


function validafone(numero, campo){
    var exprecao = /^\(\d{2}\)( |)(\d{5}|\d{4})\-\d{4}$/ig;
    var resultado = exprecao.test(numero);
    if(!resultado){
        erro(campo,2)
    }
}


function validaEmail(email, campo){
        var exprecao = /^(([a-zA-Z]+[0-9_.-]*)+@[a-zA-Z]{2,}\.[a-zA-Z]{2,4})+(\.?[a-zA-Z]{2})?$/ig;
        var resultado = exprecao.test(email);
        if(!resultado){
            erro(campo,3)
        }
    }


function validaNome(nome, campo){

    var exprecao = /^[a-zA-ZçÇ]+\ [a-zA-ZçÇ]+[ a-zA-ZçÇ]+$/ig;
    var resultado = exprecao.test(nome);
    if(!resultado){
     erro(campo,4)
    }
}


function validata(data, campo){
    var exprecao = /^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])\/([1-9]|1[0,1,2])\/(\d{2}|\d{4})|([1-9]|0[1-9]|[1,2][0-9]|3[0,1])\-([1-9]|1[0,1,2])\-(\d{2}|\d{4})$/ig;
    var resultado = exprecao.test(data);
    if(!resultado){
        erro(campo,5)
    }
}

function validaCPF(valor,campo){
    
    var exprecao = /^([0-9]{3}\.?[0-9]{3}\.?[0-9]{3}\-?[0-9]{2}|[0-9]{2}\.?[0-9]{3}\.?[0-9]{3}\/?[0-9]{4}\-?[0-9]{2})$/ig;
    var resultado = exprecao.test(valor);
    if(!resultado){
        erro(campo,6);
    }
    else
        erro(campo,0);

}

function validaEndereco(valor,campo){
	var exprecao = /^[a-z]*\ [a-z0-9,.]*\ [a-z0-9,.]*\ [a-z0-9,.]*\ [a-z0-9,.]*\ [a-z0-9,. ]*$/ig;
	var resultado = exprecao.test(valor);
	
	if(!resultado){
        erro(campo,7);
    }
    else
        erro(campo,0);
}

function erro(campo,codErro) {
	alert("a ta entrou no erro");
alert(campo);
        var  insere = document.getElementById(campo);
        var conteudo = insere.value;
        
        if(codErro != 0){
            if(codErro == 1){
                alert("O campo "+ campo+" é de preenchimento obrigatorio");
            }else
            if(codErro == 2){
                alert("Telefone invalido");
            }else
            if(codErro == 3){
                alert("E-mail invalido");
            }else
            if(codErro == 4){
                alert("Nome invalido ou incompleto");
            }else
            if(codErro == 5){
                alert("Data invalido");
            }else
            if(codErro == 6){
                alert("CPF/CNPJ invalido");
            }else
                if(codErro == 7){
                    alert("Endereço invalido");
                }
            insere.className -= insere.className ? ' form-control' : ' form-control';
            insere.className += insere.className ? ' form-control-error' : 'form-control-error';
        }else{        	
        	insere.className -= insere.className ? ' form-control-error' : 'form-control-error';
            insere.className += insere.className ? ' form-control' : ' form-control'; 
        
        }

}
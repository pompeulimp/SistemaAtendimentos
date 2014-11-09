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



function validaFormulario(){
	
	var campos = ["nome","cpf","endereco","telefone"];
	var result = true;
	for(i = 0; i < campos.length; i++){
				result = validacao(campos[i], true);
		if (!result){
			return false;
		}
		
	}
}


function validacao(campo,sub){
	
    var valor = document.getElementById(campo).value;

    
    
    if(valor =="" || valor == null){
        erro(campo,1,sub);
        return false;
    }else {
        erro(campo, 0);
    }

    if(campo == "nome"){
        return validaNome(valor,campo,sub);
    }else
        if(campo == "nascimento"){
            return validata(valor,campo,sub);
        }else
            if(campo == "email"){
                return validaEmail(valor,campo,sub);
            }else
            if(campo == "telefone"){
                return validafone(valor,campo,sub);
            }else
            	if(campo == "cpf"){
            	    return validaCPF(valor,campo,sub);
            	}else
            		if(campo == "endereco"){
            			return validaEndereco(valor,campo,sub);
            		}
}


function validafone(numero, campo,sub){
    var exprecao = /^\(\d{2}\)( |)(\d{5}|\d{4})\-\d{4}$/ig;
    var resultado = exprecao.test(numero);
    if(!resultado){
        erro(campo,2,sub);
    }else{
    	erro(campo,0);
    	return true;
    }
}


function validaEmail(email, campo,sub){
        var exprecao = /^(([a-zA-Z]+[0-9_.-]*)+@[a-zA-Z]{2,}\.[a-zA-Z]{2,4})+(\.?[a-zA-Z]{2})?$/ig;
        var resultado = exprecao.test(email);
        if(!resultado){
            erro(campo,3,sub);
        }else{

        	return true;
        }
    }


function validaNome(nome, campo,sub){

    var exprecao = /^[a-zA-ZçÇ]+\ [a-zA-ZçÇ]+[ a-zA-ZçÇ]+$/ig;
    var resultado = exprecao.test(nome);
    if(!resultado){
     erro(campo,4,sub);
    }else{
    	erro(campo,0);
    	return true;
    }
    
}


function validata(data, campo,sub){
    var exprecao = /^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])\/([1-9]|1[0,1,2])\/(\d{2}|\d{4})|([1-9]|0[1-9]|[1,2][0-9]|3[0,1])\-([1-9]|1[0,1,2])\-(\d{2}|\d{4})$/ig;
    var resultado = exprecao.test(data);
    if(!resultado){
        erro(campo,5,sub);
    }else{
    	erro(campo,0);
    	return true;
    }
}

function validaCPF(valor,campo,sub){
    
    var exprecao = /^([0-9]{3}\.?[0-9]{3}\.?[0-9]{3}\-?[0-9]{2}|[0-9]{2}\.?[0-9]{3}\.?[0-9]{3}\/?[0-9]{4}\-?[0-9]{2})$/ig;
    var resultado = exprecao.test(valor);
    if(!resultado){
        erro(campo,6,sub);
    }else{
    	erro(campo,0);
    	return true;
    }

}


function validaEmail(email, campo){
    var exprecao = /^(([a-zA-Z]+[0-9_.-]*)+@[a-zA-Z]{2,}\.[a-zA-Z]{2,4})+(\.?[a-zA-Z]{3})?$/ig;
    var resultado = exprecao.test(email);
    if(!resultado){
        erro(campo,3)
    }
}

function validaEndereco(valor,campo,sub){
	var exprecao = /^[a-z]*\ [a-z0-9,.]*\ [a-z0-9,.]*\ [a-z0-9,.]*\ [a-z0-9,.]*\ [a-z0-9,. ]*$/ig;
	var resultado = exprecao.test(valor);
	
	if(!resultado){
        erro(campo,7,sub);
    }else{
    	erro(campo,0);
    	return true;
    }
}

function erro(campo,codErro,sub) {
        var  insere = document.getElementById(campo);
        var conteudo = insere.value;
        
        if(codErro != 0){
        	if(sub){
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
        	}

        	insere.className -= insere.className ? ' form-control' : 'form-control';

            insere.className += insere.className ? ' erro' : 'erro';
            return false;
        }else{
            insere.className -= insere.className ? ' erro' : 'erro';

            insere.className += insere.className ? ' form-control' : 'form-control';

        
        }

}
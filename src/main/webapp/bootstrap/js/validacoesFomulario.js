/**
 * Cod erros:
 * 1 - campo nulo.
 * @param campo
 * @returns
 */


function validaNulidade(campo){
	if (document.getElementById(campo).value == "" || document.getElementById(campo).value == null){
		alert("vai mandar para o erro");
		erro(campo, 1);
	}else{
		alert("entrou no else");
		erro(campo, 0);	
	}
}



function erro(campo,codErro) {
	alert(campo);
	alert(codErro);
    var  insere = document.getElementById(campo);
    var conteudo = insere.value;
    if(codErro != 0){
    if(codErro == 1){ 
        alert("O campo "+ campo+" é de preenchimento obrigatorio");
       }
        insere.className += insere.className ? ' erro' : 'erro';
}else
insere.className -= insere.className ? ' erro' : 'erro';
}




function teste(){
	alert("ve se ta lincando ne");
}
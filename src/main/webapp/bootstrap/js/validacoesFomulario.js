function validaNulidade(campo){
	alert(campo);
    var  insere = document.getElementById(campo);
    var conteudo = insere.value;
    if(conteudo=="" || conteudo == null){
        alert("O campo "+ campo+" é de preenchimento obrigatorio");
        insere.className += insere.className ? ' erro' : 'erro';
    insere.focus();
}else
insere.className -= insere.className ? ' erro' : 'erro';

}
function teste(){
	alert("ve se ta lincando ne");
}
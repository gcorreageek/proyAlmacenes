function validarSoloNumeros(e) {

	/*var validos = "0123456789";

	var key = String.fromCharCode(event.keyCode);

	if (validos.indexOf("" + key) == "-1")
		return false;*/
	opc = false;
	tecla = (document.all) ? event.keyCode : e.which;
	if (tecla == 8) {opc = true;} // tecla backspace
	if (tecla >= 48 && tecla <= 57) {opc = true;} // sólo numeros
	return opc;

}
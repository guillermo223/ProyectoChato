<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<h2>Informe de cierre de la conversacion</h2>

<%
Long idConversacion = (Long) request.getAttribute("idConversacion");
%>
<portlet:actionURL var="urlVolverAlChat" name="VolverAlChat"/>
<portlet:actionURL var="urlCerrarConversacion" name="guardarConversacion" />
    <div>
		<label>Seleccionar Etiquetas:</label>
		 <input type="text"	 id="etiquetado"/>
		<input type="button" class="btn btn-primary" onclick="a�adirEtiquetas();" value="A�adir"/>
	</div>
	
<form action="${urlCerrarConversacion}" method="post">
    <textarea cols="10" rows="10" id="etiquetas" name="etiquetas">
	</textarea>
	<label>Escriba la descripci�n:</label>
	 <input
		type="text" name="descripcionConversacion" />
	
	
	<input type="hidden" name="idConversacion" value="<%=idConversacion.toString()%>"/>
	<div>
		<input type="submit" value="Finalizar Conversaci�n"
			class="btn btn-primary" />
	</div>
</form>
<form action="<%=urlVolverAlChat%>" method="post">
		 <input type="hidden" name="idConversacion" value="${idConversacion}" />
		<input type="submit" value="Volver" class="btn btn-primary">
</form>
		
<script>

function a�adirEtiquetas(){
		var etiqueta = document.getElementById("etiquetado");
		var etiquetas = document.getElementById("etiquetas");
		if(etiquetas.value.length == 0)
			{
			
			etiquetas.value = etiqueta.value + "\n";
		     etiqueta.value="";
			
			}
			 
		else{
			
			etiquetas.value = etiquetas.value + etiqueta.value + "\n";
			etiqueta.value="";
			
		}
		
	}
document.getElementById("etiquetas").value="";

$(document).ready(function (){
	$('#etiquetado').keypress(function(e){
		if(e.keyCode == 13){
			a�adirEtiquetas();
		}
	});
});
	
</script>

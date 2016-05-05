<%@page import="com.proyecto.quental.chat.portlets.PortletSoporte"%>
<%@ page import="java.util.List"%>
<%@page import="com.proyecto.quental.chat.model.Mensaje"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#txtArea {
	/*overflow-x:hidden;
    overflow-y:visible;*/
	overflow: scroll;
	height: 200px;
}
</style>
<%
Long idConversacion = (Long) request.getAttribute("idConversacion");
String fileName;
if(request.getAttribute("descarga")!=null) {
	fileName = (String)request.getAttribute("descarga");
    System.out.println("Descarga:" + fileName);
%>
<script>
$(document).ready(function(){
	document.getElementById('mensajeSoporte').value = 'Descarga:'+'<%=fileName %>';
	
});
</script>
<%

}
%>


<portlet:resourceURL var="urlMostrarMensajesAjaxSoporte">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
	<portlet:param name="accion" value="mostrarMensajes" />
</portlet:resourceURL>

<portlet:resourceURL var="urlEnviarMensajeAjaxSoporte">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
	<portlet:param name="accion" value="enviarMensaje" />
</portlet:resourceURL>


<portlet:actionURL var="urlCrearPdf" name="descargarConversacion">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
</portlet:actionURL> 
<portlet:actionURL var="urlCerrarConversacion" name="CerrarConversacion">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
</portlet:actionURL>
<portlet:actionURL var="urlInvitarTecnico" name="InvitarTecnico">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
</portlet:actionURL>
<portlet:actionURL var="urlVolver" name="Volver">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
</portlet:actionURL>
<portlet:actionURL var="urlAdjuntar" name="AdjuntarArchivo">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
</portlet:actionURL>



<div class="well" id="txtArea"></div>

<div>
	<div>
		<textarea name="textoEnviar" rows="3" id="mensajeSoporte"></textarea>
		<button class="btn btn-primary" onclick="enviarMensajeAjaxSoporte();">Enviar</button>
	</div>
</div>

<div id="botonesSecundarios">
	<table>
		<tr>
			<td>
				<form action="${urlCerrarConversacion}" method="post">
					<input class="btn btn-primary" type="submit" value="Cerrar" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="${urlInvitarTecnico}" method="post">
					<input class="btn btn-primary" type="submit" value="Invitar" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="${urlVolver}" method="post">
					<input class="btn btn-primary" type="submit" value="Volver" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="${urlAdjuntar}" method="post">
					<input class="btn btn-primary" type="submit" value="Adjuntar" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="${urlCrearPdf}" method="post">
					<input class="btn btn-primary" type="submit" value="Crear pdf" />
				</form>
			</td>
		</tr>
	</table>
</div>



<script type="text/javascript">

function printDescarga(fileName){
	document.getElementById('mensajeSoporte').value = 'Descarga:'+fileName;
}


var A = AUI();
var refreshUrl = "<%=urlMostrarMensajesAjaxSoporte.toString()%>";
 
ajaxRefreshSoporte();

self.setInterval(function(){
	ajaxRefreshSoporte();
	},1000);
function scrollToBottom (elemento){
	var caja =  document.getElementById(elemento);
	caja.scrollTop = caja.scrollHeight;
	
}

$(document).ready(function (){
	$('#mensajeSoporte').keypress(function(e){
		if(e.keyCode == 13){
			enviarMensajeAjaxSoporte();
		}
	});
	
});
function ajaxRefreshSoporte(){
	A.use('aui-io-request','aui-node',
			  function (A) {
						A.io.request(refreshUrl,
						{
				    	 on : {
								success : function() {
								var data = this.get('responseData');
								var texto="";
								data = JSON.parse(data);
								for (i in data) {
									//alert(data[i]._autor);
									//alert(data[i]._contenido);
									//if(data[i]._autor != "Quental")
		                           texto+="<b>" + data[i]._autor+"</b>" + "<br> " + data[i]._contenido + "<br>";
							}
		                      var cajaTexto = A.one('#txtArea');
		                      var textoAnterior = cajaTexto.html();
		                      if(textoAnterior.length < texto.length )
		                    	  {
		                    	      cajaTexto.html(texto);
		                    	      scrollToBottom('txtArea');   
		                    	  }
		                     
							}
						}
					});
					
				});  
			    
			}
	
function enviarMensajeAjaxSoporte(){

	 
	      var inputMensaje=document.getElementById('mensajeSoporte');
	      $.ajax ({ 
	         
	         url:'<%=urlEnviarMensajeAjaxSoporte%>',
			type : 'POST',
			data : ({
				textoEnviar : inputMensaje.value

			}),
			success : function() {
				inputMensaje.value = "";
			}

		});

	}
</script>

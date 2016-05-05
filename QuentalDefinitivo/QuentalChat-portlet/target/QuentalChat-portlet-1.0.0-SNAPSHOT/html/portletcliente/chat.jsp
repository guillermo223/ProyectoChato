<%@ page import="com.proyecto.quental.chat.portlets.PortletCliente"%>
<%@ page import="java.util.List"%>
<%@ page import="com.proyecto.quental.chat.model.Mensaje"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="css/main.css" rel="stylesheet" />

<portlet:defineObjects />

<%
	Long idConversacion = (Long) request.getAttribute("idConversacion");
	List<Mensaje> MensajesBaseDatos = (List<Mensaje>) request.getAttribute("mensajes");
%>

<portlet:resourceURL var="urlMostrarMensajesAjax">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
	<portlet:param name="accion" value="mostrarMensajes" />
</portlet:resourceURL>

<portlet:resourceURL var="urlEnviarMensajeAjax">
	<portlet:param name="idConv" value="<%=idConversacion.toString()%>" />
	<portlet:param name="accion" value="enviarMensaje" />
</portlet:resourceURL>


<div class="well" id="txtArea">
	<c:forEach items="<%=MensajesBaseDatos%>" var="mensaje">	
${mensaje.createDate}
${mensaje.autor}
${mensaje.contenido}
</c:forEach>
</div>

<div class="well-sm">
	<form role="form">
		<div class="form-group">
			<label for="mensaje" >Escriba aqui su mensaje:</label> 
			<textarea
				name="contenidoMensaje" id="mensaje" >
			</textarea>
		</div>
	</form>
	<button class="btn btn-primary" onclick="enviarMensajeAjaxCliente();">Enviar</button>
	<div id="linkDiv"></div>
</div>

<script type="text/javascript">
var A = AUI();
var refreshUrl = "<%=urlMostrarMensajesAjax.toString()%>";
 
ajaxRefreshCliente();
scrollToBottom('txtArea');

self.setInterval(function(){
	ajaxRefreshCliente();
},1000);
function scrollToBottom (elemento){
	var caja =  document.getElementById(elemento);
	caja.scrollTop = caja.scrollHeight;
	
}
$(document).ready(function (){
	$('#mensaje').keypress(function(e){
		if(e.keyCode == 13){
			enviarMensajeAjaxCliente();
		}
	})
});
	
function ajaxRefreshCliente(){
	A.use('aui-io-request','aui-node',
			  function (A) {
						A.io.request(refreshUrl,
						{
				    	 on : {
								success : function() {
								var data = this.get('responseData');
								var texto="";
								var contenido;
								data = JSON.parse(data);
								for (i in data) {
		                           texto+="<b>" + data[i]._autor+"</b>" + "<br> " + data[i]._contenido + "<br>";
		                           contenido=data[i]._contenido;
		                           if(contenido.includes("Descarga:")){
		                        	  var index = contenido.indexOf("Descarga:"); 
		                        	  index = index + 9 ;
		                        	  contenido = contenido.substr(index);
		                        	  
		                        	  var linkDiv = A.one('#linkDiv');
		                        	  linkDiv.html('<a href="http://localhost:8080/web/guest/chat-soporte?p_p_id=portletsoporte_WAR_QuentalChatportlet&p_p_lifecycle=2&p_p_cacheability=cacheLevelPage&_portletsoporte_WAR_QuentalChatportlet_filename=' + contenido +'&_portletsoporte_WAR_QuentalChatportlet_accion=adjuntarArchivo">' + contenido + '</a>');
		                        	  
		                        	 /* var textoLink = A.Node.create('<a href="http://localhost:8080/web/guest/chat-soporte?p_p_id=portletsoporte_WAR_QuentalChatportlet&p_p_lifecycle=2&p_p_cacheability=cacheLevelPage&_portletsoporte_WAR_QuentalChatportlet_filename=' + contenido +'&_portletsoporte_WAR_QuentalChatportlet_accion=adjuntarArchivo">' + contenido + '</a>').appendTo(linkDiv);
		                        	  */
		                           }
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
	
function enviarMensajeAjaxCliente(){
	 
	      var inputMensaje=document.getElementById('mensaje');
	      $.ajax ({ 
	         
	         url:'<%=urlEnviarMensajeAjax%>',
			type : 'POST',
			data : ({
				contenidoMensaje : inputMensaje.value

			}),
			success : function() {
				inputMensaje.value = "";
							 
			}
		});
	     
	}
</script>

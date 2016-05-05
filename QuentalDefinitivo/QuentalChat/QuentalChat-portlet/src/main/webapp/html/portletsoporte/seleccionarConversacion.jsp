<%@page import="com.proyecto.quental.chat.portlets.PortletSoporte"%>
<%@ page import="java.util.List"%>
<%@page import="com.proyecto.quental.chat.model.Conversacion"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
 String userIdString = request.getParameter("idConversacion");

%>

<portlet:actionURL name="seleccionarConversacion"	var="urlSeleccionarConversacion" />
<portlet:actionURL name="abrirChat"	var="urlAbrirChat" />	
	
<portlet:resourceURL var="urlMostrarConversacionesPendientesAjax">
	<portlet:param name="accion" value="mostrarConversacionesPendientes" />
</portlet:resourceURL>

<portlet:resourceURL var="urlMostrarMisConversacionesAjax">
	<portlet:param name="accion" value="mostrarMisConversaciones" />
	<portlet:param name="userId" value="<%=userIdString %>"/>
</portlet:resourceURL>



	<h2>Conversaciones Disponibles</h2>

<table id="tblConversacionesPendientes">


</table>


	<h2>Conversaciones en curso</h2>
	
<table id="tblConversacionesPropias">


</table>

 



<script>

var A = AUI();
var refreshPendientesUrl = "<%=urlMostrarConversacionesPendientesAjax.toString()%>";
var refreshMisConversacionesUrl = "<%=urlMostrarMisConversacionesAjax.toString()%>";
var seleccionarConversacionUrl = "<%=urlSeleccionarConversacion.toString() %>";
var abrirChatUrl = "<%=urlAbrirChat.toString() %>";

ajaxRefreshPendientes();
ajaxRefreshMisConversaciones();

self.setInterval(function(){
				ajaxRefreshPendientes();
				ajaxRefreshMisConversaciones();
				},5000);
			
		
		
		

	
function ajaxRefreshPendientes(){
	A.use('aui-io-request','aui-node',
			  function (A) {
						A.io.request(refreshPendientesUrl,
						{
				    	 on : {
								success : function() {
								var data = this.get('responseData');
								
								var tabla  = A.one('#tblConversacionesPendientes');
								tabla.empty();
							    var row = A.Node.create('<tr></tr>');
							    row.appendTo(tabla);
							    A.Node.create('<th>Fecha</th>').appendTo(row);
							    A.Node.create('<th>Categoria</th>').appendTo(row);
							    A.Node.create('<th>Nickname</th>').appendTo(row);
							    A.Node.create('<th></th>').appendTo(row);
								 
								data = JSON.parse(data);
								for (i in data) {
								     row = A.Node.create('<tr></tr>').appendTo(tabla);
									A.Node.create('<td>'+data[i]._createDate+'</td>').appendTo(row);
								    A.Node.create('<td>'+data[i]._categoria+'</td>').appendTo(row);
								    A.Node.create('<td>'+data[i]._nickName+'</td>').appendTo(row);
								    var celdaForm = A.Node.create('<td></td>');
								    celdaForm.appendTo(row);
								    
								   var formulario = A.Node.create('<form action="' + seleccionarConversacionUrl + '" method="post"></form>');
								   formulario.appendTo(celdaForm);
								  
								    A.Node.create('<input type="hidden" name="idConversacion" value="'+data[i]._conversacionId+'"/>').appendTo(formulario);
								    A.Node.create('<input class="btn btn-primary" type="submit" value="Empezar conversacion"/>').appendTo(formulario);
									 
		                          
							}
		                     
		                     
							}
						}
					});
					
				});  
			    
			}
function ajaxRefreshMisConversaciones(){
	A.use('aui-io-request','aui-node',
			  function (A) {
						A.io.request(refreshMisConversacionesUrl,
						{
				    	 on : {
								success : function() {
								var data = this.get('responseData');
								
								var tabla  = A.one('#tblConversacionesPropias');
								tabla.empty();
							    var row = A.Node.create('<tr></tr>');
							    row.appendTo(tabla);
							    A.Node.create('<th>Fecha</th>').appendTo(row);
							    A.Node.create('<th>Categoria</th>').appendTo(row);
							    A.Node.create('<th>Nickname</th>').appendTo(row);
							    A.Node.create('<th></th>').appendTo(row);
								data = JSON.parse(data);
								for (i in data) {
									    row = A.Node.create('<tr></tr>').appendTo(tabla);
										A.Node.create('<td>'+data[i]._createDate+'</td>').appendTo(row);
									    A.Node.create('<td>'+data[i]._categoria+'</td>').appendTo(row);
									    A.Node.create('<td>'+data[i]._nickName+'</td>').appendTo(row);
									    var celdaForm = A.Node.create('<td></td>');
									    celdaForm.appendTo(row);
									    
									   var formulario = A.Node.create('<form action="' + abrirChatUrl  + '" method="post"></form>');
									   formulario.appendTo(celdaForm);
									  
									    A.Node.create('<input type="hidden" name="idConversacion" value="'+data[i]._conversacionId+'"/>').appendTo(formulario);
									    A.Node.create('<input class="btn btn-primary" type="submit" value="Empezar conversacion"/>').appendTo(formulario);
										 
							}
		                     
						}
					}
					
				});  
			    
			})
}

</script>











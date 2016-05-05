<%@ page import="com.proyecto.quental.chat.portlets.PortletCliente"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />



<portlet:actionURL var="urlLogin" name="loginCliente" />
<div class="well">
<form role="form" action="${urlLogin}" method="post">
	<div class="form-group">
		<label for="nickname">Introduce un Nick </label>
		<input type="text" name="nickname" placeholder="Nick" id="nickname" />
	</div>
	<div class="form-group">
		<label for="categoria" >Selecciona una categoria </label>
		<select name="categoria">
			<option value="RRHH">RRHH</option>
			<option value="Administracion">Administracion</option>
			<option value="Legal">Legal</option>
			<option value="Tecnico" selected="selected">Tecnico</option>
			<option value="Otros">Otros</option>
		</select>
	</div>
	<div>
		<input type="submit" value="Entrar al chat" class="btn btn-primary" />
	</div>
</form>
</div>

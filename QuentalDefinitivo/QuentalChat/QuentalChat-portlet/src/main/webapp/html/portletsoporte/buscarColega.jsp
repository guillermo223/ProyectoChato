<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.Set"%>
<%@page import="com.proyecto.quental.chat.portlets.PortletSoporte"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%  Long idConversacion = (Long)request.getAttribute("idConversacion"); 
    Set<User> listaColegas=(Set<User>)request.getAttribute("listaColegas");
   %>

<portlet:actionURL name="invitarColega" var="urlInvitarColega" />
<portlet:actionURL name="volverAlChat" var="urlVolverAlChat" />

	
		<h2>Técnico de soporte activos</h2>
		<table>
		<c:forEach items="<%=listaColegas %>" var="colega">
			<tr>
				<td>${colega.getFullName()}</td>
				<td>	<form action="<%=urlInvitarColega%>" method="post">
					    <input type="hidden" name="idConversacion" value="<%=idConversacion.toString() %>" />
						<input type="hidden" name="userId" value="${colega.userId }">
						<input type="submit" value="Seleccionar" class="btn btn-primary">
					    </form>
				</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<form action="<%=urlVolverAlChat%>" method="post">
					    <input type="hidden" name="idConversacion" value="${idConversacion}" />
						<input type="submit" value="Volver" class="btn btn-primary">
		</form>
		
		
		
		
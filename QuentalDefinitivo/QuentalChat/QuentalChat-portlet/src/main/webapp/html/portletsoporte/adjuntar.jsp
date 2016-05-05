<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
 <% Long idConversacion = (Long) request.getAttribute("idConversacion");
 %>
<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>
 
<form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
 
	<input type="file" name="fileupload" class="btn btn-primary"/>
	<input type="hidden" name="idConversacion" value="<%=idConversacion %>" />
	<input name="Save" value="Enviar" type="submit" class="btn btn-primary" />
 
</form>




package com.proyecto.quental.chat.portlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.proyecto.quental.chat.model.Conversacion;
import com.proyecto.quental.chat.model.Mensaje;
import com.proyecto.quental.chat.model.impl.ConversacionImpl;
import com.proyecto.quental.chat.model.impl.MensajeImpl;
import com.proyecto.quental.chat.service.ConversacionLocalServiceUtil;
import com.proyecto.quental.chat.service.MensajeLocalServiceUtil;

/**
 * Portlet implementation class PortletCliente
 */
public class PortletCliente extends MVCPortlet {

	public static final String CATEGORIA = "categoria";
	public static final String NICKNAME = "nickname";
	public static final String VISTA_DESTINO = "vista_destino";

	private String loginTemplate;
	private String chatTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletCliente.class);

	public void init() {

		loginTemplate = getInitParameter("login-template");
		chatTemplate = getInitParameter("chat-template");

		// TODO Establecer conexion con el negocio

	}

	@ProcessAction(name = "loginCliente")
	public void loginCliente(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {

		// 1-Recoger los parametros que me envian desde el formulario

		String nickname = actionRequest.getParameter("nickname");
		String categoria = actionRequest.getParameter("categoria");

		try {

			Conversacion conversacion = new ConversacionImpl();
			conversacion.setNickName(nickname);
			conversacion.setCategoria(categoria);
			conversacion.setCreateDate(new Date());
			conversacion.setAsignado(false);
			ConversacionLocalServiceUtil.addConversacion(conversacion);

			Long conversacionIdLong = conversacion.getConversacionId();

			actionRequest.setAttribute("idConversacion", conversacionIdLong);

			actionResponse.setRenderParameter(VISTA_DESTINO, "chat");

		} catch (Exception e) {
			e.printStackTrace();
			actionRequest.setAttribute("mensaje", "No has podido entrar en el chat");
			actionResponse.setRenderParameter(VISTA_DESTINO, "login");

		}

	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String accion = resourceRequest.getParameter("accion");
		String idConversacionString = resourceRequest.getParameter("idConv");
		// _log.info("El idConversacion en serveResourse es: " +
		// idConversacionString);
		long conversacionIdLong = Long.parseLong(idConversacionString);
		if (accion.equals("mostrarMensajes")) {
			try {

				List<Mensaje> mensajesList = MensajeLocalServiceUtil.getMensajesByConversacion(conversacionIdLong);

				// Hay que transformar mensajesList en un JSON con los datos que
				// necesitamos

				String mensajesJson = new Gson().toJson(mensajesList);

				String mensajesJSON = JSONFactoryUtil.serialize(mensajesJson);
				// _log.info("El Json es: " + mensajesJSON);
				resourceResponse.getWriter().print(mensajesJSON);

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (accion.equals("enviarMensaje")) {
			String mensajeDesdeVista = (String) resourceRequest.getParameter("contenidoMensaje");

			Mensaje mensaje = new MensajeImpl();

			try {
				Conversacion conversacion = ConversacionLocalServiceUtil.getConversacion(conversacionIdLong);
				mensaje.setConversacionId(conversacionIdLong);
				mensaje.setAutor(conversacion.getNickName());
				mensaje.setContenido(mensajeDesdeVista);
				mensaje.setCreateDate(new Date());
				MensajeLocalServiceUtil.addMensaje(mensaje);
				// refrescamos la vista
				List<Mensaje> mensajesList = MensajeLocalServiceUtil.getMensajesByConversacion(conversacionIdLong);

				// Hay que transformar mensajesList en un JSON con los datos que
				// necesitamos

				String mensajesJson = new Gson().toJson(mensajesList);

				String mensajesJSON = JSONFactoryUtil.serialize(mensajesJson);
				// _log.info("El Json es: " + mensajesJSON);
				resourceResponse.getWriter().print(mensajesJSON);
				// resourceRequest.setAttribute("idConversacion",
				// conversacionIdLong);

			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String vista = renderRequest.getParameter(VISTA_DESTINO);

		_log.info("La vista a la que queremos acceder es: " + vista);

		if (vista != null) {

			switch (vista) {

			case "login":
				include(loginTemplate, renderRequest, renderResponse);
				break;

			case "chat":
				include(chatTemplate, renderRequest, renderResponse);
				break;

			default:
				include(loginTemplate, renderRequest, renderResponse);
				break;
			}
		} else {
			include(loginTemplate, renderRequest, renderResponse);
		}
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

}

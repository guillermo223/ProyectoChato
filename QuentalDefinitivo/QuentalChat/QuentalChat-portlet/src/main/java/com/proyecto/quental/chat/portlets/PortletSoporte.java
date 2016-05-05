
package com.proyecto.quental.chat.portlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.proyecto.quental.chat.model.Conversacion;
import com.proyecto.quental.chat.model.Mensaje;
import com.proyecto.quental.chat.model.impl.MensajeImpl;
import com.proyecto.quental.chat.service.AsignacionLocalServiceUtil;
import com.proyecto.quental.chat.service.ConversacionLocalServiceUtil;
import com.proyecto.quental.chat.service.MensajeLocalServiceUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Portlet implementation class PortletSoporte
 */
public class PortletSoporte extends MVCPortlet {

	public static final String MENSAJES_POR_ID = "mensajesPorId";
	public static final String LISTA_CONVERSACIONES = "listaConversaciones";
	public static final String MENSAJES_EN_LA_BASE_DE_DATOS = "mensajes";
	public static final String VISTA_DESTINO = "vista_destino";

	private String conversacionTemplate;
	private String chatTemplate;
	private String cerrarTemplate;
	private String buscarTemplate;
	private String adjuntarTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletCliente.class);

	public void init() throws PortletException {
		super.init();
		conversacionTemplate = getInitParameter("conversacion-template");
		chatTemplate = getInitParameter("chat-template");
		cerrarTemplate = getInitParameter("cerrar-template");
		buscarTemplate = getInitParameter("buscar-template");
		adjuntarTemplate = getInitParameter("adjuntar-template");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String vista = renderRequest.getParameter(VISTA_DESTINO);

		_log.info("La vista a la que queremos acceder es: " + vista);

		if (vista != null) {
			switch (vista) {
			case "chatSoporte":
				include(chatTemplate, renderRequest, renderResponse);
				break;
			case "buscarColega":
				include(buscarTemplate, renderRequest, renderResponse);
				break;
			case "cerrar":
				include(cerrarTemplate, renderRequest, renderResponse);
				break;
			case "adjuntar":
				include(adjuntarTemplate, renderRequest, renderResponse);
				break;

			default:

				include(conversacionTemplate, renderRequest, renderResponse);
				break;
			}
		} else {

			include(conversacionTemplate, renderRequest, renderResponse);
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

	@ProcessAction(name = "abrirChat")
	public void abrirChat(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException, PortalException {
		long idConversacionLong = Long.parseLong(actionRequest.getParameter("idConversacion"));

		// buscamos el id del tecnico

		// long userId =Long.parseLong(actionRequest.getRemoteUser());
		// asignamos la conversacion a este tecnico

		List<Mensaje> mensajesByConversacion = MensajeLocalServiceUtil.getMensajesByConversacion(idConversacionLong);
		actionRequest.setAttribute(MENSAJES_POR_ID, mensajesByConversacion);
		// actionRequest.setAttribute(MENSAJES_POR_ID, mensajesByConversacion);
		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
		// actionRequest.setAttribute(VISTA_DESTINO, "chatSoporte");
		actionResponse.setRenderParameter(VISTA_DESTINO, "chatSoporte");

	}

	@ProcessAction(name = "seleccionarConversacion")
	public void seleccionarConversacion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException, PortalException {

		// recuperamos el id de la conversacion
		long idConversacionLong = Long.parseLong(actionRequest.getParameter("idConversacion"));

		// buscamos el id del tecnico

		long userId = Long.parseLong(actionRequest.getRemoteUser());
		// asignamos la conversacion a este tecnico
		AsignacionLocalServiceUtil.asignarConversacion(idConversacionLong, userId);

		List<Mensaje> mensajesByConversacion = MensajeLocalServiceUtil.getMensajesByConversacion(idConversacionLong);

		actionRequest.setAttribute(MENSAJES_POR_ID, mensajesByConversacion);

		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));

		actionResponse.setRenderParameter(VISTA_DESTINO, "chatSoporte");

	}
	@ProcessAction(name = "descargarConversacion")
	public void descargarConversacion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException, PortalException {
		long conversacionId = Long.parseLong(actionRequest.getParameter("idConv"));

		try {
			// Recuperamos conversacion por id:
			Conversacion conversacion = ConversacionLocalServiceUtil.getConversacion(conversacionId);

			actionRequest.setCharacterEncoding(StringPool.UTF8);
			// Creamos un documento vacio:
			Document document = new Document(PageSize.A4.rotate());

			// Indicamos donde guardarlo
			// Encontramos el path de la carpeta del usuario
			String home = System.getProperty("user.home");
			// Vamos a usar el numero que corresponde con la fecha actual para generar un nombre de archivo unico en la
			// la carpeta Descargas
			String archivoFullName = home+ File.separator + "Downloads" + File.separator + "ConsultaTecnica.pdf";
			//System.out.println("el archivo es : " + archivoFullName );
			//Date fecha = new Date();
			//File file = new File(home+"/Descargas/ConsultaTecnica" + fecha.getTime() + ".pdf"); 
			FileOutputStream ficheroPdf = new FileOutputStream(archivoFullName);

			// La clase predefinida PdfWriter llama al metodo estatico
			// getInstance
			PdfWriter.getInstance(document, ficheroPdf);

			// Abrimos el pdf en metodo de escritura:
			document.open();

			// Creamos una tabla pdf con tantos campos como necesitemos:
			PdfPTable table1 = new PdfPTable(2);

			// Campos de la conversacion
			table1.addCell("Id de la conversacion");
			table1.addCell(String.valueOf(conversacion.getConversacionId()));

			// Añadimos la tabla al documento pdf
			document.add(table1);

			PdfPTable table2 = new PdfPTable(2);
			table2.addCell("Fecha de inicio");
			table2.addCell(String.valueOf(conversacion.getCreateDate()));
			document.add(table2);

			PdfPTable table3 = new PdfPTable(2);
			table3.addCell("Fecha fin");
			table3.addCell(String.valueOf(conversacion.getFinDate()));
			document.add(table3);

			document.add(new Paragraph(" "));

			PdfPTable table4 = new PdfPTable(1);
			table4.setWidthPercentage(100);
			table4.addCell("Mensajes");
			table4.addCell(conversacion.getDescripcion());
			document.add(table4);

			// celda.setColspan(2);
			// Recuperamos el mensaje:
			List<Mensaje> mensajes = MensajeLocalServiceUtil.getMensajesByConversacion(conversacionId);

			if (mensajes != null) {
				for (int i = 0; i < mensajes.size(); i++) {
					PdfPTable table5 = new PdfPTable(4);
					table5.setWidthPercentage(100);
					// Campos del mensaje
					table5.addCell("Emisor");
					table5.addCell(mensajes.get(i).getAutor());

					table5.addCell("Contenido");
					table5.addCell(mensajes.get(i).getContenido());
					document.add(table5);
				}
			}

			// Cerramos el documento
			document.close();
			actionRequest.setAttribute("idConversacion", conversacionId);
			// TODO: enviar un mensaje de que el archivo se ha guardado correctamente
			actionResponse.setRenderParameter(VISTA_DESTINO, "chatSoporte");
            
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String idConversacionString;
		String accion = resourceRequest.getParameter("accion");

		switch (accion) {
		case "mostrarMensajes":
			try {
				idConversacionString = resourceRequest.getParameter("idConv");
				long conversacionIdLong = Long.parseLong(idConversacionString);
				List<Mensaje> mensajesList = MensajeLocalServiceUtil.getMensajesByConversacion(conversacionIdLong);

				// Hay que transformar mensajesList en un JSON con los datos que
				// necesitamos

				String mensajesJson = new Gson().toJson(mensajesList);

				String mensajesJSON = JSONFactoryUtil.serialize(mensajesJson);

				resourceResponse.getWriter().print(mensajesJSON);

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "enviarMensaje":
			idConversacionString = resourceRequest.getParameter("idConv");
			long conversacionIdLong = Long.parseLong(idConversacionString);
			String mensajeDesdeVista = resourceRequest.getParameter("textoEnviar");
			Mensaje mensaje = new MensajeImpl();

			try {

				mensaje.setConversacionId(conversacionIdLong);
				mensaje.setAutor("servicioTecnico");
				mensaje.setContenido(mensajeDesdeVista);
				mensaje.setCreateDate(new Date());
				MensajeLocalServiceUtil.addMensaje(mensaje);
				// refrescamos la vista
				List<Mensaje> mensajesList = MensajeLocalServiceUtil.getMensajesByConversacion(conversacionIdLong);

				// Hay que transformar mensajesList en un JSON con los datos que
				// necesitamos

				String mensajesJson = new Gson().toJson(mensajesList);

				String mensajesJSON = JSONFactoryUtil.serialize(mensajesJson);

				resourceResponse.getWriter().print(mensajesJSON);

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "mostrarConversacionesPendientes":

			try {
				List<Conversacion> conversacionesNoAsignadas = ConversacionLocalServiceUtil
						.getConversacionesNoAsignadas();
				String conversacionesJson = new Gson().toJson(conversacionesNoAsignadas);

				String conversacionesJSON = JSONFactoryUtil.serialize(conversacionesJson);

				resourceResponse.getWriter().print(conversacionesJSON);

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "mostrarMisConversaciones":

			try {

				long userId = Long.parseLong(resourceRequest.getRemoteUser());

				List<Conversacion> conversacionesPropias = ConversacionLocalServiceUtil
						.getConversacionesAsignadasPorTecnico(userId);
				String conversacionesJson = new Gson().toJson(conversacionesPropias);

				String conversacionesJSON = JSONFactoryUtil.serialize(conversacionesJson);

				resourceResponse.getWriter().print(conversacionesJSON);

			} catch (SystemException | PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "adjuntarArchivo":
			try {

				_log.debug(resourceRequest.getParameter("filename"));

				String realPath = getPortletContext().getRealPath("/");
				File file = new File(realPath + "/html/uploads/" + resourceRequest.getParameter("filename"));
				InputStream in = new FileInputStream(file);
				HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);

				HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);

				// PortletResponseUtil.sendFile(httpReq, httpRes,
				// file.getName(), in, "application/force-download");
				ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/force-download");
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		

		}

	}

	@ProcessAction(name = "CerrarConversacion")
	public void cerrarConversacion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException {

		long idConversacionLong = Long.parseLong(actionRequest.getParameter("idConv"));
		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
		actionResponse.setRenderParameter(VISTA_DESTINO, "cerrar");
	}

	@ProcessAction(name = "InvitarTecnico")
	public void invitarTecnico(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException {

		long idConversacionLong = Long.parseLong(actionRequest.getParameter("idConv"));
		_log.info("El idConversacion en invitarTecnico en long es: " + idConversacionLong);

		try {
			Set<User> listaColegas = AsignacionLocalServiceUtil.getListaColegasOnLine();
			long userId = Long.parseLong(actionRequest.getRemoteUser());
			User user = UserLocalServiceUtil.getUser(userId);
			listaColegas.remove(user);

			actionRequest.setAttribute("listaColegas", listaColegas);
			actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
			actionResponse.setRenderParameter(VISTA_DESTINO, "buscarColega");

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@ProcessAction(name = "Volver")
	public void volver(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException {

		long idConversacionLong = Long.parseLong(actionRequest.getParameter("idConv"));
		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
		actionResponse.setRenderParameter(VISTA_DESTINO, "conversacionTemplate");

	}

	@ProcessAction(name = "AdjuntarArchivo")
	public void adjuntarArchivo(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException {

		long idConversacionLong = Long.parseLong(actionRequest.getParameter("idConv"));
		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
		actionResponse.setRenderParameter(VISTA_DESTINO, "adjuntar");

	}

	@ProcessAction(name = "invitarColega")
	public void invitarColega(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException {

		String idConversacion = actionRequest.getParameter("idConversacion");
		_log.info("El idConversacion en invitarColega es: " + idConversacion);
		String idColega = actionRequest.getParameter("userId");
		long idConversacionLong = Long.parseLong(idConversacion);
		long idColegaLong = Long.parseLong(idColega);

		AsignacionLocalServiceUtil.compartirConversacion(idConversacionLong, idColegaLong);
		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
		actionResponse.setRenderParameter(VISTA_DESTINO, "chatSoporte");
	}

	@ProcessAction(name = "guardarConversacion")
	public void guardarConversacion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub

		long idConversacion = Long.parseLong(actionRequest.getParameter("idConversacion"));

		String descripcion = actionRequest.getParameter("descripcionConversacion");
		String etiquetas = actionRequest.getParameter("etiquetas");

		try {

			Conversacion conversacion = ConversacionLocalServiceUtil.getConversacion(idConversacion);
			conversacion.setDescripcion(descripcion);
			conversacion.setEtiquetas(etiquetas);
			conversacion.setFinDate(new Date());
			conversacion.setCerrada(true);
			ConversacionLocalServiceUtil.updateConversacion(conversacion);

			
			actionResponse.setRenderParameter(VISTA_DESTINO, "conversacion");

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@ProcessAction(name = "VolverAlChat")
	public void volverAlChat(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, SystemException, IOException, PortletException {
		String idConversacion = actionRequest.getParameter("idConversacion");
		long idConversacionLong = Long.parseLong(idConversacion);

		actionRequest.setAttribute("idConversacion", new Long(idConversacionLong));
		actionResponse.setRenderParameter(VISTA_DESTINO, "chatSoporte");
	}

	@ProcessAction(name = "upload")
	public void upload(ActionRequest request, ActionResponse response) throws Exception {

		// Obtengo la ruta de mi portlet, donde voy a guardar el documento
		// TODO: Cambiar a directorio Data de Liferay. Estructura :
		// Data/nombre_portlet/conversacion/documento

		String realPath = getPortletContext().getRealPath("/");

		String idConversacion = request.getParameter("idConversacion");
		long idConversacionLong = Long.parseLong(idConversacion);

		String sourceFileName = null;
		try {
			// Obtengo del portal el fichero a partir del parametro (fileupload)
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			File file = uploadRequest.getFile("fileupload");
			// Obtengo el nombre real del fichero
			sourceFileName = uploadRequest.getFileName("fileupload");
			// Muevo el fichero a mi estructura
			// TODO: Crear una subcarpeta para clasificar documentos por id de
			// conversacion

			file.renameTo(new File(realPath + "html/uploads/" + sourceFileName));

		} catch (Exception e) {
			System.out.println("Exception::::" + e.getMessage());
		}
		String ruta = generarUrlDeRecurso(request, sourceFileName);

		String resultado = "<a href=\"" + ruta + "\" >" + sourceFileName + "</a>";

		System.out.println(resultado);

		_log.debug(resultado);

		request.setAttribute("descarga", sourceFileName);
		request.setAttribute("idConversacion", new Long(idConversacionLong));

		// request.setAttribute("urlFile", ruta);
		response.setRenderParameter(VISTA_DESTINO, "chatSoporte");

	}

	private String generarUrlDeRecurso(ActionRequest request, String sourceFileName) {
		// Generamos la url para enviarla como mensaje al chat

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		LiferayPortletURL liferayPortletURL = PortletURLFactoryUtil.create(request, themeDisplay.getPpid(),
				themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);

		liferayPortletURL.setParameter("filename", sourceFileName);
		liferayPortletURL.setParameter("accion", "adjuntarArchivo");

		_log.debug(liferayPortletURL.toString());
		return liferayPortletURL.toString();
	}

}

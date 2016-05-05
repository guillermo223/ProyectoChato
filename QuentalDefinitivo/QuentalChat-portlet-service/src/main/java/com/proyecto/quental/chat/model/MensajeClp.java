package com.proyecto.quental.chat.model;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.ContainerModel;
import com.liferay.portal.model.TrashedModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;

import com.proyecto.quental.chat.service.ClpSerializer;
import com.proyecto.quental.chat.service.MensajeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MensajeClp extends BaseModelImpl<Mensaje> implements Mensaje {
    private long _mensajeId;
    private String _autor;
    private Date _createDate;
    private String _contenido;
    private long _conversacionId;
    private BaseModel<?> _mensajeRemoteModel;
    private Class<?> _clpSerializerClass = com.proyecto.quental.chat.service.ClpSerializer.class;

    public MensajeClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Mensaje.class;
    }

    @Override
    public String getModelClassName() {
        return Mensaje.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _mensajeId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMensajeId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _mensajeId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mensajeId", getMensajeId());
        attributes.put("autor", getAutor());
        attributes.put("createDate", getCreateDate());
        attributes.put("contenido", getContenido());
        attributes.put("conversacionId", getConversacionId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mensajeId = (Long) attributes.get("mensajeId");

        if (mensajeId != null) {
            setMensajeId(mensajeId);
        }

        String autor = (String) attributes.get("autor");

        if (autor != null) {
            setAutor(autor);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        String contenido = (String) attributes.get("contenido");

        if (contenido != null) {
            setContenido(contenido);
        }

        Long conversacionId = (Long) attributes.get("conversacionId");

        if (conversacionId != null) {
            setConversacionId(conversacionId);
        }
    }

    @Override
    public long getMensajeId() {
        return _mensajeId;
    }

    @Override
    public void setMensajeId(long mensajeId) {
        _mensajeId = mensajeId;

        if (_mensajeRemoteModel != null) {
            try {
                Class<?> clazz = _mensajeRemoteModel.getClass();

                Method method = clazz.getMethod("setMensajeId", long.class);

                method.invoke(_mensajeRemoteModel, mensajeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAutor() {
        return _autor;
    }

    @Override
    public void setAutor(String autor) {
        _autor = autor;

        if (_mensajeRemoteModel != null) {
            try {
                Class<?> clazz = _mensajeRemoteModel.getClass();

                Method method = clazz.getMethod("setAutor", String.class);

                method.invoke(_mensajeRemoteModel, autor);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_mensajeRemoteModel != null) {
            try {
                Class<?> clazz = _mensajeRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_mensajeRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContenido() {
        return _contenido;
    }

    @Override
    public void setContenido(String contenido) {
        _contenido = contenido;

        if (_mensajeRemoteModel != null) {
            try {
                Class<?> clazz = _mensajeRemoteModel.getClass();

                Method method = clazz.getMethod("setContenido", String.class);

                method.invoke(_mensajeRemoteModel, contenido);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getConversacionId() {
        return _conversacionId;
    }

    @Override
    public void setConversacionId(long conversacionId) {
        _conversacionId = conversacionId;

        if (_mensajeRemoteModel != null) {
            try {
                Class<?> clazz = _mensajeRemoteModel.getClass();

                Method method = clazz.getMethod("setConversacionId", long.class);

                method.invoke(_mensajeRemoteModel, conversacionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public TrashEntry getTrashEntry() throws PortalException, SystemException {
        if (!isInTrash()) {
            return null;
        }

        TrashEntry trashEntry = TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
                getTrashEntryClassPK());

        if (trashEntry != null) {
            return trashEntry;
        }

        TrashHandler trashHandler = getTrashHandler();

        if (!Validator.isNull(trashHandler.getContainerModelClassName())) {
            ContainerModel containerModel = null;

            try {
                containerModel = trashHandler.getParentContainerModel(this);
            } catch (NoSuchModelException nsme) {
                return null;
            }

            while (containerModel != null) {
                if (containerModel instanceof TrashedModel) {
                    TrashedModel trashedModel = (TrashedModel) containerModel;

                    return trashedModel.getTrashEntry();
                }

                trashHandler = TrashHandlerRegistryUtil.getTrashHandler(trashHandler.getContainerModelClassName());

                if (trashHandler == null) {
                    return null;
                }

                containerModel = trashHandler.getContainerModel(containerModel.getParentContainerModelId());
            }
        }

        return null;
    }

    @Override
    public long getTrashEntryClassPK() {
        return getPrimaryKey();
    }

    @Override
    public TrashHandler getTrashHandler() {
        return TrashHandlerRegistryUtil.getTrashHandler(getModelClassName());
    }

    @Override
    public boolean isInTrash() {
        if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInTrashContainer() {
        TrashHandler trashHandler = getTrashHandler();

        if ((trashHandler == null) ||
                Validator.isNull(trashHandler.getContainerModelClassName())) {
            return false;
        }

        try {
            ContainerModel containerModel = trashHandler.getParentContainerModel(this);

            if (containerModel == null) {
                return false;
            }

            if (containerModel instanceof TrashedModel) {
                return ((TrashedModel) containerModel).isInTrash();
            }
        } catch (Exception e) {
        }

        return false;
    }

    public BaseModel<?> getMensajeRemoteModel() {
        return _mensajeRemoteModel;
    }

    public void setMensajeRemoteModel(BaseModel<?> mensajeRemoteModel) {
        _mensajeRemoteModel = mensajeRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _mensajeRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_mensajeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MensajeLocalServiceUtil.addMensaje(this);
        } else {
            MensajeLocalServiceUtil.updateMensaje(this);
        }
    }

    @Override
    public Mensaje toEscapedModel() {
        return (Mensaje) ProxyUtil.newProxyInstance(Mensaje.class.getClassLoader(),
            new Class[] { Mensaje.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MensajeClp clone = new MensajeClp();

        clone.setMensajeId(getMensajeId());
        clone.setAutor(getAutor());
        clone.setCreateDate(getCreateDate());
        clone.setContenido(getContenido());
        clone.setConversacionId(getConversacionId());

        return clone;
    }

    @Override
    public int compareTo(Mensaje mensaje) {
        long primaryKey = mensaje.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MensajeClp)) {
            return false;
        }

        MensajeClp mensaje = (MensajeClp) obj;

        long primaryKey = mensaje.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{mensajeId=");
        sb.append(getMensajeId());
        sb.append(", autor=");
        sb.append(getAutor());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", contenido=");
        sb.append(getContenido());
        sb.append(", conversacionId=");
        sb.append(getConversacionId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.proyecto.quental.chat.model.Mensaje");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>mensajeId</column-name><column-value><![CDATA[");
        sb.append(getMensajeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>autor</column-name><column-value><![CDATA[");
        sb.append(getAutor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contenido</column-name><column-value><![CDATA[");
        sb.append(getContenido());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conversacionId</column-name><column-value><![CDATA[");
        sb.append(getConversacionId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

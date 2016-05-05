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
import com.proyecto.quental.chat.service.ConversacionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ConversacionClp extends BaseModelImpl<Conversacion>
    implements Conversacion {
    private long _conversacionId;
    private String _nickName;
    private Date _createDate;
    private Date _finDate;
    private String _categoria;
    private String _descripcion;
    private String _etiquetas;
    private boolean _asignado;
    private boolean _cerrada;
    private BaseModel<?> _conversacionRemoteModel;
    private Class<?> _clpSerializerClass = com.proyecto.quental.chat.service.ClpSerializer.class;

    public ConversacionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Conversacion.class;
    }

    @Override
    public String getModelClassName() {
        return Conversacion.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _conversacionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setConversacionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _conversacionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("conversacionId", getConversacionId());
        attributes.put("nickName", getNickName());
        attributes.put("createDate", getCreateDate());
        attributes.put("finDate", getFinDate());
        attributes.put("categoria", getCategoria());
        attributes.put("descripcion", getDescripcion());
        attributes.put("etiquetas", getEtiquetas());
        attributes.put("asignado", getAsignado());
        attributes.put("cerrada", getCerrada());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long conversacionId = (Long) attributes.get("conversacionId");

        if (conversacionId != null) {
            setConversacionId(conversacionId);
        }

        String nickName = (String) attributes.get("nickName");

        if (nickName != null) {
            setNickName(nickName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date finDate = (Date) attributes.get("finDate");

        if (finDate != null) {
            setFinDate(finDate);
        }

        String categoria = (String) attributes.get("categoria");

        if (categoria != null) {
            setCategoria(categoria);
        }

        String descripcion = (String) attributes.get("descripcion");

        if (descripcion != null) {
            setDescripcion(descripcion);
        }

        String etiquetas = (String) attributes.get("etiquetas");

        if (etiquetas != null) {
            setEtiquetas(etiquetas);
        }

        Boolean asignado = (Boolean) attributes.get("asignado");

        if (asignado != null) {
            setAsignado(asignado);
        }

        Boolean cerrada = (Boolean) attributes.get("cerrada");

        if (cerrada != null) {
            setCerrada(cerrada);
        }
    }

    @Override
    public long getConversacionId() {
        return _conversacionId;
    }

    @Override
    public void setConversacionId(long conversacionId) {
        _conversacionId = conversacionId;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setConversacionId", long.class);

                method.invoke(_conversacionRemoteModel, conversacionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNickName() {
        return _nickName;
    }

    @Override
    public void setNickName(String nickName) {
        _nickName = nickName;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setNickName", String.class);

                method.invoke(_conversacionRemoteModel, nickName);
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

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_conversacionRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getFinDate() {
        return _finDate;
    }

    @Override
    public void setFinDate(Date finDate) {
        _finDate = finDate;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setFinDate", Date.class);

                method.invoke(_conversacionRemoteModel, finDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCategoria() {
        return _categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        _categoria = categoria;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setCategoria", String.class);

                method.invoke(_conversacionRemoteModel, categoria);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescripcion() {
        return _descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        _descripcion = descripcion;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setDescripcion", String.class);

                method.invoke(_conversacionRemoteModel, descripcion);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEtiquetas() {
        return _etiquetas;
    }

    @Override
    public void setEtiquetas(String etiquetas) {
        _etiquetas = etiquetas;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setEtiquetas", String.class);

                method.invoke(_conversacionRemoteModel, etiquetas);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getAsignado() {
        return _asignado;
    }

    @Override
    public boolean isAsignado() {
        return _asignado;
    }

    @Override
    public void setAsignado(boolean asignado) {
        _asignado = asignado;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setAsignado", boolean.class);

                method.invoke(_conversacionRemoteModel, asignado);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCerrada() {
        return _cerrada;
    }

    @Override
    public boolean isCerrada() {
        return _cerrada;
    }

    @Override
    public void setCerrada(boolean cerrada) {
        _cerrada = cerrada;

        if (_conversacionRemoteModel != null) {
            try {
                Class<?> clazz = _conversacionRemoteModel.getClass();

                Method method = clazz.getMethod("setCerrada", boolean.class);

                method.invoke(_conversacionRemoteModel, cerrada);
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

    public BaseModel<?> getConversacionRemoteModel() {
        return _conversacionRemoteModel;
    }

    public void setConversacionRemoteModel(BaseModel<?> conversacionRemoteModel) {
        _conversacionRemoteModel = conversacionRemoteModel;
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

        Class<?> remoteModelClass = _conversacionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_conversacionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ConversacionLocalServiceUtil.addConversacion(this);
        } else {
            ConversacionLocalServiceUtil.updateConversacion(this);
        }
    }

    @Override
    public Conversacion toEscapedModel() {
        return (Conversacion) ProxyUtil.newProxyInstance(Conversacion.class.getClassLoader(),
            new Class[] { Conversacion.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ConversacionClp clone = new ConversacionClp();

        clone.setConversacionId(getConversacionId());
        clone.setNickName(getNickName());
        clone.setCreateDate(getCreateDate());
        clone.setFinDate(getFinDate());
        clone.setCategoria(getCategoria());
        clone.setDescripcion(getDescripcion());
        clone.setEtiquetas(getEtiquetas());
        clone.setAsignado(getAsignado());
        clone.setCerrada(getCerrada());

        return clone;
    }

    @Override
    public int compareTo(Conversacion conversacion) {
        long primaryKey = conversacion.getPrimaryKey();

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

        if (!(obj instanceof ConversacionClp)) {
            return false;
        }

        ConversacionClp conversacion = (ConversacionClp) obj;

        long primaryKey = conversacion.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{conversacionId=");
        sb.append(getConversacionId());
        sb.append(", nickName=");
        sb.append(getNickName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", finDate=");
        sb.append(getFinDate());
        sb.append(", categoria=");
        sb.append(getCategoria());
        sb.append(", descripcion=");
        sb.append(getDescripcion());
        sb.append(", etiquetas=");
        sb.append(getEtiquetas());
        sb.append(", asignado=");
        sb.append(getAsignado());
        sb.append(", cerrada=");
        sb.append(getCerrada());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.proyecto.quental.chat.model.Conversacion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>conversacionId</column-name><column-value><![CDATA[");
        sb.append(getConversacionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nickName</column-name><column-value><![CDATA[");
        sb.append(getNickName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>finDate</column-name><column-value><![CDATA[");
        sb.append(getFinDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoria</column-name><column-value><![CDATA[");
        sb.append(getCategoria());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descripcion</column-name><column-value><![CDATA[");
        sb.append(getDescripcion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>etiquetas</column-name><column-value><![CDATA[");
        sb.append(getEtiquetas());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>asignado</column-name><column-value><![CDATA[");
        sb.append(getAsignado());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cerrada</column-name><column-value><![CDATA[");
        sb.append(getCerrada());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

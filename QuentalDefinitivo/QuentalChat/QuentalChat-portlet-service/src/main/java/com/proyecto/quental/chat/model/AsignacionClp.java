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
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;

import com.proyecto.quental.chat.service.AsignacionLocalServiceUtil;
import com.proyecto.quental.chat.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AsignacionClp extends BaseModelImpl<Asignacion>
    implements Asignacion {
    private long _asignacionId;
    private long _userId;
    private String _userUuid;
    private long _conversacionId;
    private BaseModel<?> _asignacionRemoteModel;
    private Class<?> _clpSerializerClass = com.proyecto.quental.chat.service.ClpSerializer.class;

    public AsignacionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Asignacion.class;
    }

    @Override
    public String getModelClassName() {
        return Asignacion.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _asignacionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAsignacionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _asignacionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("asignacionId", getAsignacionId());
        attributes.put("userId", getUserId());
        attributes.put("conversacionId", getConversacionId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long asignacionId = (Long) attributes.get("asignacionId");

        if (asignacionId != null) {
            setAsignacionId(asignacionId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long conversacionId = (Long) attributes.get("conversacionId");

        if (conversacionId != null) {
            setConversacionId(conversacionId);
        }
    }

    @Override
    public long getAsignacionId() {
        return _asignacionId;
    }

    @Override
    public void setAsignacionId(long asignacionId) {
        _asignacionId = asignacionId;

        if (_asignacionRemoteModel != null) {
            try {
                Class<?> clazz = _asignacionRemoteModel.getClass();

                Method method = clazz.getMethod("setAsignacionId", long.class);

                method.invoke(_asignacionRemoteModel, asignacionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_asignacionRemoteModel != null) {
            try {
                Class<?> clazz = _asignacionRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_asignacionRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public long getConversacionId() {
        return _conversacionId;
    }

    @Override
    public void setConversacionId(long conversacionId) {
        _conversacionId = conversacionId;

        if (_asignacionRemoteModel != null) {
            try {
                Class<?> clazz = _asignacionRemoteModel.getClass();

                Method method = clazz.getMethod("setConversacionId", long.class);

                method.invoke(_asignacionRemoteModel, conversacionId);
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

    public BaseModel<?> getAsignacionRemoteModel() {
        return _asignacionRemoteModel;
    }

    public void setAsignacionRemoteModel(BaseModel<?> asignacionRemoteModel) {
        _asignacionRemoteModel = asignacionRemoteModel;
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

        Class<?> remoteModelClass = _asignacionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_asignacionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AsignacionLocalServiceUtil.addAsignacion(this);
        } else {
            AsignacionLocalServiceUtil.updateAsignacion(this);
        }
    }

    @Override
    public Asignacion toEscapedModel() {
        return (Asignacion) ProxyUtil.newProxyInstance(Asignacion.class.getClassLoader(),
            new Class[] { Asignacion.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AsignacionClp clone = new AsignacionClp();

        clone.setAsignacionId(getAsignacionId());
        clone.setUserId(getUserId());
        clone.setConversacionId(getConversacionId());

        return clone;
    }

    @Override
    public int compareTo(Asignacion asignacion) {
        long primaryKey = asignacion.getPrimaryKey();

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

        if (!(obj instanceof AsignacionClp)) {
            return false;
        }

        AsignacionClp asignacion = (AsignacionClp) obj;

        long primaryKey = asignacion.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{asignacionId=");
        sb.append(getAsignacionId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", conversacionId=");
        sb.append(getConversacionId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.proyecto.quental.chat.model.Asignacion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>asignacionId</column-name><column-value><![CDATA[");
        sb.append(getAsignacionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conversacionId</column-name><column-value><![CDATA[");
        sb.append(getConversacionId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

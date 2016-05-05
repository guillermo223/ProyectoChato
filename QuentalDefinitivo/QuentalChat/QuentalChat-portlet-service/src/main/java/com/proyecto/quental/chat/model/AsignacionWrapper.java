package com.proyecto.quental.chat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Asignacion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Asignacion
 * @generated
 */
public class AsignacionWrapper implements Asignacion, ModelWrapper<Asignacion> {
    private Asignacion _asignacion;

    public AsignacionWrapper(Asignacion asignacion) {
        _asignacion = asignacion;
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

    /**
    * Returns the primary key of this asignacion.
    *
    * @return the primary key of this asignacion
    */
    @Override
    public long getPrimaryKey() {
        return _asignacion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this asignacion.
    *
    * @param primaryKey the primary key of this asignacion
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _asignacion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the asignacion ID of this asignacion.
    *
    * @return the asignacion ID of this asignacion
    */
    @Override
    public long getAsignacionId() {
        return _asignacion.getAsignacionId();
    }

    /**
    * Sets the asignacion ID of this asignacion.
    *
    * @param asignacionId the asignacion ID of this asignacion
    */
    @Override
    public void setAsignacionId(long asignacionId) {
        _asignacion.setAsignacionId(asignacionId);
    }

    /**
    * Returns the user ID of this asignacion.
    *
    * @return the user ID of this asignacion
    */
    @Override
    public long getUserId() {
        return _asignacion.getUserId();
    }

    /**
    * Sets the user ID of this asignacion.
    *
    * @param userId the user ID of this asignacion
    */
    @Override
    public void setUserId(long userId) {
        _asignacion.setUserId(userId);
    }

    /**
    * Returns the user uuid of this asignacion.
    *
    * @return the user uuid of this asignacion
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacion.getUserUuid();
    }

    /**
    * Sets the user uuid of this asignacion.
    *
    * @param userUuid the user uuid of this asignacion
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _asignacion.setUserUuid(userUuid);
    }

    /**
    * Returns the conversacion ID of this asignacion.
    *
    * @return the conversacion ID of this asignacion
    */
    @Override
    public long getConversacionId() {
        return _asignacion.getConversacionId();
    }

    /**
    * Sets the conversacion ID of this asignacion.
    *
    * @param conversacionId the conversacion ID of this asignacion
    */
    @Override
    public void setConversacionId(long conversacionId) {
        _asignacion.setConversacionId(conversacionId);
    }

    /**
    * Returns the status of this asignacion.
    *
    * @return the status of this asignacion
    */
    @Override
    public int getStatus() {
        return _asignacion.getStatus();
    }

    /**
    * Returns the trash entry created when this asignacion was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this asignacion.
    *
    * @return the trash entry created when this asignacion was moved to the Recycle Bin
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _asignacion.getTrashEntry();
    }

    /**
    * Returns the class primary key of the trash entry for this asignacion.
    *
    * @return the class primary key of the trash entry for this asignacion
    */
    @Override
    public long getTrashEntryClassPK() {
        return _asignacion.getTrashEntryClassPK();
    }

    /**
    * Returns the trash handler for this asignacion.
    *
    * @return the trash handler for this asignacion
    */
    @Override
    public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
        return _asignacion.getTrashHandler();
    }

    /**
    * Returns <code>true</code> if this asignacion is in the Recycle Bin.
    *
    * @return <code>true</code> if this asignacion is in the Recycle Bin; <code>false</code> otherwise
    */
    @Override
    public boolean isInTrash() {
        return _asignacion.isInTrash();
    }

    /**
    * Returns <code>true</code> if the parent of this asignacion is in the Recycle Bin.
    *
    * @return <code>true</code> if the parent of this asignacion is in the Recycle Bin; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean isInTrashContainer() {
        return _asignacion.isInTrashContainer();
    }

    @Override
    public boolean isNew() {
        return _asignacion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _asignacion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _asignacion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _asignacion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _asignacion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _asignacion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _asignacion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _asignacion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _asignacion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _asignacion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _asignacion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AsignacionWrapper((Asignacion) _asignacion.clone());
    }

    @Override
    public int compareTo(com.proyecto.quental.chat.model.Asignacion asignacion) {
        return _asignacion.compareTo(asignacion);
    }

    @Override
    public int hashCode() {
        return _asignacion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.proyecto.quental.chat.model.Asignacion> toCacheModel() {
        return _asignacion.toCacheModel();
    }

    @Override
    public com.proyecto.quental.chat.model.Asignacion toEscapedModel() {
        return new AsignacionWrapper(_asignacion.toEscapedModel());
    }

    @Override
    public com.proyecto.quental.chat.model.Asignacion toUnescapedModel() {
        return new AsignacionWrapper(_asignacion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _asignacion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _asignacion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _asignacion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AsignacionWrapper)) {
            return false;
        }

        AsignacionWrapper asignacionWrapper = (AsignacionWrapper) obj;

        if (Validator.equals(_asignacion, asignacionWrapper._asignacion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Asignacion getWrappedAsignacion() {
        return _asignacion;
    }

    @Override
    public Asignacion getWrappedModel() {
        return _asignacion;
    }

    @Override
    public void resetOriginalValues() {
        _asignacion.resetOriginalValues();
    }
}

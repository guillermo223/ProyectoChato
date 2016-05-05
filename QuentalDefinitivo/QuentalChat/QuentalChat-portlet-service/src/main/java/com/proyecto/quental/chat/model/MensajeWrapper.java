package com.proyecto.quental.chat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Mensaje}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Mensaje
 * @generated
 */
public class MensajeWrapper implements Mensaje, ModelWrapper<Mensaje> {
    private Mensaje _mensaje;

    public MensajeWrapper(Mensaje mensaje) {
        _mensaje = mensaje;
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

    /**
    * Returns the primary key of this mensaje.
    *
    * @return the primary key of this mensaje
    */
    @Override
    public long getPrimaryKey() {
        return _mensaje.getPrimaryKey();
    }

    /**
    * Sets the primary key of this mensaje.
    *
    * @param primaryKey the primary key of this mensaje
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _mensaje.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the mensaje ID of this mensaje.
    *
    * @return the mensaje ID of this mensaje
    */
    @Override
    public long getMensajeId() {
        return _mensaje.getMensajeId();
    }

    /**
    * Sets the mensaje ID of this mensaje.
    *
    * @param mensajeId the mensaje ID of this mensaje
    */
    @Override
    public void setMensajeId(long mensajeId) {
        _mensaje.setMensajeId(mensajeId);
    }

    /**
    * Returns the autor of this mensaje.
    *
    * @return the autor of this mensaje
    */
    @Override
    public java.lang.String getAutor() {
        return _mensaje.getAutor();
    }

    /**
    * Sets the autor of this mensaje.
    *
    * @param autor the autor of this mensaje
    */
    @Override
    public void setAutor(java.lang.String autor) {
        _mensaje.setAutor(autor);
    }

    /**
    * Returns the create date of this mensaje.
    *
    * @return the create date of this mensaje
    */
    @Override
    public java.util.Date getCreateDate() {
        return _mensaje.getCreateDate();
    }

    /**
    * Sets the create date of this mensaje.
    *
    * @param createDate the create date of this mensaje
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _mensaje.setCreateDate(createDate);
    }

    /**
    * Returns the contenido of this mensaje.
    *
    * @return the contenido of this mensaje
    */
    @Override
    public java.lang.String getContenido() {
        return _mensaje.getContenido();
    }

    /**
    * Sets the contenido of this mensaje.
    *
    * @param contenido the contenido of this mensaje
    */
    @Override
    public void setContenido(java.lang.String contenido) {
        _mensaje.setContenido(contenido);
    }

    /**
    * Returns the conversacion ID of this mensaje.
    *
    * @return the conversacion ID of this mensaje
    */
    @Override
    public long getConversacionId() {
        return _mensaje.getConversacionId();
    }

    /**
    * Sets the conversacion ID of this mensaje.
    *
    * @param conversacionId the conversacion ID of this mensaje
    */
    @Override
    public void setConversacionId(long conversacionId) {
        _mensaje.setConversacionId(conversacionId);
    }

    /**
    * Returns the status of this mensaje.
    *
    * @return the status of this mensaje
    */
    @Override
    public int getStatus() {
        return _mensaje.getStatus();
    }

    /**
    * Returns the trash entry created when this mensaje was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this mensaje.
    *
    * @return the trash entry created when this mensaje was moved to the Recycle Bin
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mensaje.getTrashEntry();
    }

    /**
    * Returns the class primary key of the trash entry for this mensaje.
    *
    * @return the class primary key of the trash entry for this mensaje
    */
    @Override
    public long getTrashEntryClassPK() {
        return _mensaje.getTrashEntryClassPK();
    }

    /**
    * Returns the trash handler for this mensaje.
    *
    * @return the trash handler for this mensaje
    */
    @Override
    public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
        return _mensaje.getTrashHandler();
    }

    /**
    * Returns <code>true</code> if this mensaje is in the Recycle Bin.
    *
    * @return <code>true</code> if this mensaje is in the Recycle Bin; <code>false</code> otherwise
    */
    @Override
    public boolean isInTrash() {
        return _mensaje.isInTrash();
    }

    /**
    * Returns <code>true</code> if the parent of this mensaje is in the Recycle Bin.
    *
    * @return <code>true</code> if the parent of this mensaje is in the Recycle Bin; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean isInTrashContainer() {
        return _mensaje.isInTrashContainer();
    }

    @Override
    public boolean isNew() {
        return _mensaje.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _mensaje.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _mensaje.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _mensaje.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _mensaje.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _mensaje.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _mensaje.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _mensaje.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _mensaje.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _mensaje.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _mensaje.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MensajeWrapper((Mensaje) _mensaje.clone());
    }

    @Override
    public int compareTo(com.proyecto.quental.chat.model.Mensaje mensaje) {
        return _mensaje.compareTo(mensaje);
    }

    @Override
    public int hashCode() {
        return _mensaje.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.proyecto.quental.chat.model.Mensaje> toCacheModel() {
        return _mensaje.toCacheModel();
    }

    @Override
    public com.proyecto.quental.chat.model.Mensaje toEscapedModel() {
        return new MensajeWrapper(_mensaje.toEscapedModel());
    }

    @Override
    public com.proyecto.quental.chat.model.Mensaje toUnescapedModel() {
        return new MensajeWrapper(_mensaje.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _mensaje.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _mensaje.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _mensaje.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MensajeWrapper)) {
            return false;
        }

        MensajeWrapper mensajeWrapper = (MensajeWrapper) obj;

        if (Validator.equals(_mensaje, mensajeWrapper._mensaje)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Mensaje getWrappedMensaje() {
        return _mensaje;
    }

    @Override
    public Mensaje getWrappedModel() {
        return _mensaje;
    }

    @Override
    public void resetOriginalValues() {
        _mensaje.resetOriginalValues();
    }
}

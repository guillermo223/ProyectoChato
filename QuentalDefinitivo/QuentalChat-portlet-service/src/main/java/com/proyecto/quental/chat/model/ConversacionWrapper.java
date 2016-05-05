package com.proyecto.quental.chat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Conversacion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Conversacion
 * @generated
 */
public class ConversacionWrapper implements Conversacion,
    ModelWrapper<Conversacion> {
    private Conversacion _conversacion;

    public ConversacionWrapper(Conversacion conversacion) {
        _conversacion = conversacion;
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

    /**
    * Returns the primary key of this conversacion.
    *
    * @return the primary key of this conversacion
    */
    @Override
    public long getPrimaryKey() {
        return _conversacion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this conversacion.
    *
    * @param primaryKey the primary key of this conversacion
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _conversacion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the conversacion ID of this conversacion.
    *
    * @return the conversacion ID of this conversacion
    */
    @Override
    public long getConversacionId() {
        return _conversacion.getConversacionId();
    }

    /**
    * Sets the conversacion ID of this conversacion.
    *
    * @param conversacionId the conversacion ID of this conversacion
    */
    @Override
    public void setConversacionId(long conversacionId) {
        _conversacion.setConversacionId(conversacionId);
    }

    /**
    * Returns the nick name of this conversacion.
    *
    * @return the nick name of this conversacion
    */
    @Override
    public java.lang.String getNickName() {
        return _conversacion.getNickName();
    }

    /**
    * Sets the nick name of this conversacion.
    *
    * @param nickName the nick name of this conversacion
    */
    @Override
    public void setNickName(java.lang.String nickName) {
        _conversacion.setNickName(nickName);
    }

    /**
    * Returns the create date of this conversacion.
    *
    * @return the create date of this conversacion
    */
    @Override
    public java.util.Date getCreateDate() {
        return _conversacion.getCreateDate();
    }

    /**
    * Sets the create date of this conversacion.
    *
    * @param createDate the create date of this conversacion
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _conversacion.setCreateDate(createDate);
    }

    /**
    * Returns the fin date of this conversacion.
    *
    * @return the fin date of this conversacion
    */
    @Override
    public java.util.Date getFinDate() {
        return _conversacion.getFinDate();
    }

    /**
    * Sets the fin date of this conversacion.
    *
    * @param finDate the fin date of this conversacion
    */
    @Override
    public void setFinDate(java.util.Date finDate) {
        _conversacion.setFinDate(finDate);
    }

    /**
    * Returns the categoria of this conversacion.
    *
    * @return the categoria of this conversacion
    */
    @Override
    public java.lang.String getCategoria() {
        return _conversacion.getCategoria();
    }

    /**
    * Sets the categoria of this conversacion.
    *
    * @param categoria the categoria of this conversacion
    */
    @Override
    public void setCategoria(java.lang.String categoria) {
        _conversacion.setCategoria(categoria);
    }

    /**
    * Returns the descripcion of this conversacion.
    *
    * @return the descripcion of this conversacion
    */
    @Override
    public java.lang.String getDescripcion() {
        return _conversacion.getDescripcion();
    }

    /**
    * Sets the descripcion of this conversacion.
    *
    * @param descripcion the descripcion of this conversacion
    */
    @Override
    public void setDescripcion(java.lang.String descripcion) {
        _conversacion.setDescripcion(descripcion);
    }

    /**
    * Returns the etiquetas of this conversacion.
    *
    * @return the etiquetas of this conversacion
    */
    @Override
    public java.lang.String getEtiquetas() {
        return _conversacion.getEtiquetas();
    }

    /**
    * Sets the etiquetas of this conversacion.
    *
    * @param etiquetas the etiquetas of this conversacion
    */
    @Override
    public void setEtiquetas(java.lang.String etiquetas) {
        _conversacion.setEtiquetas(etiquetas);
    }

    /**
    * Returns the asignado of this conversacion.
    *
    * @return the asignado of this conversacion
    */
    @Override
    public boolean getAsignado() {
        return _conversacion.getAsignado();
    }

    /**
    * Returns <code>true</code> if this conversacion is asignado.
    *
    * @return <code>true</code> if this conversacion is asignado; <code>false</code> otherwise
    */
    @Override
    public boolean isAsignado() {
        return _conversacion.isAsignado();
    }

    /**
    * Sets whether this conversacion is asignado.
    *
    * @param asignado the asignado of this conversacion
    */
    @Override
    public void setAsignado(boolean asignado) {
        _conversacion.setAsignado(asignado);
    }

    /**
    * Returns the cerrada of this conversacion.
    *
    * @return the cerrada of this conversacion
    */
    @Override
    public boolean getCerrada() {
        return _conversacion.getCerrada();
    }

    /**
    * Returns <code>true</code> if this conversacion is cerrada.
    *
    * @return <code>true</code> if this conversacion is cerrada; <code>false</code> otherwise
    */
    @Override
    public boolean isCerrada() {
        return _conversacion.isCerrada();
    }

    /**
    * Sets whether this conversacion is cerrada.
    *
    * @param cerrada the cerrada of this conversacion
    */
    @Override
    public void setCerrada(boolean cerrada) {
        _conversacion.setCerrada(cerrada);
    }

    /**
    * Returns the status of this conversacion.
    *
    * @return the status of this conversacion
    */
    @Override
    public int getStatus() {
        return _conversacion.getStatus();
    }

    /**
    * Returns the trash entry created when this conversacion was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this conversacion.
    *
    * @return the trash entry created when this conversacion was moved to the Recycle Bin
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _conversacion.getTrashEntry();
    }

    /**
    * Returns the class primary key of the trash entry for this conversacion.
    *
    * @return the class primary key of the trash entry for this conversacion
    */
    @Override
    public long getTrashEntryClassPK() {
        return _conversacion.getTrashEntryClassPK();
    }

    /**
    * Returns the trash handler for this conversacion.
    *
    * @return the trash handler for this conversacion
    */
    @Override
    public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
        return _conversacion.getTrashHandler();
    }

    /**
    * Returns <code>true</code> if this conversacion is in the Recycle Bin.
    *
    * @return <code>true</code> if this conversacion is in the Recycle Bin; <code>false</code> otherwise
    */
    @Override
    public boolean isInTrash() {
        return _conversacion.isInTrash();
    }

    /**
    * Returns <code>true</code> if the parent of this conversacion is in the Recycle Bin.
    *
    * @return <code>true</code> if the parent of this conversacion is in the Recycle Bin; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean isInTrashContainer() {
        return _conversacion.isInTrashContainer();
    }

    @Override
    public boolean isNew() {
        return _conversacion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _conversacion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _conversacion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _conversacion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _conversacion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _conversacion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _conversacion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _conversacion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _conversacion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _conversacion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _conversacion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ConversacionWrapper((Conversacion) _conversacion.clone());
    }

    @Override
    public int compareTo(
        com.proyecto.quental.chat.model.Conversacion conversacion) {
        return _conversacion.compareTo(conversacion);
    }

    @Override
    public int hashCode() {
        return _conversacion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.proyecto.quental.chat.model.Conversacion> toCacheModel() {
        return _conversacion.toCacheModel();
    }

    @Override
    public com.proyecto.quental.chat.model.Conversacion toEscapedModel() {
        return new ConversacionWrapper(_conversacion.toEscapedModel());
    }

    @Override
    public com.proyecto.quental.chat.model.Conversacion toUnescapedModel() {
        return new ConversacionWrapper(_conversacion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _conversacion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _conversacion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _conversacion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ConversacionWrapper)) {
            return false;
        }

        ConversacionWrapper conversacionWrapper = (ConversacionWrapper) obj;

        if (Validator.equals(_conversacion, conversacionWrapper._conversacion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Conversacion getWrappedConversacion() {
        return _conversacion;
    }

    @Override
    public Conversacion getWrappedModel() {
        return _conversacion;
    }

    @Override
    public void resetOriginalValues() {
        _conversacion.resetOriginalValues();
    }
}

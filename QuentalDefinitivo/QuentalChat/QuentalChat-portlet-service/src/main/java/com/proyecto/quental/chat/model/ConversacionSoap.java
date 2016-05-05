package com.proyecto.quental.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.proyecto.quental.chat.service.http.ConversacionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.http.ConversacionServiceSoap
 * @generated
 */
public class ConversacionSoap implements Serializable {
    private long _conversacionId;
    private String _nickName;
    private Date _createDate;
    private Date _finDate;
    private String _categoria;
    private String _descripcion;
    private String _etiquetas;
    private boolean _asignado;
    private boolean _cerrada;

    public ConversacionSoap() {
    }

    public static ConversacionSoap toSoapModel(Conversacion model) {
        ConversacionSoap soapModel = new ConversacionSoap();

        soapModel.setConversacionId(model.getConversacionId());
        soapModel.setNickName(model.getNickName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setFinDate(model.getFinDate());
        soapModel.setCategoria(model.getCategoria());
        soapModel.setDescripcion(model.getDescripcion());
        soapModel.setEtiquetas(model.getEtiquetas());
        soapModel.setAsignado(model.getAsignado());
        soapModel.setCerrada(model.getCerrada());

        return soapModel;
    }

    public static ConversacionSoap[] toSoapModels(Conversacion[] models) {
        ConversacionSoap[] soapModels = new ConversacionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ConversacionSoap[][] toSoapModels(Conversacion[][] models) {
        ConversacionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ConversacionSoap[models.length][models[0].length];
        } else {
            soapModels = new ConversacionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ConversacionSoap[] toSoapModels(List<Conversacion> models) {
        List<ConversacionSoap> soapModels = new ArrayList<ConversacionSoap>(models.size());

        for (Conversacion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ConversacionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _conversacionId;
    }

    public void setPrimaryKey(long pk) {
        setConversacionId(pk);
    }

    public long getConversacionId() {
        return _conversacionId;
    }

    public void setConversacionId(long conversacionId) {
        _conversacionId = conversacionId;
    }

    public String getNickName() {
        return _nickName;
    }

    public void setNickName(String nickName) {
        _nickName = nickName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getFinDate() {
        return _finDate;
    }

    public void setFinDate(Date finDate) {
        _finDate = finDate;
    }

    public String getCategoria() {
        return _categoria;
    }

    public void setCategoria(String categoria) {
        _categoria = categoria;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String descripcion) {
        _descripcion = descripcion;
    }

    public String getEtiquetas() {
        return _etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        _etiquetas = etiquetas;
    }

    public boolean getAsignado() {
        return _asignado;
    }

    public boolean isAsignado() {
        return _asignado;
    }

    public void setAsignado(boolean asignado) {
        _asignado = asignado;
    }

    public boolean getCerrada() {
        return _cerrada;
    }

    public boolean isCerrada() {
        return _cerrada;
    }

    public void setCerrada(boolean cerrada) {
        _cerrada = cerrada;
    }
}

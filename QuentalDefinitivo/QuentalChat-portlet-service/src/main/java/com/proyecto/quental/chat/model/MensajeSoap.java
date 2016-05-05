package com.proyecto.quental.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.proyecto.quental.chat.service.http.MensajeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.http.MensajeServiceSoap
 * @generated
 */
public class MensajeSoap implements Serializable {
    private long _mensajeId;
    private String _autor;
    private Date _createDate;
    private String _contenido;
    private long _conversacionId;

    public MensajeSoap() {
    }

    public static MensajeSoap toSoapModel(Mensaje model) {
        MensajeSoap soapModel = new MensajeSoap();

        soapModel.setMensajeId(model.getMensajeId());
        soapModel.setAutor(model.getAutor());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setContenido(model.getContenido());
        soapModel.setConversacionId(model.getConversacionId());

        return soapModel;
    }

    public static MensajeSoap[] toSoapModels(Mensaje[] models) {
        MensajeSoap[] soapModels = new MensajeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MensajeSoap[][] toSoapModels(Mensaje[][] models) {
        MensajeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MensajeSoap[models.length][models[0].length];
        } else {
            soapModels = new MensajeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MensajeSoap[] toSoapModels(List<Mensaje> models) {
        List<MensajeSoap> soapModels = new ArrayList<MensajeSoap>(models.size());

        for (Mensaje model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MensajeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mensajeId;
    }

    public void setPrimaryKey(long pk) {
        setMensajeId(pk);
    }

    public long getMensajeId() {
        return _mensajeId;
    }

    public void setMensajeId(long mensajeId) {
        _mensajeId = mensajeId;
    }

    public String getAutor() {
        return _autor;
    }

    public void setAutor(String autor) {
        _autor = autor;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public String getContenido() {
        return _contenido;
    }

    public void setContenido(String contenido) {
        _contenido = contenido;
    }

    public long getConversacionId() {
        return _conversacionId;
    }

    public void setConversacionId(long conversacionId) {
        _conversacionId = conversacionId;
    }
}

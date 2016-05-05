package com.proyecto.quental.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.proyecto.quental.chat.service.http.AsignacionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.http.AsignacionServiceSoap
 * @generated
 */
public class AsignacionSoap implements Serializable {
    private long _asignacionId;
    private long _userId;
    private long _conversacionId;

    public AsignacionSoap() {
    }

    public static AsignacionSoap toSoapModel(Asignacion model) {
        AsignacionSoap soapModel = new AsignacionSoap();

        soapModel.setAsignacionId(model.getAsignacionId());
        soapModel.setUserId(model.getUserId());
        soapModel.setConversacionId(model.getConversacionId());

        return soapModel;
    }

    public static AsignacionSoap[] toSoapModels(Asignacion[] models) {
        AsignacionSoap[] soapModels = new AsignacionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AsignacionSoap[][] toSoapModels(Asignacion[][] models) {
        AsignacionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AsignacionSoap[models.length][models[0].length];
        } else {
            soapModels = new AsignacionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AsignacionSoap[] toSoapModels(List<Asignacion> models) {
        List<AsignacionSoap> soapModels = new ArrayList<AsignacionSoap>(models.size());

        for (Asignacion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AsignacionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _asignacionId;
    }

    public void setPrimaryKey(long pk) {
        setAsignacionId(pk);
    }

    public long getAsignacionId() {
        return _asignacionId;
    }

    public void setAsignacionId(long asignacionId) {
        _asignacionId = asignacionId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getConversacionId() {
        return _conversacionId;
    }

    public void setConversacionId(long conversacionId) {
        _conversacionId = conversacionId;
    }
}

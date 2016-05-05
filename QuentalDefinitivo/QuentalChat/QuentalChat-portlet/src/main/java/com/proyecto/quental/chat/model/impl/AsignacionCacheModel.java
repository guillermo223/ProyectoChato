package com.proyecto.quental.chat.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.proyecto.quental.chat.model.Asignacion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Asignacion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Asignacion
 * @generated
 */
public class AsignacionCacheModel implements CacheModel<Asignacion>,
    Externalizable {
    public long asignacionId;
    public long userId;
    public long conversacionId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{asignacionId=");
        sb.append(asignacionId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", conversacionId=");
        sb.append(conversacionId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Asignacion toEntityModel() {
        AsignacionImpl asignacionImpl = new AsignacionImpl();

        asignacionImpl.setAsignacionId(asignacionId);
        asignacionImpl.setUserId(userId);
        asignacionImpl.setConversacionId(conversacionId);

        asignacionImpl.resetOriginalValues();

        return asignacionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        asignacionId = objectInput.readLong();
        userId = objectInput.readLong();
        conversacionId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(asignacionId);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(conversacionId);
    }
}

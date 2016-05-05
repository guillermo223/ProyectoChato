package com.proyecto.quental.chat.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.proyecto.quental.chat.model.Conversacion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Conversacion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Conversacion
 * @generated
 */
public class ConversacionCacheModel implements CacheModel<Conversacion>,
    Externalizable {
    public long conversacionId;
    public String nickName;
    public long createDate;
    public long finDate;
    public String categoria;
    public String descripcion;
    public String etiquetas;
    public boolean asignado;
    public boolean cerrada;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{conversacionId=");
        sb.append(conversacionId);
        sb.append(", nickName=");
        sb.append(nickName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", finDate=");
        sb.append(finDate);
        sb.append(", categoria=");
        sb.append(categoria);
        sb.append(", descripcion=");
        sb.append(descripcion);
        sb.append(", etiquetas=");
        sb.append(etiquetas);
        sb.append(", asignado=");
        sb.append(asignado);
        sb.append(", cerrada=");
        sb.append(cerrada);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Conversacion toEntityModel() {
        ConversacionImpl conversacionImpl = new ConversacionImpl();

        conversacionImpl.setConversacionId(conversacionId);

        if (nickName == null) {
            conversacionImpl.setNickName(StringPool.BLANK);
        } else {
            conversacionImpl.setNickName(nickName);
        }

        if (createDate == Long.MIN_VALUE) {
            conversacionImpl.setCreateDate(null);
        } else {
            conversacionImpl.setCreateDate(new Date(createDate));
        }

        if (finDate == Long.MIN_VALUE) {
            conversacionImpl.setFinDate(null);
        } else {
            conversacionImpl.setFinDate(new Date(finDate));
        }

        if (categoria == null) {
            conversacionImpl.setCategoria(StringPool.BLANK);
        } else {
            conversacionImpl.setCategoria(categoria);
        }

        if (descripcion == null) {
            conversacionImpl.setDescripcion(StringPool.BLANK);
        } else {
            conversacionImpl.setDescripcion(descripcion);
        }

        if (etiquetas == null) {
            conversacionImpl.setEtiquetas(StringPool.BLANK);
        } else {
            conversacionImpl.setEtiquetas(etiquetas);
        }

        conversacionImpl.setAsignado(asignado);
        conversacionImpl.setCerrada(cerrada);

        conversacionImpl.resetOriginalValues();

        return conversacionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        conversacionId = objectInput.readLong();
        nickName = objectInput.readUTF();
        createDate = objectInput.readLong();
        finDate = objectInput.readLong();
        categoria = objectInput.readUTF();
        descripcion = objectInput.readUTF();
        etiquetas = objectInput.readUTF();
        asignado = objectInput.readBoolean();
        cerrada = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(conversacionId);

        if (nickName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(nickName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(finDate);

        if (categoria == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(categoria);
        }

        if (descripcion == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(descripcion);
        }

        if (etiquetas == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(etiquetas);
        }

        objectOutput.writeBoolean(asignado);
        objectOutput.writeBoolean(cerrada);
    }
}

package com.proyecto.quental.chat.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.proyecto.quental.chat.model.Mensaje;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Mensaje in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Mensaje
 * @generated
 */
public class MensajeCacheModel implements CacheModel<Mensaje>, Externalizable {
    public long mensajeId;
    public String autor;
    public long createDate;
    public String contenido;
    public long conversacionId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{mensajeId=");
        sb.append(mensajeId);
        sb.append(", autor=");
        sb.append(autor);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", contenido=");
        sb.append(contenido);
        sb.append(", conversacionId=");
        sb.append(conversacionId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Mensaje toEntityModel() {
        MensajeImpl mensajeImpl = new MensajeImpl();

        mensajeImpl.setMensajeId(mensajeId);

        if (autor == null) {
            mensajeImpl.setAutor(StringPool.BLANK);
        } else {
            mensajeImpl.setAutor(autor);
        }

        if (createDate == Long.MIN_VALUE) {
            mensajeImpl.setCreateDate(null);
        } else {
            mensajeImpl.setCreateDate(new Date(createDate));
        }

        if (contenido == null) {
            mensajeImpl.setContenido(StringPool.BLANK);
        } else {
            mensajeImpl.setContenido(contenido);
        }

        mensajeImpl.setConversacionId(conversacionId);

        mensajeImpl.resetOriginalValues();

        return mensajeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        mensajeId = objectInput.readLong();
        autor = objectInput.readUTF();
        createDate = objectInput.readLong();
        contenido = objectInput.readUTF();
        conversacionId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(mensajeId);

        if (autor == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(autor);
        }

        objectOutput.writeLong(createDate);

        if (contenido == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contenido);
        }

        objectOutput.writeLong(conversacionId);
    }
}

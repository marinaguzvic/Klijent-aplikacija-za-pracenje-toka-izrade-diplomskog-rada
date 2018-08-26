/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import javax.servlet.http.Part;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;

/**
 *
 * @author Marina Guzvic
 */
public class DokumentClient extends RestClient {

    @Override
    public String getDomain() {
        return "/diplomskirads/{0}/dokuments";
    }

    @Override
    public Class getType() {
        return byte[].class;
    }

    public AbstractDTO post(Long diplomskiRadID, File fileEntity) throws Exception {
        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart(fileEntity.getName(), fileEntity, MediaType.APPLICATION_OCTET_STREAM_TYPE);
        fileDataBodyPart.setContentDisposition(
                FormDataContentDisposition.name("file")
                        .fileName(fileEntity.getName()).build());
        MultiPart multiPart = new FormDataMultiPart().bodyPart(fileDataBodyPart);
        ClientConfig config = new DefaultClientConfig();
        Client clientUpload = Client.create(config);
        WebResource resource = clientUpload.resource(BASE_URI + java.text.MessageFormat.format(getDomain(), new Object[]{diplomskiRadID}));

        ClientResponse response = resource
                .type("multipart/form-data").post(ClientResponse.class,
                multiPart);
        try {
            AbstractDTO dtoRet = (AbstractDTO) response.getEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public byte[] get(Long diplomskiRadID, Long dokumentId) throws Exception {
        try {
            byte[] doc = webTarget.path(java.text.MessageFormat.format(getDomain(), new Object[]{diplomskiRadID})).request().accept(MediaType.APPLICATION_OCTET_STREAM).get().readEntity(byte[].class);
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska kod getovanja dokumenta");
        }
    }

    @Override
    public GenericType getCollectionType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

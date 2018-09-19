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
import java.io.File;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DokumentDownloadDTO;

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
    
    public DokumentDownloadDTO get(Long diplomskiRadId,Integer rb) throws Exception{
         try {
            return (DokumentDownloadDTO) webTarget.path("/diplomskirads/" + diplomskiRadId + "/dokuments/" + rb).request().get().readEntity(DokumentDownloadDTO.class);
        } catch (Exception e) {
            throw new Exception("Greška prilikom čitanja sa servera");
        }
    }

    public AbstractDTO delete(Long diplomskiRadId,Integer rb) throws Exception {
        Response response = webTarget.path("/diplomskirads/" + diplomskiRadId + "/dokuments/" + rb).request().delete();
        try {
            AbstractDTO dtoRet = (AbstractDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }
    
    


    @Override
    public GenericType getCollectionType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ISearchDTO;

/**
 *
 * @author Marina Guzvic
 */
public abstract class RestClient {
    
    protected WebTarget webTarget;
    protected Client client;
    protected static final String BASE_URI = "http://localhost:8080";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public abstract String getDomain();
    public AbstractDTO get(String id) throws Exception{
        try {
            return (AbstractDTO) webTarget.path(java.text.MessageFormat.format(getDomain() + "/{0}", new Object[]{id})).request().get().readEntity(getType());
        } catch (Exception e) {
            throw new Exception("Greška prilikom čitanja sa servera");
        }
        
    }
    
    public List<AbstractDTO> getAll() throws Exception{
        try {
            return (List<AbstractDTO>) webTarget.path(getDomain()).request().get().readEntity(getCollectionType());
        } catch (Exception e) {
            throw new Exception("Greška prilikom čitanja sa servera");
        }
        
    }
    
    public AbstractDTO post(AbstractDTO dto) throws Exception{
        Response response = webTarget.path(getDomain()).request().post(Entity.json(dto));
        try {
            AbstractDTO dtoRet = (AbstractDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    
    }
    
    public AbstractDTO put(AbstractDTO dto,String id) throws Exception{
        Response response = webTarget.path(java.text.MessageFormat.format(getDomain() + "/{0}", new Object[]{id})).request().put(Entity.json(dto));
        try {
            AbstractDTO dtoRet = (AbstractDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            throw new Exception("Greska!\n" + e.getMessage());
        }
    
    }
    
    public AbstractDTO delete(String id) throws Exception{
        Response response = webTarget.path(java.text.MessageFormat.format(getDomain() + "/{0}", new Object[]{id})).request().delete();
        try {
            AbstractDTO dtoRet = (AbstractDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }
    
        public List<AbstractDTO> search(ISearchDTO dto) throws Exception {
        Response response = webTarget.path(getDomain() + "/search").request().post(Entity.json(dto));
        try {
            return (List<AbstractDTO>) response.readEntity(getCollectionType());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }
    
    public abstract Class getType();
    public abstract GenericType getCollectionType();
}

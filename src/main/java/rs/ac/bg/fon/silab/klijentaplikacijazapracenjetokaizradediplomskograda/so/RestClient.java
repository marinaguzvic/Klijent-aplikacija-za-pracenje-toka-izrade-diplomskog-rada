/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;

/**
 *
 * @author Marina Guzvic
 */
public abstract class RestClient {
    
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080";

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
    
    public AbstractDTO post(AbstractDTO dto) throws Exception{
        Response response = webTarget.request().post(Entity.json(dto));
        try {
            AbstractDTO dtoRet = (AbstractDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            throw new Exception("Greska!\n" + e.getMessage());
        }
    
    }
    
    public abstract Class getType();
}

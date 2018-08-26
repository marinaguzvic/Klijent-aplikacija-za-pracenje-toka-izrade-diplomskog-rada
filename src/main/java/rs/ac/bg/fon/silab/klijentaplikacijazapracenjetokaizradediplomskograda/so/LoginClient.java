/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NalogDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.RadnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import sun.security.provider.certpath.OCSPResponse;

/**
 *
 * @author Marina Guzvic
 */
public class LoginClient extends RestClient{
    
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/authenticate";

    public LoginClient() {
        Client client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public ClanSistemaDTO login(NalogDTO nalog) throws Exception{
        Response response = webTarget.request().post(Entity.json(nalog));
        try {
            //(response.getStatus()!= 201) throw new Exception("Greska!\n" + response.getStatusInfo());
            ClanSistemaDTO clan;
            response.bufferEntity();
            clan = response.readEntity(ClanSistemaDTO.class);
            switch(clan.getTipClana()){
                case 'S':
                    return response.readEntity(StudentDTO.class);
                case 'N':
                   return response.readEntity(NastavnikDTO.class);
                  case 'R':
                    return response.readEntity(RadnikDTO.class);
            }
             throw new Exception("Greska!\n" );
        } catch (Exception e) {
            throw new Exception("Greska!\n" + e.getMessage());
        }
        //throw new Exception("Greska!\n" +"Neodgovarajuci tip");
    }

    @Override
    public String getDomain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GenericType getCollectionType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

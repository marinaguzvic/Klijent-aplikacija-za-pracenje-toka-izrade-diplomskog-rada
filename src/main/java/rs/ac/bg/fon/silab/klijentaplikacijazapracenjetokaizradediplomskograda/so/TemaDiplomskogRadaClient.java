/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import java.util.List;
import javax.ws.rs.core.GenericType;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;

/**
 *
 * @author Marina Guzvic
 */
public class TemaDiplomskogRadaClient extends RestClient{

    @Override
    public String getDomain() {
        return "/temadiplomskogradas";
    }

    @Override
    public Class getType() {
        return TemaDiplomskogRadaDTO.class;
    }

    @Override
    public GenericType getCollectionType() {
        return new GenericType<List<TemaDiplomskogRadaDTO>>(){};
    }
    

    public List<TemaDiplomskogRadaDTO> getFreeTemas() throws Exception {
        try {
            return (List<TemaDiplomskogRadaDTO>) webTarget.path(getDomain() + "/free").request().get().readEntity(getCollectionType());
        } catch (Exception e) {
            throw new Exception("Greška prilikom čitanja sa servera");
        }
    }
}

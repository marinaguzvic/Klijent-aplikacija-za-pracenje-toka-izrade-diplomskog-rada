/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import java.util.List;
import javax.ws.rs.core.GenericType;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;

/**
 *
 * @author Marina Guzvic
 */
public class NastavnikClient extends RestClient{

    @Override
    public String getDomain() {
        return "/nastavniks";
    }

    @Override
    public Class getType() {
        return NastavnikDTO.class;
    }

    @Override
    public GenericType getCollectionType() {
        return new GenericType<List<NastavnikDTO>>(){};
    }
    
    public List<NastavnikDTO> getNastavniksForKomisija() throws Exception{
        try {
            return (List<NastavnikDTO>) webTarget.path(getDomain() + "/komisija").request().get().readEntity(getCollectionType());
        } catch (Exception e) {
            throw new Exception("Greška prilikom čitanja sa servera");
        }
    }
}

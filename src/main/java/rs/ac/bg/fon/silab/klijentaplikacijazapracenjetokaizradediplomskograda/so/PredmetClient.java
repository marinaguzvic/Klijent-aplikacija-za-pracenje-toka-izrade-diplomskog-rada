/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import java.util.List;
import javax.ws.rs.core.GenericType;
import rs.ac.bg.fon.silab.diplomskiraddtos.PredmetDTO;

/**
 *
 * @author Marina Guzvic
 */
public class PredmetClient extends RestClient{

    @Override
    public String getDomain() {
        return "/predmets";
    }

    @Override
    public Class getType() {
         return PredmetDTO.class;
    }

    @Override
    public GenericType getCollectionType() {
        return new GenericType<List<PredmetDTO>>(){};
    }
    
}

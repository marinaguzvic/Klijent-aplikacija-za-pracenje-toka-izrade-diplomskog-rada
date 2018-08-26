/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDatumOdbraneDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadOdbraniDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadSearchDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadUnesiKomisijuDTO;

/**
 *
 * @author Marina Guzvic
 */
public class DiplomskiRadClient extends RestClient {

    @Override
    public String getDomain() {
        return "/diplomskirads";
    }

    @Override
    public Class getType() {
        return DiplomskiRadDTO.class;
    }

    public List<DiplomskiRadDTO> getByNastavnik(String nastavnikId) throws Exception {
        try {
            return (List<DiplomskiRadDTO>) webTarget.path("/nastavniks/" + nastavnikId + "/diplomskirads").request().get().readEntity(getCollectionType());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greška prilikom čitanja sa servera");
        }
    }

    public List<DiplomskiRadDTO> search(DiplomskiRadSearchDTO dto) throws Exception {
        Response response = webTarget.path("/diplomskirads/search").request().post(Entity.json(dto));
        try {
            return (List<DiplomskiRadDTO>) response.readEntity(getCollectionType());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public List<String> getStatuses() throws Exception {
        Response response = webTarget.path("/diplomskirads/statuses").request().get();
        try {
            return response.readEntity(new GenericType<List<String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public List<String> getUlogas() throws Exception {
        Response response = webTarget.path("/diplomskirads/ulogas").request().get();
        try {
            return response.readEntity(new GenericType<List<String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public DiplomskiRadDTO getById(String id) throws Exception {
        try {
            return (DiplomskiRadDTO) webTarget.path(getDomain() + "byid/" + id).request().get().readEntity(getType());
        } catch (Exception e) {
            throw new Exception("Greška prilikom čitanja sa servera");
        }
    }

    @Override
    public GenericType getCollectionType() {
        return new GenericType<List<DiplomskiRadDTO>>() {
        };
    }

    public DiplomskiRadDTO prijavi(DiplomskiRadPrijaviDTO dto) throws Exception {
        Response response = webTarget.path(getDomain() + "/prijavi").request().post(Entity.json(dto));
        try {
            DiplomskiRadDTO dtoRet = (DiplomskiRadDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public DiplomskiRadDTO odobri(String diplomskiRadId) throws Exception {
        Response response = webTarget.path(getDomain() + "/" + diplomskiRadId + "/odobri").request().put(Entity.json(new DiplomskiRadDTO()));
        try {
            DiplomskiRadDTO dtoRet = (DiplomskiRadDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public DiplomskiRadDTO odrediKomisiju(DiplomskiRadUnesiKomisijuDTO dto, String diplomskiRadId) throws Exception {
        Response response = webTarget.path(getDomain() + "/" + diplomskiRadId + "/unesikomisiju").request().put(Entity.json(dto));
        try {
            DiplomskiRadDTO dtoRet = (DiplomskiRadDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public DiplomskiRadDTO predaj(String diplomskiRadId) throws Exception {
        Response response = webTarget.path(getDomain() + "/" + diplomskiRadId + "/predaj").request().put(Entity.json(new DiplomskiRadDTO()));
        try {
            DiplomskiRadDTO dtoRet = (DiplomskiRadDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }

    public DiplomskiRadDTO odrediDatumOdrbane(DiplomskiRadDatumOdbraneDTO dto, String diplomskiRadId) throws Exception {
        Response response = webTarget.path(getDomain() + "/" + diplomskiRadId + "/odredidatumodbrane").request().put(Entity.json(dto));
        try {
            DiplomskiRadDTO dtoRet = (DiplomskiRadDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }
    
        public DiplomskiRadDTO odbrani(DiplomskiRadOdbraniDTO dto, String diplomskiRadId) throws Exception {
        Response response = webTarget.path(getDomain() + "/" + diplomskiRadId + "/odbrani").request().put(Entity.json(dto));
        try {
            DiplomskiRadDTO dtoRet = (DiplomskiRadDTO) response.readEntity(getType());
            return dtoRet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }
}

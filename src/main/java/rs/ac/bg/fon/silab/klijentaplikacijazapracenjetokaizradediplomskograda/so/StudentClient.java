/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentSearchDTO;

/**
 *
 * @author Marina Guzvic
 */
public class StudentClient extends RestClient{

    @Override
    public String getDomain() {
        return "/students";
    }

    @Override
    public Class getType() {
        return StudentDTO.class;
    }

    @Override
    public GenericType getCollectionType() {
        return new GenericType<List<StudentDTO>>(){};
    }

    public List<StudentDTO> search(StudentSearchDTO student) throws Exception {
        Response response = webTarget.path("/students/search").request().post(Entity.json(student));
        try {
            return (List<StudentDTO>) response.readEntity(getCollectionType());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska!\n" + e.getMessage());
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaSearchDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.TemaDiplomskogRadaClient;

/**
 *
 * @author Marina Guzvic
 */
public class SearchTemaAction extends ViewTemasAction{

    @Override
    public List<AbstractDTO> callToClient(HttpServletRequest request) throws Exception {
        String dip = request.getParameter("diplomski");
        request.setAttribute("nazivTeme", request.getParameter("naziv"));
        request.setAttribute("diplomski", request.getParameter("diplomski"));
        TemaSearchDTO tema = new TemaSearchDTO();
        switch (dip){
            case "svi":
                tema.setDiplomski(null);
                break;
            case "zauzete":
                tema.setDiplomski(true);
                break;
            case "slobodne":
                tema.setDiplomski(false);
                break;
        }
        tema.setNazivTeme(request.getParameter("naziv"));
        return client.search(tema);
    }


    
}

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
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.TemaDiplomskogRadaClient;

/**
 *
 * @author Marina Guzvic
 */
public class SearchTemaAction extends ViewTemasAction{

    @Override
    public List<AbstractDTO> callToClient(HttpServletRequest request) throws Exception {
        return ((TemaDiplomskogRadaClient)client).search(request.getParameter("naziv"));
    }


    
}

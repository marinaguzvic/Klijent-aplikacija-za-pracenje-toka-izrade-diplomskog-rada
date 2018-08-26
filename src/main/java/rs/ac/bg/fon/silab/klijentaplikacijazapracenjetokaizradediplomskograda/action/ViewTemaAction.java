/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.PredmetDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.PredmetClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.TemaDiplomskogRadaClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class ViewTemaAction extends AbstractAction {

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new TemaDiplomskogRadaClient();
            String id = request.getParameter("temaid");
            TemaDiplomskogRadaDTO tema = (TemaDiplomskogRadaDTO) client.get(id);
            request.setAttribute("tema", tema);
            if (request.getSession().getAttribute("predmeti") == null) {
                try {
                    client = new PredmetClient();
                    List<AbstractDTO> abstracts = client.getAll();
                    List<PredmetDTO> predmeti = new ArrayList<>();
                    for (AbstractDTO aAbstract : abstracts) {
                        predmeti.add((PredmetDTO) aAbstract);
                    }
                    request.getSession().setAttribute("predmeti", predmeti);
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }

            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public String getPage(boolean stat) {
        if (stat) {
            return IConstants.TEMA_VIEW_PAGE;
        } else {
            return IConstants.TEMA_SEARCH_PAGE;
        }
    }

}

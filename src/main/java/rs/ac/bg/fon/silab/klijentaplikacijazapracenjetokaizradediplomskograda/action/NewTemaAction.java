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
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.PredmetClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class NewTemaAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        if(request.getSession().getAttribute("predmeti") == null){
            try {
                client = new PredmetClient();
                List<AbstractDTO> abstracts = client.getAll();
                List<PredmetDTO> predmeti = new ArrayList<>();
                for (AbstractDTO aAbstract : abstracts) {
                    predmeti.add((PredmetDTO) aAbstract);
                }
                request.getSession().setAttribute("predmeti", predmeti);
                return true;
            } catch (Exception ex) {
                request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da učita stranicu za novu temu");
                ex.printStackTrace();
                return false;
            }
            
        }else{
            return true;
        }
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.TEMA_NEW_PAGE;
        else return IConstants.LANDING_PAGE;
    }
    
}

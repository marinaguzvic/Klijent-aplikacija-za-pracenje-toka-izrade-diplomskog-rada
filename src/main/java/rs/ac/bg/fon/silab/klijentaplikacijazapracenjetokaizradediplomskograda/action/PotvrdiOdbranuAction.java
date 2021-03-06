/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadOdbraniDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class PotvrdiOdbranuAction extends AbstractAction {

    public PotvrdiOdbranuAction() {
    }

    @Override
      public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = (String) request.getSession().getAttribute(IConstants.DIPLOMSKI_ID);
            DiplomskiRadOdbraniDTO diplomski = new DiplomskiRadOdbraniDTO(Integer.parseInt(request.getParameter("ocena")));
            client = new DiplomskiRadClient();
            DiplomskiRadDTO d = ((DiplomskiRadClient)client).odbrani(diplomski,id);
            request.setAttribute("diplomskiRad", d);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno evidentirao odbranu diplomskog rada");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da evidentira odbranu diplomskog rada");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.DIPLOMSKI_RAD_CONFIRMATION_PAGE;
        else return IConstants.VIEW_STUDENTS_PAGE;
    }
    
}

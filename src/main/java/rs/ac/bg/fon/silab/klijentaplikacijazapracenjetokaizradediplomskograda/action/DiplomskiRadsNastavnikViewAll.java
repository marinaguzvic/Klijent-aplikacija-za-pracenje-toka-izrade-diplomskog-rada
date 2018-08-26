/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class DiplomskiRadsNastavnikViewAll extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new DiplomskiRadClient();
            List<DiplomskiRadDTO> diplomskis = ((DiplomskiRadClient)client).getByNastavnik(((NastavnikDTO)request.getSession().getAttribute(IConstants.NALOG)).getClanSistemaId() + "");
            request.setAttribute("diplomskiRads", diplomskis);
            List<String> statuses = ((DiplomskiRadClient)client).getStatuses();
            request.getSession().setAttribute("statuses", statuses);
            List<String> ulogas = ((DiplomskiRadClient)client).getUlogas();
            request.getSession().setAttribute("ulogas", ulogas);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.DIPLOMSKI_RAD_NASTAVNIK_PAGE;
    }
    
}

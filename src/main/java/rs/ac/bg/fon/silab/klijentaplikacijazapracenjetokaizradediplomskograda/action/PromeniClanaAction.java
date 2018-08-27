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
import rs.ac.bg.fon.silab.diplomskiraddtos.NalogDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.NastavnikClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class PromeniClanaAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new DiplomskiRadClient();
            DiplomskiRadDTO diplomski = (DiplomskiRadDTO) client.get(request.getParameter("studentid"));
            request.setAttribute("clans", diplomski.getClans());
            client = new NastavnikClient();
            List<NastavnikDTO> nastavniks = ((NastavnikClient)client).getNastavniksForKomisija();
            request.setAttribute("nastavniks", nastavniks);
            request.setAttribute("diplomskiid", diplomski.getDiplomskiRadId());
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno pronašao komisiju");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da pronađe komisju");
            return false;
        }
        
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.PROMENI_CLANA_PAGE;
        else return IConstants.VIEW_STUDENTS_PAGE;
                
    }
    
}

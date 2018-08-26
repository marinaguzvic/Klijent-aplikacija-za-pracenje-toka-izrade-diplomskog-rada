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
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadSearchDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class SearchDiplomskiRadNastavnikAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            DiplomskiRadSearchDTO search = new DiplomskiRadSearchDTO();
            String [] stat = request.getParameterValues("stat");
            String [] uloge = request.getParameterValues("uloge");
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String brojindeksa = request.getParameter("brojindeksa");
            Long clanId = ((NastavnikDTO)request.getSession().getAttribute(IConstants.NALOG)).getClanSistemaId();
            search.setStatuses(stat);
            search.setUlogaClanaKomisijes(uloge);
            search.setImeStudenta(ime);
            search.setPrezimeStudenta(prezime);
            search.setBrojIndeksa(brojindeksa);
            search.setNastavnikId(clanId);
            client = new DiplomskiRadClient();
            List<DiplomskiRadDTO> diplomskis = ((DiplomskiRadClient)client).search(search);
            request.setAttribute("diplomskiRads", diplomskis);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
            return IConstants.DIPLOMSKI_RAD_NASTAVNIK_PAGE;
    }
    
}

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
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadUnesiKomisijuDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class PotvrdiKomisijuAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<NastavnikDTO> nastavniks = (List<NastavnikDTO>) request.getSession().getAttribute("clans");
            DiplomskiRadUnesiKomisijuDTO diplomskiRadUnesiKomisijuDTO = new DiplomskiRadUnesiKomisijuDTO();
            String mentor = request.getParameter("mentor");
            for (NastavnikDTO nastavnik : nastavniks) {
                ClanDTO clan = new ClanDTO();
                clan.setNastavnik(nastavnik);
                if(nastavnik.getClanSistemaId() == Long.parseLong(mentor))clan.setUlogaClanaKomisije("MENTOR");
                else clan.setUlogaClanaKomisije("CLAN");
                diplomskiRadUnesiKomisijuDTO.getClans().add(clan);
            }
            client = new DiplomskiRadClient();
            DiplomskiRadDTO d = ((DiplomskiRadClient)client).odrediKomisiju(diplomskiRadUnesiKomisijuDTO, (String) request.getSession().getAttribute(IConstants.DIPLOMSKI_ID));
            request.setAttribute("diplomskiRad", d);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno uneo komisiju za diplomski rad");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da unese komisiju za diplomski rad");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.DIPLOMSKI_RAD_CONFIRMATION_PAGE;
        else return IConstants.VIEW_STUDENTS_PAGE;
    }
}

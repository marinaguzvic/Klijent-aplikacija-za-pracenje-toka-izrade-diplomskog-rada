/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanKaKlijentuDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class PotvrdiPromenuClanaAction extends AbstractAction {

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            String diplomskiRadId = (String) request.getParameter(IConstants.DIPLOMSKI_ID);
            int rb = Integer.parseInt(request.getParameter("clanid"));
            Long nastavnikId = Long.parseLong(request.getParameter("nastavnik"));
            client = new DiplomskiRadClient();
            ClanKaKlijentuDTO clan = new ClanKaKlijentuDTO();
            clan.setClanKomisijeRb(rb);
            clan.setNastavnikIdFk(new NastavnikDTO(nastavnikId));
            DiplomskiRadDTO diplomski = ((DiplomskiRadClient) client).promeniClana(clan, diplomskiRadId);
            request.setAttribute("diplomskiRad", diplomski);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno zapamtio člana komisije");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da zapamti člana komisije");
            return false;
        }

    }

    @Override
    public String getPage(boolean stat) {
        if (stat) {
            return IConstants.DIPLOMSKI_RAD_CONFIRMATION_PAGE;
        } else {
            return IConstants.VIEW_STUDENTS_PAGE;
        }
    }

}

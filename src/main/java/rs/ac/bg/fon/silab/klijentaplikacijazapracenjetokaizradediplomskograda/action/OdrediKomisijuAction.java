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
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.NastavnikClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class OdrediKomisijuAction extends AbstractAction {

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
            try {
                client = new NastavnikClient();
                List<NastavnikDTO> nastavniks = ((NastavnikClient)client).getNastavniksForKomisija();
                request.getSession().setAttribute("nastavniks", nastavniks);
                client = new DiplomskiRadClient();
                DiplomskiRadDTO diplomski = getDiplomski(request);
                request.getSession().setAttribute(IConstants.DIPLOMSKI_ID, request.getParameter(IConstants.DIPLOMSKI_ID));
                request.getSession().setAttribute("odredjen", false);
                request.getSession().setAttribute(IConstants.DIPLOMSKI_RAD_PAGE, diplomski);
                request.getSession().setAttribute("clans", new ArrayList<>());
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da prikaže formu za unos komisije diplomskog rada");
                return false;
            }
    }

    @Override
    public String getPage(boolean stat) {
        if (stat) {
            return IConstants.ODREDI_KOMISIJU_PAGE;
        } else {
            return IConstants.VIEW_STUDENTS_PAGE;
        }
    }

    public DiplomskiRadDTO getDiplomski(HttpServletRequest request) throws Exception {
        return (DiplomskiRadDTO) client.get(request.getParameter(IConstants.STUDENT_ID) + "");
    }
}

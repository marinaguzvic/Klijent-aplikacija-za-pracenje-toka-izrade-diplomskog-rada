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
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DokumentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class DeleteDokumentAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new DokumentClient();
            AbstractDTO dto = ((DokumentClient)client).delete(((DiplomskiRadDTO) request.getSession().getAttribute(IConstants.DIPLOMSKI_RAD)).getDiplomskiRadId(),Integer.parseInt(request.getParameter("dokumentid")));
            client = new DiplomskiRadClient();
            client.get(((ClanSistemaDTO) request.getSession().getAttribute(IConstants.NALOG)).getClanSistemaId() + "");
            client = new DiplomskiRadClient();
            DiplomskiRadDTO diplomski = ((DiplomskiRadClient)client).getById(((DiplomskiRadDTO) request.getSession().getAttribute(IConstants.DIPLOMSKI_RAD)).getDiplomskiRadId() + "");
            request.getSession().setAttribute(IConstants.DIPLOMSKI_RAD, diplomski);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Brisanje uspešno!");
            return true;
        } catch (Exception ex) {
            request.setAttribute(IConstants.ERROR_MESSAGE, "Neuspešno brisanje!");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.DIPLOMSKI_RAD_PAGE;
    }
    
}

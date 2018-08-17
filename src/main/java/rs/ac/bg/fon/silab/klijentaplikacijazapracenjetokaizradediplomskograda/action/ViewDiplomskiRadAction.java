/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class ViewDiplomskiRadAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request) {
        client = new DiplomskiRadClient();
        try {
            DiplomskiRadDTO dto = (DiplomskiRadDTO) client.get(((StudentDTO)request.getSession().getAttribute(IConstants.NALOG)).getClanSistemaId() + "");
            request.setAttribute("diplomskiRad", dto);
            return true;
        } catch (Exception ex) {
            
            request.setAttribute(IConstants.ERROR_MESSAGE, ex.getMessage());
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.DIPLOMSKI_RAD_PAGE;
    }


    
}

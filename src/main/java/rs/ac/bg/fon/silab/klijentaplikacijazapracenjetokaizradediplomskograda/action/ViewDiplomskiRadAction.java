/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public boolean callToService(HttpServletRequest request,HttpServletResponse response) {
        client = new DiplomskiRadClient();
        try {
            DiplomskiRadDTO dto = getDiplomski(request);
            request.getSession().setAttribute(IConstants.DIPLOMSKI_RAD_PAGE, dto);
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

    public DiplomskiRadDTO getDiplomski(HttpServletRequest request) throws Exception{
        return (DiplomskiRadDTO) client.get(((StudentDTO)request.getSession().getAttribute(IConstants.NALOG)).getClanSistemaId() + "");
    }
    
}

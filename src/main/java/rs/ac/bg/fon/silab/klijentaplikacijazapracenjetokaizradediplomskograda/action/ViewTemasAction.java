/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.TemaDiplomskogRadaClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public abstract class ViewTemasAction extends AbstractAction{
    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        client = new TemaDiplomskogRadaClient();
        try {
            List<AbstractDTO> dtos = callToClient(request);
            List<TemaDiplomskogRadaDTO> teme = new ArrayList<>();
            for (AbstractDTO dto : dtos) {
                teme.add((TemaDiplomskogRadaDTO) dto);
            }
            request.setAttribute("teme", teme);
            return true;    
        } catch (Exception ex) {
            return false;
        }
        
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.TEMA_SEARCH_PAGE;
    }

    public abstract List<AbstractDTO> callToClient(HttpServletRequest request) throws Exception;
}

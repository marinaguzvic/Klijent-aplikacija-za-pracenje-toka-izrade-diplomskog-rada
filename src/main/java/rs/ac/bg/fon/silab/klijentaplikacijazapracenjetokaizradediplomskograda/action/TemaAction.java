/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.PredmetDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.TemaDiplomskogRadaClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public abstract class TemaAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new TemaDiplomskogRadaClient();
            TemaDiplomskogRadaDTO tema = new TemaDiplomskogRadaDTO();
            tema.setNazivTeme(request.getParameter("nazivTeme"));
            tema.setOpisTeme(request.getParameter("opisTeme"));
            tema.setPredmetIdFk(new PredmetDTO(Long.parseLong(request.getParameter("predmet"))));
            TemaDiplomskogRadaDTO temaNew = callToClient(tema);
            request.setAttribute(IConstants.TEMA_NEW, temaNew);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno zapamtio temu diplomskog rada");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da zapamti temu diplomskog rada");
                    
            return false;
        }
    }



    public abstract TemaDiplomskogRadaDTO callToClient(TemaDiplomskogRadaDTO tema) throws Exception;
    public abstract void setId(TemaDiplomskogRadaDTO tema, HttpServletRequest request);
}

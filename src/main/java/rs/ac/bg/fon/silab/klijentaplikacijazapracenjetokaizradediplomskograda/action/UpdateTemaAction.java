/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class UpdateTemaAction extends TemaAction {

    @Override
    public TemaDiplomskogRadaDTO callToClient(TemaDiplomskogRadaDTO tema) throws Exception {
        return (TemaDiplomskogRadaDTO) client.put(tema, tema.getTemaId() + "");
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.TEMA_VIEW_PAGE;
    }

    @Override
    public void setId(TemaDiplomskogRadaDTO tema, HttpServletRequest request) {
        tema.setTemaId(Long.parseLong(request.getParameter("id")));
    }

}

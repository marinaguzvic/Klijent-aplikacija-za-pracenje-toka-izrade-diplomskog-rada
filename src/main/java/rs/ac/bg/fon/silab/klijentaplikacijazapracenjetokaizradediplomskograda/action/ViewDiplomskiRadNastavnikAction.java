/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class ViewDiplomskiRadNastavnikAction extends ViewDiplomskiRadAction{

    @Override
    public DiplomskiRadDTO getDiplomski(HttpServletRequest request) throws Exception {
        return ((DiplomskiRadClient)client).getById( String.valueOf(request.getParameter("diplomskiid")));
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.DIPLOMSKI_RAD_PAGE;
        else return IConstants.DIPLOMSKI_RAD_NASTAVNIK_PAGE;
    }
    
    
}

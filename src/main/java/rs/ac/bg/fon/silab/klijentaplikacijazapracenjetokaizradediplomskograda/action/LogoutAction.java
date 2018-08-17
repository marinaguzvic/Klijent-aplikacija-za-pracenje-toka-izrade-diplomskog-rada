/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class LogoutAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request) {
        request.getSession().removeAttribute(IConstants.NALOG);
        return true;
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.LOGIN_PAGE;
    }
    
}

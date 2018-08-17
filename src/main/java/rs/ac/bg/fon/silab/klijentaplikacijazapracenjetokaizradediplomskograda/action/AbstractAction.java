/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.pagenamedecorator.PageNameDecorator;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.RestClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author FON
 */
public abstract class AbstractAction {
    protected RestClient client;
    

    public String execute(HttpServletRequest request){
        if(!loggedIn(request)){
            request.setAttribute(IConstants.PAGE, IConstants.LOGIN_PAGE);
            return IConstants.LOGIN_PAGE;
        }
        boolean stat = callToService(request);
        String page = getPage(stat);
        request.setAttribute(IConstants.PAGE, PageNameDecorator.getInstance().getPageName(page));
        return page;
    }

    public abstract boolean callToService(HttpServletRequest request);
    public abstract String getPage(boolean stat);

    public boolean loggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute(IConstants.NALOG) != null;
    }
    
}

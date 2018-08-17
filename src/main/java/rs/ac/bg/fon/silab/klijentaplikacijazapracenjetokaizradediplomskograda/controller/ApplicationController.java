/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.controller;



import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action.AbstractAction;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action.ActionFactory;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author FON
 */
public class ApplicationController {

    private static ApplicationController instance;

    private ApplicationController() {
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }
    
    public String processRequest(String action, HttpServletRequest request) {
        String page = request.getSession().getAttribute(IConstants.NALOG) != null ? IConstants.LANDING_PAGE_PATH:IConstants.LOGIN_PAGE_PATH;
        
        AbstractAction command = ActionFactory.createAction(action);
        if(command != null)
            page = command.execute(request);
        
        return page;
    }

}

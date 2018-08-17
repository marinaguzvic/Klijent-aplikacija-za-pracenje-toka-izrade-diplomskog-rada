/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author FON
 */
public class ActionFactory {
    public static AbstractAction createAction(String action) {
        AbstractAction command = null;
        
        if(action.equalsIgnoreCase(IConstants.LOGIN_PAGE))command = new LoginAction();
        if(action.equalsIgnoreCase(IConstants.LANDING_PAGE))command = new LandingPageAction();
        if(action.equalsIgnoreCase(IConstants.DIPLOMSKI_RAD_ACTION))command = new ViewDiplomskiRadAction();
        if(action.equalsIgnoreCase(IConstants.LOGOUT_ACTION))command = new LogoutAction();
        
        return command;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NalogDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.RadnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.LoginClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author FON
 */
public class LoginAction extends AbstractAction {

    @Override
    public boolean loggedIn(HttpServletRequest request) {
        return true;
    }
    
    
    
    @Override
    public boolean callToService(HttpServletRequest request) {
         try {
            client = new LoginClient();
            ClanSistemaDTO clan = ((LoginClient)client).login(new NalogDTO(request.getParameter("korisnickoIme"), request.getParameter("sifra")));
            request.getSession().setAttribute("nalog", clan);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", "Login neuspešan, neispravno korisničko ime ili šifra");            
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.LANDING_PAGE;
        else return IConstants.LOGIN_PAGE;
    }

}

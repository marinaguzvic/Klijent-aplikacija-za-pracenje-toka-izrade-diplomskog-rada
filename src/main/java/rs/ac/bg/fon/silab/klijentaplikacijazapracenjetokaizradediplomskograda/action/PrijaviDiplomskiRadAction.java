/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.StudentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.TemaDiplomskogRadaClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class PrijaviDiplomskiRadAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new TemaDiplomskogRadaClient();
            List<TemaDiplomskogRadaDTO> temas = ((TemaDiplomskogRadaClient)client).getFreeTemas();
            request.setAttribute("temas", temas);
            client = new StudentClient();
            StudentDTO student = (StudentDTO) client.get(request.getParameter("studentid"));
            request.setAttribute("student", student);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da otvori stranicu za prijavu diplomskog rada");
            return false;
        }
        
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.PRIJAVI_DIPLOMSKI_PAGE;
        else return IConstants.VIEW_STUDENTS_PAGE;
    }
    
}

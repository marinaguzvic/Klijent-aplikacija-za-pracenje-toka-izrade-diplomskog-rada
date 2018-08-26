/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class PotvrdiPrijavuDiplomskog extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            String student = request.getParameter(IConstants.STUDENT_ID);
            String tema = request.getParameter(IConstants.TEMA_ID);
            DiplomskiRadPrijaviDTO diplomski = new DiplomskiRadPrijaviDTO(Long.parseLong(student), Long.parseLong(tema));
            client = new DiplomskiRadClient();
            DiplomskiRadDTO d = ((DiplomskiRadClient)client).prijavi(diplomski);
            request.setAttribute("diplomskiRad", d);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno prijavio temu diplomskog rada");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da prijavi temu diplomskog rada");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.DIPLOMSKI_RAD_CONFIRMATION_PAGE;
        else return IConstants.VIEW_STUDENTS_PAGE;
    }
    
}

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
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadUnesiKomisijuDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DiplomskiRadClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.StudentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class ViewStudentAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new StudentClient();
            StudentDTO student = (StudentDTO) client.get(request.getParameter("studentid"));
            client = new DiplomskiRadClient();
            DiplomskiRadDTO diplomski = (DiplomskiRadDTO) client.get(request.getParameter("studentid"));
            request.setAttribute("student", student);
            request.setAttribute("diplomskiRad", diplomski);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je našao izabranog studenta");
//            DiplomskiRadUnesiKomisijuDTO diplomskiRadUnesi = new DiplomskiRadUnesiKomisijuDTO();
//            diplomskiRadUnesi.getClans().add(new ClanDTO("CLAN", 5l));
//            request.setAttribute("clans", diplomskiRadUnesi.getClans());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da nađe izabaranog studenta");
            return false;
        }
        
    }

    @Override
    public String getPage(boolean stat) {
        if(stat)return IConstants.STUDENT_UPDATE_PAGE;
        else return IConstants.VIEW_STUDENTS_PAGE;
    }
    
}

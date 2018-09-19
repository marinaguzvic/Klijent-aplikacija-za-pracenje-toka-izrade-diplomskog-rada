/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentSearchDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.StudentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class SearchStudentsAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
            try {
            client = new StudentClient();
            StudentSearchDTO student = new StudentSearchDTO();
            student.setIme(request.getParameter("ime"));
            student.setPrezime(request.getParameter("prezime"));
            student.setBrojTelefona(request.getParameter("brojtelefona"));
            student.setJmbg(request.getParameter("jmbg"));
            Integer [] godine = new Integer[4];
            String [] god = request.getParameterValues("godinestudija");
            if(god == null || god.length == 0){
               
            }else{
                 for (String string : god) {
                   if(string != null) godine[godine.length - 1] = Integer.parseInt(string);
                }
                 student.setGodineStudija(godine);
            }
            
            
            List<StudentDTO> students = ((StudentClient)client).search(student);
            request.setAttribute("studentsearchcriteria", student);
            request.setAttribute(IConstants.STUDENTS, students);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je našao studente po zadatim vrednostima");
                    
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da pronađe studente po zadatim vrednostima");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.VIEW_STUDENTS_PAGE;
    }
    
}

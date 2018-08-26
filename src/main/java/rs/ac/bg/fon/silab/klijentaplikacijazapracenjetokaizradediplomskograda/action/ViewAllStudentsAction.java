/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.StudentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class ViewAllStudentsAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new StudentClient();
            List<AbstractDTO> abstracts = client.getAll();
            List<StudentDTO> students = new ArrayList<>();
            for (AbstractDTO aAbstract : abstracts) {
                students.add((StudentDTO) aAbstract);
            }
            request.getSession().setAttribute("students", students);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno našao listu studenata");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da nađe listu studenata");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.VIEW_STUDENTS_PAGE;
    }
    
}

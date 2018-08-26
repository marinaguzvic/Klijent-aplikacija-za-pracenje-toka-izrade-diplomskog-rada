/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.StudentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public abstract class StudentAction extends AbstractAction{
     @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new StudentClient();
            StudentDTO student = new StudentDTO();
            student.setIme(request.getParameter("ime"));
            student.setPrezime(request.getParameter("prezime"));
            student.setBrojTelefona(request.getParameter("brojtelefona"));
            student.setBrojIndeksa(request.getParameter("brojindeksa"));
            student.setJmbg(request.getParameter("jmbg"));
            student.setDatumRodjenja(request.getParameter("datumrodjenja"));
            student.setGodinaStudija(Integer.parseInt(request.getParameter("godinastudija")));
            setId(student, request);
            
            StudentDTO studentNew = callToClient(student);
            request.setAttribute(IConstants.STUDENT_NEW, studentNew);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno zapamtio studenta");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da zapamti studenta");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.STUDENT_UPDATE_PAGE;
    }

    public abstract StudentDTO callToClient(StudentDTO student) throws Exception;
    public abstract void setId(StudentDTO student, HttpServletRequest request);
}

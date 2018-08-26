/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import javax.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;

/**
 *
 * @author Marina Guzvic
 */
public class UpdateStudentAction extends StudentAction{

    @Override
    public StudentDTO callToClient(StudentDTO student) throws Exception {
        return (StudentDTO)client.put(student, student.getClanSistemaId()+"");
    }

    @Override
    public void setId(StudentDTO student, HttpServletRequest request) {
        student.setClanSistemaId(Long.parseLong(request.getParameter("id")));
    }
    
}

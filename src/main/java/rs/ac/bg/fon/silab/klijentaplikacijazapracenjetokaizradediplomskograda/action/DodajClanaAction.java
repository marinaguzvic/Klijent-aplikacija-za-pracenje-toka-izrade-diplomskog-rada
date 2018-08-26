/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class DodajClanaAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        String nastavnik = request.getParameter("nastavnik");
        List<NastavnikDTO> n = ((List<NastavnikDTO>)request.getSession().getAttribute("nastavniks"));
        for (NastavnikDTO nastavnikDTO : n) {
            if(nastavnikDTO.getClanSistemaId() == Long.parseLong(nastavnik)){
                ((List<NastavnikDTO>)request.getSession().getAttribute("clans")).add(nastavnikDTO);
                break;
            }
        }
        return true;
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.ODREDI_KOMISIJU_PAGE;
    }
    
}

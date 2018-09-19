/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DokumentDownloadDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DokumentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class DownloadAction extends AbstractAction {
    
    @Override
    public boolean callToService(HttpServletRequest request, HttpServletResponse response) {
        try {
            client = new DokumentClient();
            //ByteArrayInputStream input =  
            DokumentDownloadDTO dto = ((DokumentClient) client).get(((DiplomskiRadDTO) request.getSession().getAttribute("diplomskiRad")).getDiplomskiRadId(), Integer.parseInt(request.getParameter("dokumentid")));
            response.setContentType("application/force-download");
            response.setContentLength((int) dto.getSadrzajDokumenta().length);
            //response.setContentLength(-1);
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + dto.getNazivDokumenta() + "\"");
            response.getOutputStream().write(dto.getSadrzajDokumenta());
            response.getOutputStream().close();
//            int read;
//            OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
////            InputStreamReader reader = new InputStreamReader(input);
//            for (byte b : buffer) {
//                writer.write(b);
//            }
//            writer.flush();
//            writer.close();
            return true;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public String getPage(boolean stat) {
        return IConstants.DIPLOMSKI_RAD_PAGE;
    }
    
}

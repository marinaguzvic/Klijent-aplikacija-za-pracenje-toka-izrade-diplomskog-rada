/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import com.sun.jersey.multipart.MultiPart;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DokumentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class DownloadAction extends AbstractAction{

    @Override
    public boolean callToService(HttpServletRequest request,HttpServletResponse response) {
        try {
            client = new DokumentClient();
            //ByteArrayInputStream input =            
            byte[] buffer = ((DokumentClient)client).get(((DiplomskiRadDTO)request.getSession().getAttribute("diplomskiRad")).getDiplomskiRadId(), (Long) request.getAttribute("dokumentid"));
            
//            int read;
//            OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
////            InputStreamReader reader = new InputStreamReader(input);
//            for (byte b : buffer) {
//                writer.write(b);
//            }
//            writer.flush();
//            writer.close();
    response.getOutputStream();
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

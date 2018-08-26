/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import com.sun.jersey.multipart.MultiPart;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so.DokumentClient;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author Marina Guzvic
 */
public class UploadAction extends AbstractAction {

    public UploadAction() {
    }

    @Override
    public boolean callToService(HttpServletRequest request,HttpServletResponse response) {
        try {
            client = new DokumentClient();
            Part filePart = request.getPart("file");
            File file = new File(filePart.getSubmittedFileName());
            FileOutputStream out = new FileOutputStream(file);
            InputStream filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            DiplomskiRadDTO diplomski = (DiplomskiRadDTO) ((DokumentClient) client).post(((DiplomskiRadDTO) request.getSession().getAttribute(IConstants.DIPLOMSKI_RAD_PAGE)).getDiplomskiRadId(), file);
            request.getSession().setAttribute(IConstants.DIPLOMSKI_RAD_PAGE, diplomski);
            request.setAttribute(IConstants.SUCCESS_MESSAGE, "Sistem je uspešno poslao dokument");
                    
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute(IConstants.ERROR_MESSAGE, "Sistem ne može da pošalje dokument");
            return false;
        }
    }

    @Override
    public String getPage(boolean stat) {
        return IConstants.DIPLOMSKI_RAD_PAGE;
    }

}

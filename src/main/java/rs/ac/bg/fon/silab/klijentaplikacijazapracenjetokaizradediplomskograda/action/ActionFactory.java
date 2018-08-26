/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.action;

import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author FON
 */
public class ActionFactory {
    public static AbstractAction createAction(String action) {
        AbstractAction command = null;
        
        if(action.equalsIgnoreCase(IConstants.LOGIN_PAGE))command = new LoginAction();
        if(action.equalsIgnoreCase(IConstants.LANDING_PAGE))command = new LandingPageAction();
        if(action.equalsIgnoreCase(IConstants.DIPLOMSKI_RAD_ACTION))command = new ViewDiplomskiRadAction();
        if(action.equalsIgnoreCase(IConstants.LOGOUT_ACTION))command = new LogoutAction();
        if(action.equalsIgnoreCase(IConstants.UPLOAD_ACTION)) command = new UploadAction();
        if(action.equalsIgnoreCase(IConstants.DOWNLOAD_ACTION))command = new DownloadAction();
        if(action.equalsIgnoreCase(IConstants.DIPLOMSKI_RAD_NASTAVNIK_ACTION))command = new DiplomskiRadsNastavnikViewAll();
        if(action.equalsIgnoreCase(IConstants.VIEW_DIPLOMSKI_RAD_NASTAVNIK_ACTION))command = new ViewDiplomskiRadNastavnikAction();
        if(action.equalsIgnoreCase(IConstants.DIPLOMSKI_RAD_NASTAVNIK_SEARCH_ACTION))command = new SearchDiplomskiRadNastavnikAction();
        if(action.equalsIgnoreCase(IConstants.SAVE_STUDENT_ACTION))command = new SaveStudentAction();
        if(action.equalsIgnoreCase(IConstants.NEW_STUDENT_ACTION))command = new NewStudentAction();
        if(action.equalsIgnoreCase(IConstants.UPDATE_STUDENT_ACTION))command = new UpdateStudentAction();
        if(action.equalsIgnoreCase(IConstants.VIEW_STUDENTS_ACTION))command = new ViewAllStudentsAction();
        if(action.equalsIgnoreCase(IConstants.SEARCH_STUDENT_ACTION))command = new SearchStudentsAction();
        if(action.equalsIgnoreCase(IConstants.VIEW_STUDENT_ACTION))command = new ViewStudentAction();
        if(action.equalsIgnoreCase(IConstants.TEMA_NEW_ACTION))command = new NewTemaAction();
        if(action.equalsIgnoreCase(IConstants.TEMA_VIEW_ACTION))command = new ViewTemaAction();
        if(action.equalsIgnoreCase(IConstants.SAVE_TEMA_ACTION))command = new SaveTemaAction();
        if(action.equalsIgnoreCase(IConstants.UPDATE_TEMA_ACTION))command = new UpdateTemaAction();
        if(action.equalsIgnoreCase(IConstants.TEMA_VIEW_ALL_ACTION))command = new ViewAllTemaAction();
        if(action.equalsIgnoreCase(IConstants.TEMA_SEARCH_ACTION))command = new SearchTemaAction();
        if(action.equalsIgnoreCase(IConstants.ODREDI_KOMISIJU_ACTION))command = new OdrediKomisijuAction();
        if(action.equalsIgnoreCase(IConstants.PRIJAVI_DIPLOMSKI_ACTION))command = new PrijaviDiplomskiRadAction();
        if(action.equalsIgnoreCase(IConstants.POTVRDI_PRIJAVU_DIPLOMSKOG_ACTION))command = new PotvrdiPrijavuDiplomskog();
        if(action.equalsIgnoreCase(IConstants.ODOBRI_DIPLOMSKI_ACTION))command = new OdobriDiplomskiRadAction();
        if(action.equalsIgnoreCase(IConstants.ODREDI_KOMISIJU_ACTION))command = new OdrediKomisijuAction();
        if(action.equalsIgnoreCase(IConstants.POTVRDI_KOMISIJU_ACTION))command = new PotvrdiKomisijuAction();
        if(action.equalsIgnoreCase(IConstants.PREDAJ_DIPLOMSKI_RAD_ACTION))command = new PredajDiplomskiRadAction();
        if(action.equalsIgnoreCase(IConstants.ODREDI_DATUM_ODBRANE_ACTION))command = new OdrediDatumOdbraneAction();
        if(action.equalsIgnoreCase(IConstants.POTVRDI_DATUM_ODBRANE_ACTION))command = new PotvrdiDatumOdbraneAction();
        if(action.equalsIgnoreCase(IConstants.ODREDI_OCENU_ACTION))command = new OdrediOcenuDiplomskogRadaAction();
        if(action.equalsIgnoreCase(IConstants.POTVRDI_ODBRANU_ACTION))command = new PotvrdiOdbranuAction();
        return command;
    }
}

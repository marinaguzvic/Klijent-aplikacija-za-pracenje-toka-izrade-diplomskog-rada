/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util;

/**
 *
 * @author Marina Guzvic
 */
public interface IConstants {

    public static final String NALOG = "nalog";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String PAGE = "page";

    public static final String LOGIN_PAGE = "login";
    public static final String LANDING_PAGE = "landingpage";
    public static final String DIPLOMSKI_RAD_PAGE = "diplomskiRad";
    public static final String DIPLOMSKI_RAD_ACTION = "diplomskiview";
    public static final String DIPLOMSKI_RAD_NASTAVNIK_ACTION = "diplomskiviewall";
    public static final String DIPLOMSKI_RAD_NASTAVNIK_SEARCH_ACTION = "diplomskisearch";
    public static final String DIPLOMSKI_RAD_NASTAVNIK_PAGE = "diplomskiradsnastavnik";

    public static final String LOGIN_PAGE_PATH = "/pages/login.jsp";
    public static final String LANDING_PAGE_PATH = "/WEB-INF/pages/landingpage.jsp";
    public static final String DIPLOMSKI_RAD_PAGE_PATH = "/WEB-INF/pages/diplomskirad.jsp";

    public static final String CONTEXT_ROOT = "/app";
    public static final String LANDING_PAGE_NAME = "Moj nalog";
    public static final String LOGIN_PAGE_NAME = "Prijavite se";
    public static final String DIPLOMSKI_RAD_PAGE_NAME = "Diplomski rad";
    public static final String LOGOUT_ACTION = "logout";
    public static final String UPLOAD_ACTION = "upload";
    public static final String DOWNLOAD_ACTION = "download";
    public static final String DIPLOMSKI_RAD_NASTAVNIK_PATH = "/WEB-INF/pages/diiplomskiradsnastavnik.jsp";
    public static final String DIPLOMSKI_RAD_NASTAVNIK_PAGE_NAME = "Pregled diplomskih radova";
    public static final String VIEW_DIPLOMSKI_RAD_NASTAVNIK_ACTION = "diplomskiviewnastavnik";
    public static final String STUDENT_NEW = "student";
    public static final String NEW_STUDENT_ACTION = "newstudent";
    public static final String SAVE_STUDENT_ACTION = "savestudent";
    public static final String STUDENT_NEW_PAGE = "newstudent";
    public static final String STUDENT_UPDATE_PAGE = "updatestudent";
    public static final String STUDENT_NEW_PATH = "/WEB-INF/pages/studentnew.jsp";
    public static final String STUDENT_UPDATE_PATH = "/WEB-INF/pages/studentupdate.jsp";
    public static final String STUDENT_NEW_PAGE_NAME = "Unos novog studenta";
    public static final String STUDENT_UPDATE_PAGE_NAME = "Izmena studenta";
    public static final String UPDATE_STUDENT_ACTION = "updatestudent";
    public static final String VIEW_STUDENTS_PAGE = "viewstudents";
    public static final String VIEW_STUDENTS_PAGE_PATH = "/WEB-INF/pages/students.jsp";
    public static final String VIEW_STUDENTS_PAGE_NAME = "Pretraga studenata";
    public static final String VIEW_STUDENTS_ACTION = "viewstudents";
    public static final String STUDENTS = "students";
    public static final String SEARCH_STUDENT_ACTION = "searchstudents";
    public static final String VIEW_STUDENT_ACTION = "viewstudent";
    public static final String TEMA_NEW_PAGE = "newtema";
    public static final String TEMA_VIEW_PAGE = "viewtema";
    public static final String TEMA_NEW_ACTION = "newtema";
    public static final String TEMA_VIEW_ACTION = "viewtema";
    public static final String TEMA_NEW_PAGE_NAME = "Unos nove teme";
    public static final String TEMA_VIEW_PAGE_NAME = "Pregled svih tema";
    public static final String TEMA_NEW = "tema";
    public static final String SAVE_TEMA_ACTION = "savetema";
    public static final String UPDATE_TEMA_ACTION = "updatetema";
    public static final String TEMA_NEW_PAGE_PATH = "/WEB-INF/pages/temanew.jsp";
    public static final String TEMA_VIEW_PAGE_PATH = "/WEB-INF/pages/temaview.jsp";
    public static final String TEMA_SEARCH_PAGE = "temasearch";
    public static final String TEMA_SEARCH_PAGE_NAME = "Pretraži teme";
    public static final String TEMA_SEARCH_PAGE_PATH = "/WEB-INF/pages/temasearch.jsp";
    public static final String TEMA_SEARCH_ACTION = "temasearch";
    public static final String TEMA_VIEW_ALL_ACTION = "viewalltemas";
    public static final String SUCCESS_MESSAGE = "successMessage";
    public static final String ODREDI_KOMISIJU_PAGE = "newkomisija";
    public static final String ODREDI_KOMISIJU_ACTION = "newkomisija";
    public static final String ODREDI_KOMISIJU_PAGE_NAME = "Unesite komisiju";
    public static final String ODREDI_KOMISIJU_PAGE_PATH = "/WEB-INF/pages/diplomskikomisija.jsp";
    public static final String STUDENT_ID = "studentid";
    public static final String PRIJAVI_DIPLOMSKI_PAGE = "prijavidiplomski";
    public static final String PRIJAVI_DIPLOMSKI_ACTION = "prijavidiplomski";
    public static final String PRIJAVI_DIPLOMSKI_PAGE_NAME = "Prijava diplomskog";
    public static final String PRIJAVI_DIPLOMSKI_PAGE_PATH = "/WEB-INF/pages/prijavidiplomski.jsp";
    public static final String TEMA_ID = "temaid";
    public static final String DIPLOMSKI_RAD_CONFIRMATION_PAGE = "diplomskiconfirmation";
    public static final String DIPLOMSKI_RAD_CONFIRMATION_PAGE_NAME = "Diplomski rad";
    public static final String DIPLOMSKI_RAD_CONFIRMATION_PAGE_PATH = "/WEB-INF/pages/diplomskiradconfirmation.jsp";
    public static final String DIPLOMSKI_ID = "diplomskiid";
    public static final String ODREDI_DATUM_ODBRANE_PAGE = "odredidatumodbrane";
    public static final String ODREDI_DATUM_ODBRANE_ACTION = "odredidatumodbrane";
    public static final String ODREDI_DATUM_ODBRANE_PAGE_NAME = "Diplomski rad - odredi datum odbrane";
    public static final String ODREDI_DATUM_ODBRANE_PAGE_PATH = "/WEB-INF/pages/diplomskidatumodbrane.jsp";

    public static final String ODREDI_OCENU_PAGE = "odrediocenu";
    public static final String ODREDI_OCENU_ACTION = "odrediocenu";
    public static final String ODREDI_OCENU_NAME = "Diplomski rad - odredi ocenu";
    public static final String ODREDI_OCENU_PATH = "/WEB-INF/pages/diplomskiocena.jsp";
    public static final String POTVRDI_PRIJAVU_DIPLOMSKOG_ACTION = "potvrdiprijavudiplomskog";
    public static final String ODOBRI_DIPLOMSKI_ACTION = "odobridiplomski";
    public static final String POTVRDI_KOMISIJU_ACTION = "potvrdikomisiju";
    public static final String POTVRDI_CLANOVE_ACTION = "potvrdiclanove";
    public static final String DODAJ_CLANA_ACTION = "dodajclana";
    public static final String PREDAJ_DIPLOMSKI_RAD_ACTION = "predajdiplomski";
    public static final String POTVRDI_DATUM_ODBRANE_ACTION = "potvrdidatumodbrane";
    public static final String POTVRDI_ODBRANU_ACTION = "potvrdiocenu";
}

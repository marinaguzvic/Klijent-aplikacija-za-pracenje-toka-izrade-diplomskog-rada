/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.pageResolver;

import java.util.HashMap;
import java.util.Map;
import rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.util.IConstants;

/**
 *
 * @author FON
 */
public class PageResolver {

    private static PageResolver instance;
    private Map<String, String> view;

    private PageResolver() {
        view = new HashMap<>();
        view.put(IConstants.LANDING_PAGE, IConstants.LANDING_PAGE_PATH);
        view.put(IConstants.LOGIN_PAGE, IConstants.LOGIN_PAGE_PATH);
        view.put(IConstants.DIPLOMSKI_RAD_PAGE, IConstants.DIPLOMSKI_RAD_PAGE_PATH);
        view.put(IConstants.DIPLOMSKI_RAD_NASTAVNIK_PAGE, IConstants.DIPLOMSKI_RAD_NASTAVNIK_PATH);
        view.put(IConstants.STUDENT_UPDATE_PAGE, IConstants.STUDENT_UPDATE_PATH);
        view.put(IConstants.STUDENT_NEW_PAGE, IConstants.STUDENT_NEW_PATH);
        view.put(IConstants.VIEW_STUDENTS_PAGE, IConstants.VIEW_STUDENTS_PAGE_PATH);
        view.put(IConstants.TEMA_NEW_PAGE, IConstants.TEMA_NEW_PAGE_PATH);
        view.put(IConstants.TEMA_VIEW_PAGE, IConstants.TEMA_VIEW_PAGE_PATH);
        view.put(IConstants.TEMA_SEARCH_PAGE, IConstants.TEMA_SEARCH_PAGE_PATH);
        view.put(IConstants.ODREDI_KOMISIJU_PAGE, IConstants.ODREDI_KOMISIJU_PAGE_PATH);
        view.put(IConstants.PRIJAVI_DIPLOMSKI_PAGE, IConstants.PRIJAVI_DIPLOMSKI_PAGE_PATH);
        view.put(IConstants.ODREDI_DATUM_ODBRANE_PAGE, IConstants.ODREDI_DATUM_ODBRANE_PAGE_PATH);
        view.put(IConstants.ODREDI_OCENU_PAGE,IConstants.ODREDI_KOMISIJU_PAGE_PATH);
        view.put(IConstants.DIPLOMSKI_RAD_CONFIRMATION_PAGE,IConstants.DIPLOMSKI_RAD_CONFIRMATION_PAGE_PATH);
    }

    public static PageResolver getInstance() {
        if (instance == null) {
            instance = new PageResolver();
        }
        return instance;
    }

    public String getPage(String key) {
        return view.get(key);
    }
}

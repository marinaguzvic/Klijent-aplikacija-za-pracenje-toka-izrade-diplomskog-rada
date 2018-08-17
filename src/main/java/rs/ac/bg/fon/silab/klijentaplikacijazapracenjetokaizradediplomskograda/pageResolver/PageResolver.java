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

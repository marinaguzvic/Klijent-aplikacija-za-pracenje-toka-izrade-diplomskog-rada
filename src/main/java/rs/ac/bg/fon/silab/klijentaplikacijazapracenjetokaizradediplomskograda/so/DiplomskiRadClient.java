/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.klijentaplikacijazapracenjetokaizradediplomskograda.so;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;

/**
 *
 * @author Marina Guzvic
 */
public class DiplomskiRadClient extends RestClient{

    @Override
    public String getDomain() {
        return "diplomskirads";
    }

    @Override
    public Class getType() {
        return DiplomskiRadDTO.class;
    }


}
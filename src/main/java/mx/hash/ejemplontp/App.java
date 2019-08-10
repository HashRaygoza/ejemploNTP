/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.hash.ejemplontp;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class App {
    static private final Logger LOGGER = Logger.getLogger("mx.hash.ejemplontp.App");
    
    static public void main(String[] args){
        NTPService servicioNTP = new NTPService();
        LOGGER.log(Level.INFO, "Obteniendo fecha desde el servidor NTP");
        
        Date fecha = servicioNTP.getNTPDate();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Fecha-Hora NTP: " + fecha);
    }    
}

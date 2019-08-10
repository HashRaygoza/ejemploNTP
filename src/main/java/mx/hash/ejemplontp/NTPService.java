/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.hash.ejemplontp;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class NTPService {

    static private final Logger LOGGER = Logger.getLogger("mx.hash.ejemplontp.NTPService");

    public Date getNTPDate() {
        String[] hosts = new String[]{"cronos.cenam.mx", "2.mx.pool.ntp.org"};

        Date fechaRecibida;
        NTPUDPClient cliente = new NTPUDPClient();
        cliente.setDefaultTimeout(5000);
        for (String host : hosts) {
            try {
                LOGGER.log(Level.INFO, "Obteniendo fecha desde: {0}", host);
                InetAddress hostAddr = InetAddress.getByName(host);
                TimeInfo fecha = cliente.getTime(hostAddr);
                fechaRecibida = new Date(fecha.getMessage().getTransmitTimeStamp().getTime());
                return fechaRecibida;
                
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "NO SE PUDO CONECTAR AL SERVIDOR {0}", host);
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        
        LOGGER.log(Level.WARNING, "No se pudo conectar con servidor, regresando hora local");
        cliente.close();
        return new Date();
    }
}

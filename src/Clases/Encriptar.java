/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Javier
 */
public class Encriptar {
    public String encriptarMd5(String dato){
        String datoMd5;
        datoMd5 = DigestUtils.md5Hex(dato);
        return(datoMd5);
    }

    public String encriptarSha1(String dato){
        String datoSha1;
        datoSha1 = DigestUtils.sha1Hex(dato);
        return(datoSha1);
    }
}

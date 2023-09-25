/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author kalema
 */
public class Encry {
    
    public static String encriptar(char[] vienePass){
        StringBuilder salida=new StringBuilder();
        String armoCadena="";
        for (int i=0; i<vienePass.length ;i++){
            armoCadena+=vienePass[i];
        }
        try {
            MessageDigest msg = MessageDigest.getInstance("SHA-256");
            byte[] abyte = msg.digest(armoCadena.getBytes());
            for (byte myByte : abyte) {
                salida.append(String.format("%02x", myByte));
            }
        } catch (NoSuchAlgorithmException e) {
        }
        
        return salida.toString();
    }
}

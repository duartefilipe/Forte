package br.forte.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografa {

    public String criptografa(String senha){
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest.digest());
        }catch(NoSuchAlgorithmException ns){
            ns.printStackTrace();
        }
        return senha;
    }
}

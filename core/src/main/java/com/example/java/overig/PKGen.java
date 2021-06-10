package com.example.java.overig;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class PKGen {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        var keyPair = keyGenerator.generateKeyPair();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
        var base64 = Base64.getEncoder().encode(keyPair.getPrivate().getEncoded());
        System.out.println(new String(base64));
//        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
//        KeyFactory kf = KeyFactory.getInstance("RSA");
    }
}

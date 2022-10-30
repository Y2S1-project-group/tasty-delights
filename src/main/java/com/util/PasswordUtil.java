package com.util;

import com.interfaces.Password;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil implements Password {
    public String encryptString(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(password.getBytes());
        BigInteger bigInt = new BigInteger(1, messageDigest);
        return bigInt.toString(16);
    }

    public boolean validatePassword(String password, String hashingPassword) throws NoSuchAlgorithmException {
        if(encryptString(password).equals(hashingPassword)){
            return true;
        }
        return false;
    }
}

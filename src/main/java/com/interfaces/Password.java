package com.interfaces;

import java.security.NoSuchAlgorithmException;

public interface Password {
    public String encryptString(String password) throws NoSuchAlgorithmException;
    public boolean validatePassword(String password, String hashingPassword) throws NoSuchAlgorithmException;
}

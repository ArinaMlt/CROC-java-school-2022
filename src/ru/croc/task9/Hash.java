package ru.croc.task9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static void main(String[] args) {
        String s = "bab";
        // System.out.println(hashPassword(s));
        String hash = "d9d7dbddc29177b121a6aa1bb09d15fd";


        // if ((hashPassword(s).equals(hash.toUpperCase()))) {
        //    System.out.println("equals");
        // }
        // System.out.println(hashPassword("aaaaaag"));
        System.out.println(hashPassword("fffd"));


    }

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

}

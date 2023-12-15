package com.github.shoothzj.postgre.jpa.lob.util;

public class StringTool {

    private static final String base = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String randomStr(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

package com.future.util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ScanTool {

    public static void main(String[] args) throws IOException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        Enumeration<URL> urls = cl.getResources("target/");

        while (urls.hasMoreElements()) {
            URL u = urls.nextElement();
            System.out.println(u);
            System.out.println(u.getProtocol());
            System.out.println(u.getPath());
        }


    }


}

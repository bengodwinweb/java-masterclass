package com.bengodwin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        try {
//            URI uri = new URI("http://username:password@myserver.com:5000/catalog/phones?os=android#samsung");
//            URI baseURI = new URI("http://username:password@myserver.com:5000");
//            URI uri1 = new URI("/catalog/phones?os=android#samsung");
//            URI uri2 = new URI("/catalog/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//
//            URI resolvedUri1 = baseURI.resolve(uri1);
//            URI resolvedUri2 = baseURI.resolve(uri2);
//            URI resolvedUri3 = baseURI.resolve(uri3);
//
//            URL url1 = resolvedUri1.toURL();
//            System.out.println("url = " + url1);
//
//            URL url2 = resolvedUri2.toURL();
//            System.out.println("url = " + url2);
//
//            URL url3 = resolvedUri3.toURL();
//            System.out.println("url = " + url3);
//
//            URI relativizedURI = baseURI.relativize(resolvedUri2);
//            System.out.println("Relative URI = " + relativizedURI);

//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());


            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = "";
            while(line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();


//        } catch (URISyntaxException e) {
//            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}

package com.bengodwin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(15000);

            int responseCode = connection.getResponseCode();
            System.out.println("Respone code = " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//
//            for (Map.Entry<String, List<String>> entry: headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> values = entry.getValue();
//                System.out.println("------key = " + key);
//                for(String value: values) {
//                    System.out.println("value = " + value);
//                }
//            }



//        } catch (URISyntaxException e) {
//            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}

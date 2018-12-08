package com.jwojcik;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author jrwoj
 * createdOn 05.12.2018
 */
public class Helper {

    private static final String FILE_NAME = "wyniki.txt";

    public static void saveToFile(HashMap<String, Integer> paramMap) {
        saveToFile(paramMap, FILE_NAME);
    }


    public static void saveToFile(HashMap<String, Integer> paramMap, String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (String key : paramMap.keySet()) {
                fw.write(key + ": " + paramMap.get(key) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> readResults() {
//        String line = "";
//        HashMap results = new HashMap();
//        File file = new File(FILE_NAME);
//        FileInputStream fis = null;
//        BufferedReader br = null;
//        try {
//            fis = new FileInputStream(file);
//            br = new BufferedReader(new InputStreamReader(fis));
//            while ((line = br.readLine()) != null) {
//                String[] elem = line.split(":");
//                results.put(elem[0], Integer.parseInt(elem[1]));
//            }
//            br.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Nie znaleziono pliku!");
//        } catch (IOException e) {
//            System.out.println("Błąd odczytu pliku!");
//        }
//
//        return results;
        Map<String, Integer> paramsFromFile = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {

            stream.forEach(line -> {
                String[] entry = line.split(":");
                paramsFromFile.put(entry[0].trim(), Integer.parseInt(entry[1].trim()));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return paramsFromFile;
    }
}

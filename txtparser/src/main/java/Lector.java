package txtparser.src.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lector {

    
    public static String obtenerTxt(File dir) {        
        for (File file : dir.listFiles()) {
            String filePath = file.getPath();
                if (file.isFile() && filePath.endsWith(".txt")) {
                System.out.println(filePath);
                return filePath;
        }
    }
        return null;
    }
     public static String leerArchivo(String file) throws IOException {
        BufferedReader txt;
        String linea;
        String archivo = "";
        
        txt = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        try {
            while ((linea = txt.readLine()) != null) {
                archivo += linea + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            txt.close();
        }
        return archivo;
    }
}

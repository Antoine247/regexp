package main.java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;

import org.apache.commons.io.*;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
public class Lector {

     
    
    public static ArrayList<File> obtenerTxt(File dir) { 
        if(DirectoryFileFilter.DIRECTORY.accept(dir)){
            ArrayList<File> files = new ArrayList<File>();
        for (File file : FileUtils.listFiles(dir,   new SuffixFileFilter(".txt"), null)) {
            String filePath = file.getPath();
                if (file.isFile() && filePath.endsWith(".txt")) {
                    Main.LOGGER.log(Level.INFO, "se encontro archivo: " + file.getName());
                    files.add(file);
        }
    }
    if (files.isEmpty()){
        Main.LOGGER.log(Level.INFO, "no se encontro ningun archivo txt");
    }
        return files;
        } else {
            Main.LOGGER.log(Level.SEVERE, "el path colocado no es un directorio valido");
            System.exit(0);
            return null;
        }
    }
     public static String leerArchivo(File file) throws IOException {
        BufferedReader txt;
        String linea;
        String archivo = "";
        
        txt = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        try {
            while ((linea = txt.readLine()) != null) {
                archivo += linea + "\n";
            }
        } catch (Exception e) {
            Main.LOGGER.log(Level.SEVERE, "ocurrio un error leyendo los txts", e);
            e.printStackTrace();
        } finally {
            txt.close();
        }
        return archivo;
    }
}

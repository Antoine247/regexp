package main.java;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.Normalizer;
import java.util.logging.Level;

public class Impresor {

     public static void escribirArchivo(String txt, File nombre, String path) throws IOException {
        Writer escribe = null;
        String nombreNormalizado =  Normalizer.normalize(nombre.getName(), Normalizer.Form.NFD);
        nombreNormalizado = nombreNormalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        File archivo = new File(path, nombreNormalizado);
        try {
            escribe = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(archivo), "UTF-8"));
            escribe.write(txt);
            Main.LOGGER.log(Level.INFO, "se escribio el txt " + nombreNormalizado);
        } catch (Exception e) {
            Main.LOGGER.log(Level.SEVERE, "Error en la escritura del txt", e);
            e.printStackTrace();
        } finally {

            escribe.close();
            if(!nombreNormalizado.equalsIgnoreCase(nombre.getName())){
                File borrar = new File(path, nombre.getName());
                if(borrar.exists()){
                    borrar.delete();
                }
            }
        }
    }
}


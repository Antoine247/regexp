package txtparser.src.main.java;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Impresor {

     public static void escribirArchivo(String txt) throws IOException {
        Writer escribe = null;
        try {
            escribe = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("./txtparser/src/main/resources/resultadoprueba.txt"), "UTF8"));
            escribe.write(txt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            escribe.close();
        }
    }
}

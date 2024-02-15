package txtparser.src.main.java;

import java.io.File;
import java.io.IOException;

public class Main{

    public static File directorio = new File("./txtparser/src/main/resources/");
    public Informe informe;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.informe = new Informe();
        
        String archivo = Lector.leerArchivo();
        Impresor.escribirArchivo(archivo);
    }  
}

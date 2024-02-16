package txtparser.src.main.java;

import java.io.File;
import java.io.IOException;

import txtparser.src.test.java.TestMain;

public class Main{

    Informe informe;
    public static File directorio = new File("./txtparser/src/main/resources/");
    public static void main(String[] args)  {
        TestMain test = new TestMain();
        try {
            test.runTests();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void start() throws IOException{
        Main main = new Main();
        main.informe = new Informe();
        ApParser parser = new ApParser();
        String archivo = Lector.leerArchivo(Lector.obtenerTxt(directorio));
        parser.filtroRegexp(archivo, main.informe);
    }
}

package txtparser.src.test.java;
import java.io.File;
import java.util.ArrayList;

import txtparser.src.main.java.*;
public class TestMain {

    public void runTests(){
         ArrayList<File> archivoPrueba = new ArrayList<File>();
         ArrayList<Informe> informesPrueba = new ArrayList<Informe>();
         ApParser parser = new ApParser();
         for (int i = 0; i < 12; i++) {
            File file = new File("./txtparser/src/test/resources/test" + (i+1) + ".txt");
            archivoPrueba.add(file);
            informesPrueba.add(new Informe());

            try {
                String archivo = Lector.leerArchivo(file.getAbsolutePath());
                System.out.println(file.getName());
                Informe result = parser.filtrar(archivo);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            

            
         }
        


    }
    
}

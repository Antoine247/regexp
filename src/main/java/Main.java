package main.java;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main{
    public static final Logger LOGGER = Logger.getLogger("Main");

    public FileHandler fh = null;
    public static void main(String[] args)  {
        Main main = new Main();
        try {
            LOGGER.setUseParentHandlers(false);
          if (args.length > 1) {
            main.logging(); 
          }
            main.start(args[0]);
        } catch (Exception e) {
             Main.LOGGER.log(Level.SEVERE, "ocurrio un error en main", e);
           e.printStackTrace();
        }
     /*    TestMain test = new TestMain();
        try {
            test.runTests();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void logging() {
        SimpleDateFormat format = new SimpleDateFormat("d-M-yyyy_HH-mm-ss");
        try {
            fh = new FileHandler("/export/home0/acct/maestros/tmp/anatpatparser"
                + format.format(Calendar.getInstance().getTime()) + ".log");
        } catch (Exception e) {
            e.printStackTrace();
        }

        fh.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fh);
    }
    
    public void start(String file) throws IOException{
        File archivo =  new File(file);
        Main.LOGGER.log(Level.INFO, "path a usar " + archivo.getAbsolutePath());
        ApParser parser = new ApParser();
        ArrayList<File> txts = Lector.obtenerTxt(archivo);
        for (File txtfile : txts) {
            Informe informeActual = new Informe();
            String txt = Lector.leerArchivo(txtfile);
            if(!txt.isEmpty() || txt.length() > 20){
                String newTxt = parser.filtrar(txt, informeActual);
            Impresor.escribirArchivo(newTxt, txtfile, file);
            Main.LOGGER.log(Level.INFO, "finalizo programa para txt " + txtfile);
            }else{
                Main.LOGGER.log(Level.INFO, "archivo de nombre " + txtfile + " no se proceso.");
            }
            
        }
        System.out.println("programa finalizado exitosamente");
    }
}

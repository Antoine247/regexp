package txtparser.src.main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApParser {

    public Informe filtrar(String txt){
        Informe informe = new Informe();
        String parsedtxt;
        parsedtxt = filtroPie(txt, informe);
        parsedtxt = filtroTitulo(parsedtxt, informe);
        System.out.println(parsedtxt);
        return informe;
    }

    public String filtroTitulo(String toparse, Informe informe){
        String result = toparse.replaceFirst("^Laboratorio de Anatomía Patológica\\sRed Pathology\\s", "");
        informe.setTitulo(this.regexProcessor("EXAMEN.*$|Examen.*$|Informe.*$|INFORME.*$", result));
        result = result.replaceFirst("EXAMEN.*$|Examen.*$|Informe.*$|INFORME.*$", "");
        return result;
    }

    public String filtroPie(String toparse, Informe informe){
        informe.setPie(this.regexProcessor("(?s)\\bInforme confidencial(.*?)\\bcom.", toparse));
        String result = toparse.replaceAll("(?s)\\bInforme confidencial(.*?)\\bcom.", "");
        return result;
    }

    public String regexProcessor(String regex, String text){
        Matcher m = Pattern.compile(regex).matcher(text);
        if(m.find())
        {
            return m.group();
        } else {
            return "patron no encontrado";
        }
    }


    
    public void filtroRegexp(String txt, Informe informe){
        Matcher nombrePaciente = Pattern.compile("([A-ZÑ]){2,}(\\s([A-ZÑ]){2,})?,\\s([A-ZÑ]){2,}(\\s([A-ZÑ]){2,})?").matcher(txt);
        Matcher nombreMedico = Pattern.compile("[A-ZÑ]([a-zñ]){2,}(\\s[A-ZÑ]([a-zñ]){2,})?,\\s[A-ZÑ]([a-zñ]){2,}(\\s[A-ZÑ]([a-zñ]){2,})?|[A-ZÑ]([a-zñ]){2,}(\\s[A-ZÑ]([a-zñ]){2,})?,\\s([A-ZÑ]\\.){0,3}\\s?([A-ZÑ]([a-zñ])+)?").matcher(txt);
        Matcher numeroProtocoloAfiliado = Pattern.compile("[\\d]{5,8}").matcher(txt);
        Matcher patronAfiliado = Pattern.compile("(?<=Afil/DNI/HC: |Afiliado/DNI: )[\\d]{5,8}").matcher(txt);
        Matcher procedencia = Pattern.compile("#([A-Z])+(\\s([A-Z])+)?|([A-Z]\\.){1,}(\\s([A-Z])+)?|([A-Z])+\\s([A-Z]\\.){1,}?").matcher(txt);
        if(nombrePaciente.find()){
            informe.setPaciente(nombrePaciente.group());
            System.out.println("nombre de paciente: " + informe.getPaciente());
        } else {
            System.out.println("no encontro match de paciente");
        }
        if(nombreMedico.find()){
            informe.setMedico(nombreMedico.group());
            System.out.println("nombre de medico: " + informe.getMedico());
        } else {
            informe.setMedico("No especificado");
            System.out.println("no encontro match de medico");
        }
        if(numeroProtocoloAfiliado.find()){
            informe.setProtocolo(numeroProtocoloAfiliado.group());
            System.out.println("numero de protocolo " + informe.getProtocolo());
            if(patronAfiliado.find()){
                informe.setAfiliado(patronAfiliado.group());
                System.out.println("numero afiliado/dni " + informe.getAfiliado());
            } else {
                if (numeroProtocoloAfiliado.find()) {
                    informe.setAfiliado(numeroProtocoloAfiliado.group());
                System.out.println("numero afiliado/dni " + informe.getAfiliado());
                } else {
                    System.out.println("no encontro numero de afiliado");
                }
            }
        } else {
            System.out.println("no encontro match de protocolo");
        }
        if(procedencia.find()){
            informe.setProcedencia(procedencia.group());
            System.out.print(informe.getProcedencia());
        } else {
            System.out.println("no encontro numero de afiliado");
        }

        
        
        




    }

}

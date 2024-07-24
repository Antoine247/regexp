package main.java;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApParser {

    String labelRegex = "Paciente:\\s|Protocolo:\\s|Médico:\\s|Médica\\/o:\\s|Procedencia:\\s|Fecha:\\s|Edad:\\s|Página:\\s|Pagina:\\s";
    String laboratorioRegex = "^Laboratorio de Anatomía Patológica\\sRed Pathology\\s";
    String tituloRegex = "EXAMEN.*$|Examen.*$|Informe.*$|INFORME.*$";
    String pacienteRegex = "([A-ZÑ]){2,}(\\s([A-ZÑ]){2,})?,\\s([A-ZÑ]){2,}(\\s([A-ZÑ]){2,})?";
    String medicoRegex = "[A-ZÑ]([a-zñ]){2,}(\\s[A-ZÑ]([a-zñ]){2,})?,\\s[A-ZÑ]([a-zñ]){2,}(\\s[A-ZÑ]([a-zñ]){2,})?|[A-ZÑ]([a-zñ]){2,}(\\s[A-ZÑ]([a-zñ]){2,})?,\\s([A-ZÑ]\\.){0,3}\\s?([A-ZÑ]([a-zñ])+)?";
    String pieRegex = "(?s)\\bInforme confidencial(.*?)\\bcom.";
    String numeroRegex = "[\\d]{5,8}";
    String afiliadoRegex = "(?<=Afil/DNI/HC: |Afiliado/DNI: )[\\d]{5,8}";
    String fechaRegex = "\\d{1,2}/\\D{1,3}/\\d{2,4}\\s";
    String edadRegex = "^\\b\\d{1,2}\\n";
    String parsedRegex = "^\\*\\s";


    public String filtrar(String txt, Informe informe){
        String parsedtxt;
        if(isFiltered(txt)){
            return txt;
        }
        parsedtxt = filtroPie(txt, informe);
        parsedtxt = filtroTitulo(parsedtxt, informe);
        parsedtxt = filtroProtocolo(parsedtxt, informe);
        parsedtxt = filtroPacienteMedico(parsedtxt, informe);
        parsedtxt = filtroLabels(parsedtxt);
        parsedtxt = filtroAfiliado(parsedtxt, informe);
        parsedtxt = filtroFecha(parsedtxt, informe);
        parsedtxt = filtroOS(parsedtxt, informe);
        parsedtxt = filtroEdad(parsedtxt, informe);
        parsedtxt = parsedtxt.trim();
        if(parsedtxt.charAt(parsedtxt.length() -1) == '2'){
            parsedtxt = parsedtxt.substring(0, parsedtxt.length() -1);
        }
        informe.setCuerpo(parsedtxt);
        return informe.ordernar();
    }

    private String filtroAfiliado(String toparse, Informe informe){
        String afiliado = this.regexProcessor(afiliadoRegex, toparse);
        String result = "";
        if(afiliado == "patron no encontrado"){
            informe.setAfiliado(this.regexProcessor(numeroRegex, toparse));
            result = toparse.replaceFirst(numeroRegex, "");
            result = result.replaceAll("\\bAfil(.*?)\\b:\\s", "");
        }else {
            informe.setAfiliado(afiliado);
            result = toparse.replaceAll("\\bAfil(.*?)\\b[0-9]{5,8}\\s", "");
        }
        return result;
    }

    private boolean isFiltered(String txt){
        Boolean bool = false;
        Matcher m = Pattern.compile(parsedRegex).matcher(txt);
        if(m.find())
        {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }
    
    private String filtroEdad(String toparse, Informe informe){
        String edad = this.regexProcessor(edadRegex, toparse);
        informe.setEdad(edad);
        String result = toparse.replaceFirst(edad, "");
        return result;
    }
    private String filtroOS(String toparse, Informe informe){
        String[] results;
        results = toparse.trim().split("\\n", 2);
        informe.setObraSocial(results[0]);
        return results[1];
    }
    private String filtroFecha(String toparse, Informe informe){
        String fecha = this.regexProcessor(fechaRegex, toparse);
        informe.setFecha(fecha.trim());
        String result = toparse.replaceAll(fecha, "");
        return result;
    }
    private String filtroProtocolo(String toparse, Informe informe){
        informe.setProtocolo(this.regexProcessor(numeroRegex, toparse));
        String result = toparse.replaceAll(informe.getProtocolo(), "");
        return result;
    }
    private String filtroLabels(String toparse){
            String result = toparse.replaceAll(labelRegex, "");
            return result;
    }
    private String filtroTitulo(String toparse, Informe informe){
        String result = toparse.replaceFirst(laboratorioRegex, "");
        informe.setTitulo(this.regexProcessor(tituloRegex, result));
        result = Pattern.compile(tituloRegex, Pattern.MULTILINE).matcher(result).replaceFirst("");
        return result;
    }

    private String filtroPacienteMedico(String toparse, Informe informe){
        String medico = this.regexProcessor(medicoRegex, toparse);
        String paciente = this.regexProcessor(pacienteRegex, toparse);
        String result;
        informe.setPaciente(paciente);
        result = toparse.replaceAll(paciente, "");
        if(medico == "patron no encontrado"){
            informe.setMedico("No especificado");
            result = result.replaceAll("No especificado\\s", "");
        } else{
            informe.setMedico(medico);
            result = result.replaceAll(medicoRegex, "");
        }
        return result;
    }

    private String filtroPie(String toparse, Informe informe){
        informe.setPie(this.regexProcessor(pieRegex, toparse));
        String result = toparse.replaceAll(pieRegex, "");
        return result;
    }

    private String regexProcessor(String regex, String text){
        Matcher m = Pattern.compile(regex, Pattern.MULTILINE).matcher(text);
        if(m.find())
        {
            return m.group();
        } else {
            return "patron no encontrado";
        }
    }
}

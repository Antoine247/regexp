package main.java;
public class Informe {
    
    private String titulo,
        paciente,
        protocolo,
        medico,
        fecha,
        afiliado,
        obraSocial,
        edad,
        cuerpo,
        pie;   


    public String ordernar(){
        String resultado = "";
        resultado = "*\n" + this.getTitulo() + 
            "\nPaciente: " +
            this.getPaciente() +
            "\nProtocolo: " +
            this.getProtocolo() + 
            "\nMédico\\a: " +
            this.getMedico() + 
            "\nProcedencia: " +
            this.getObraSocial() +
            "\nFecha: " +
            this.getFecha() +
            "\nAfiliado/DNI: " +
            this.getAfiliado() +
            "\nEdad: " +
            this.getEdad() + "\n" +
            this.getCuerpo() + "\n" +
            this.getPie();
        return resultado;
    }

    public String getObraSocial() {
        return this.obraSocial;
    }
    public void setObraSocial(String input) {
        this.obraSocial = input;
    }
    public String getPie() {
        return this.pie;
    }
    public void setPie(String input) {
        this.pie = input;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String input) {
        this.titulo = input;
    }
    public String getPaciente() {
        return this.paciente;
    }
    public void setPaciente(String input) {
        this.paciente = input;
    }
    public String getProtocolo() {
        return this.protocolo;
    }
    public void setProtocolo(String input) {
        this.protocolo = input;
    }
    public String getMedico() {
        return this.medico;
    }
    public void setMedico(String input) {
        this.medico = input;
    }
    public String getFecha() {
        return this.fecha;
    }
    public void setFecha(String input) {
        this.fecha = input;
    }
    public String getAfiliado() {
        return this.afiliado;
    }
    public void setAfiliado(String input) {
        this.afiliado = input;
    }
    public String getEdad() {
        return this.edad;
    }
    public void setEdad(String input) {
        this.edad = input;
    }
    public String getCuerpo() {
        return this.cuerpo;
    }
    public void setCuerpo(String input) {
        this.cuerpo = input;
    }
}



package txtparser.src.main.java;

public class Informe {
    
    private String titulo,
        paciente,
        protocolo,
        medico,
        procedencia,
        fecha,
        afiliado,
        edad,
        tituloInforme,
        cuerpo,
        pie;   


    public String ordernar(){
        String resultado = "";
        resultado = this.getTitulo() + 
            "\nPaciente:\n" +
            this.getPaciente() +
            "\nProtocolo:\n" +
            this.getProtocolo() + 
            "\nMedico\\a:\n" +
            this.getMedico() + 
            "\nProcedencia:\n" +
            this.getProcedencia() +
            "\nFecha\n" +
            this.getFecha() +
            "\nAfiliado/DNI\n" +
            this.getAfiliado() +
            "\nEdad:\n" +
            this.getEdad() + "\n" +
            this.getTituloInforme() + "\n" +
            this.getCuerpo() + "\n" +
            this.getPie();
        return resultado;
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
    public String getProcedencia() {
        return this.procedencia;
    }
    public void setProcedencia(String input) {
        this.procedencia = input;
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
    public String getTituloInforme() {
        return this.tituloInforme;
    }
    public void setTituloInforme(String input) {
        this.tituloInforme = input;
    }
    public String getCuerpo() {
        return this.cuerpo;
    }
    public void setCuerpo(String input) {
        this.cuerpo = input;
    }
}



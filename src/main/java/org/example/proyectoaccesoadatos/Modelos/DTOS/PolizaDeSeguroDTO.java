package org.example.proyectoaccesoadatos.Modelos.DTOS;

public class PolizaDeSeguroDTO {
    private Long id;
    private String numeroDePoliza;
    private String companiaAseguradora;
    private String tipo_cobertura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDePoliza() {
        return numeroDePoliza;
    }

    public void setNumeroDePoliza(String numeroDePoliza) {
        this.numeroDePoliza = numeroDePoliza;
    }

    public String getCompaniaAseguradora() {
        return companiaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        this.companiaAseguradora = companiaAseguradora;
    }

    public String getTipo_cobertura() {
        return tipo_cobertura;
    }

    public void setTipo_cobertura(String tipo_cobertura) {
        this.tipo_cobertura = tipo_cobertura;
    }
}



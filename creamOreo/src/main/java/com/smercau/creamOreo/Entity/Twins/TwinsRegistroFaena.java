package com.smercau.creamOreo.Entity.Twins;

import jakarta.persistence.*;

@Entity
@Table (name="FAENA")
public class TwinsRegistroFaena {

    @Id
    @Column (name="NC_F")
    private Long id;

    @Column (name="codbar")
    private Long codigoDeBarras;

    @Column (name="FECHA")
    private String fechaFaena;

    @Column (name="HORA")
    private String horaFaena;

    @Column (name="PESO_CARCAZA")
    private double pesoFaena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(Long codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getFechaFaena() {
        return fechaFaena;
    }

    public void setFechaFaena(String fechaFaena) {
        this.fechaFaena = fechaFaena;
    }

    public String getHoraFaena() {
        return horaFaena;
    }

    public void setHoraFaena(String horaFaena) {
        this.horaFaena = horaFaena;
    }

    public double getPesoFaena() {
        return pesoFaena;
    }

    public void setPesoFaena(double pesoFaena) {
        this.pesoFaena = pesoFaena;
    }

    @Override
    public String toString() {
        return "TwinsRegistroFaena{" +
                "id=" + id +
                ", codigoDeBarras=" + codigoDeBarras +
                ", fechaFaena='" + fechaFaena + '\'' +
                ", horaFaena='" + horaFaena + '\'' +
                ", pesoFaena=" + pesoFaena +
                '}';
    }
}

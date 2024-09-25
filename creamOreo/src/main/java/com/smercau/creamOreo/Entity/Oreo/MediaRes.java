package com.smercau.creamOreo.Entity.Oreo;


import jakarta.persistence.*;

import java.util.Date;
@Entity
public class MediaRes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="codbar")
    private Long codbar;

    @Column (name="tropa")
    private int Tropa;

    @Column (name="camara")
    private String camara;

    @Column (name="peso_faena")
    private Double pesoFaena;

    @Column (name="peso_oreo")
    private Double pesoOreo;

    @Column (name="fechaHoraFaena")
    private Date fechayHoraFaena;

    @Column (name="fechaHoraOreo")
    private Date fechaYHoraOreo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodbar() {
        return codbar;
    }

    public void setCodbar(Long codbar) {
        this.codbar = codbar;
    }

    public int getTropa() {
        return Tropa;
    }

    public void setTropa(int tropa) {
        Tropa = tropa;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public Double getPesoFaena() {
        return pesoFaena;
    }

    public void setPesoFaena(Double pesoFaena) {
        this.pesoFaena = pesoFaena;
    }

    public Double getPesoOreo() {
        return pesoOreo;
    }

    public void setPesoOreo(Double pesoOreo) {
        this.pesoOreo = pesoOreo;
    }

    public Date getFechayHoraFaena() {
        return fechayHoraFaena;
    }

    public void setFechayHoraFaena(Date fechayHoraFaena) {
        this.fechayHoraFaena = fechayHoraFaena;
    }

    public Date getFechaYHoraOreo() {
        return fechaYHoraOreo;
    }

    public void setFechaYHoraOreo(Date fechaYHoraOreo) {
        this.fechaYHoraOreo = fechaYHoraOreo;
    }

    @Override
    public String toString() {
        return "MediaRes{" +
                "id=" + id +
                ", codbar=" + codbar +
                ", Tropa=" + Tropa +
                ", camara='" + camara + '\'' +
                ", pesoFaena=" + pesoFaena +
                ", pesoOreo=" + pesoOreo +
                ", fechayHoraFaena=" + fechayHoraFaena +
                ", fechaYHoraOreo=" + fechaYHoraOreo +
                '}';
    }
}

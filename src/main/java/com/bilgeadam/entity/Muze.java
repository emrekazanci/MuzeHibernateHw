package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Muze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String muzeAdi;
    private String muzeSehri;
    private String acilisSaati;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "muze")
    private List<Sergi> sergiler;

    public Muze(String muzeAdi, String muzeSehri, String acilisSaati) {
        this.muzeAdi = muzeAdi;
        this.muzeSehri = muzeSehri;
        this.acilisSaati = acilisSaati;
    }

    public Muze(Integer id, String muzeAdi, String muzeSehri, String acilisSaati, List<Sergi> sergiler) {
        this.id = id;
        this.muzeAdi = muzeAdi;
        this.muzeSehri = muzeSehri;
        this.acilisSaati = acilisSaati;
        this.sergiler = sergiler;
    }
}

package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sanatci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sanatciAdi;
    private int dogumYili;
    private int olumYili;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sanatci")
    private List<Eser> eserler;

    public Sanatci(String sanatciAdi, int dogumYili, int olumYili) {
        this.sanatciAdi = sanatciAdi;
        this.dogumYili = dogumYili;
        this.olumYili = olumYili;
    }

    public Sanatci(Integer id, String sanatciAdi, int dogumYili, int olumYili, List<Eser> eserler) {
        this.id = id;
        this.sanatciAdi = sanatciAdi;
        this.dogumYili = dogumYili;
        this.olumYili = olumYili;
        this.eserler = eserler;
    }
}

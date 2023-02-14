package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Sergi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sergiAdi;
    private String baslangicTarihi;
    private String bitisTarihi;
    private String konu;

    @ManyToOne(cascade = CascadeType.ALL)
    private Muze muze;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Eser> eserler;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Ziyaretci> ziyaretler;

    public Sergi(Integer id) {
        this.id = id;
    }

    public Sergi(String sergiAdi, String baslangicTarihi, String bitisTarihi, String konu, Muze muze, List<Eser> eserler, Set<Ziyaretci> ziyaretler) {
        this.sergiAdi = sergiAdi;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.konu = konu;
        this.muze = muze;
        this.eserler = eserler;
        this.ziyaretler = ziyaretler;
    }

    public Sergi(Integer id, String sergiAdi, String baslangicTarihi, String bitisTarihi, String konu, Muze muze, List<Eser> eserler, Set<Ziyaretci> ziyaretler) {
        this.id = id;
        this.sergiAdi = sergiAdi;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.konu = konu;
        this.muze = muze;
        this.eserler = eserler;
        this.ziyaretler = ziyaretler;
    }
}

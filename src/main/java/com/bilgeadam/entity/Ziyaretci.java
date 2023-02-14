package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ziyaretci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ziyaretciAdi;
    private int yas;
    private long telNo;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Sergi> sergiler;

    public Ziyaretci(String ziyaretciAdi, int yas, long telNo) {
        this.ziyaretciAdi = ziyaretciAdi;
        this.yas = yas;
        this.telNo = telNo;
    }

    public Ziyaretci(Integer id, String ziyaretciAdi, int yas, long telNo) {
        this.id = id;
        this.ziyaretciAdi = ziyaretciAdi;
        this.yas = yas;
        this.telNo = telNo;
    }
}

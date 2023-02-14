package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.SergiDao;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SergiService {
    static SergiDao sergiDao = new SergiDao();
    static Set<Ziyaretci> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        //save();
        //update();
        //delete();
        findAll();
    }

    public static void save() {
        try {

            Ziyaretci ziyaretci1 = new Ziyaretci("Ziyaretçi1", 12, 1312313L);
            Ziyaretci ziyaretci2 = new Ziyaretci("Ziyaretçi2", 24, 88471231L);
            set.add(ziyaretci1);
            set.add(ziyaretci2);

            Sanatci sanatci1 = new Sanatci("Yeni sanatçı", 1957, 1999);
            Sanatci sanatci2 = new Sanatci("Yeni sanatçı", 1975, 2007);
            Eser eser1 = new Eser("Yeni eser1", 1997, sanatci1);
            Eser eser2 = new Eser("Yeni eser2", 1978, sanatci2);
            Muze muze = new Muze("Yeni müze", "Ankara", "07.00");
            Sergi sergi = new Sergi("Yeni sergi", "01.01.2023", "05.01.2023",
                    "Yeni konu", muze, Arrays.asList(eser1, eser2), set);
            sergiDao.save(sergi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try {
            Ziyaretci ziyaretci1 = new Ziyaretci("Güncel ziyaretçi1", 32, 88777442L);
            set.add(ziyaretci1);
            Sanatci sanatci1 = new Sanatci("Güncel sanatçı", 1957, 1999);
            Eser eser1 = new Eser("Güncel eser1", 1997, sanatci1);
            Muze muze = new Muze("Güncel müze", "Ankara", "07.00");
            Sergi sergi = new Sergi(2, "Güncel Sergi", "10.10.2023", "15.11.2023",
                    "Güncel konu", muze, Arrays.asList(eser1), set);
            sergiDao.update(sergi);
        } catch (Exception e) {

        }
    }

    public static void delete() {
        try {
            sergiDao.delete(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        try {
            List<Sergi> list = sergiDao.findAll();
            for (Sergi item : list) {

                System.out.println("Sergi ID: " + item.getId()
                        + ", Sergi Adı: " + item.getSergiAdi()
                        + ", Sergi Başlangıç: " + item.getBaslangicTarihi()
                        + ", Sergi Bitiş: " + item.getBitisTarihi()
                        + ", Sergi Konu: " + item.getKonu()
                        + ", Sergi'nin Müze ID: " + item.getMuze().getId()
                        + ", Sergi'nin Müze Adı: " + item.getMuze().getMuzeAdi()
                        + ", Sergi'nin Müze Şehir: " + item.getMuze().getMuzeSehri()

                );
                for (Eser item2 : item.getEserler()) {
                    System.out.println("    Eser ID: " + item2.getId()
                            + ", Eser Adı: " + item2.getEserAdi()
                            + ", Eser Yapım Yılı: " + item2.getYapimYili()
                            + ", Sanaçtı ID: " + item2.getSanatci().getId()
                            + ", Sanatçı Adı: " + item2.getSanatci().getSanatciAdi()
                            + ", Sanatçı Doğum Yılı: " + item2.getSanatci().getDogumYili()
                            + ", Sanatçı Ölüm Yılı: " + item2.getSanatci().getOlumYili()
                    );
                }
                for (Ziyaretci item3 : item.getZiyaretler()) {
                    System.out.println("    Ziyaretçi ID: " + item3.getId()
                            + ", Ziyaretçi Adı: " + item3.getZiyaretciAdi()
                            + ", Ziyaretçi Yaşı: " + item3.getYas()
                            + ", Ziyaretçi Telefon No: " + item3.getTelNo()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

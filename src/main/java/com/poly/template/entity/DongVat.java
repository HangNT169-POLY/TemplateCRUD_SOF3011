package com.poly.template.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author hangnt169
 */
@Entity
@Table(name = "dong_vat")
public class DongVat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "can_nang")
    private Float canNang;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "nam_sinh")
    private Integer namSinh;

    public DongVat() {
    }

    public DongVat(Long id, String ten, Float canNang, Boolean gioiTinh, Integer namSinh) {
        this.id = id;
        this.ten = ten;
        this.canNang = canNang;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public DongVat(String ten, Float canNang, Boolean gioiTinh, Integer namSinh) {
        this.ten = ten;
        this.canNang = canNang;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getCanNang() {
        return canNang;
    }

    public void setCanNang(Float canNang) {
        this.canNang = canNang;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return "DongVat{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", canNang=" + canNang +
                ", gioiTinh=" + gioiTinh +
                ", namSinh=" + namSinh +
                '}';
    }
}

package com.student.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Ordetails {
    private Integer odid;
    private Integer num;
    private BigDecimal gPrice;

    private Orders myorder;
    private Product myproduct;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odid", nullable = false)
    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    @Basic
    @Column(name = "num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "g_price", nullable = true, precision = 2)
    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordetails ordetails = (Ordetails) o;
        return Objects.equals(odid, ordetails.odid) && Objects.equals(num, ordetails.num) && Objects.equals(gPrice, ordetails.gPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odid, num, gPrice);
    }

    @ManyToOne
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    public Orders getMyorder() {
        return myorder;
    }

    public void setMyorder(Orders myorder) {
        this.myorder = myorder;
    }

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    public Product getMyproduct() {
        return myproduct;
    }

    public void setMyproduct(Product myproduct) {
        this.myproduct = myproduct;
    }
}

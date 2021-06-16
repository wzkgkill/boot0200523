package com.student.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
//@JsonIgnoreProperties(value = {"heandler"})
//mybatis  实现子查询 如果 serializable 序列化 报错 解决方案如果下
public class Orders {
    private Integer oid;
    private Integer uid;
    private String oState;
    private Timestamp oTime;
    private String oConsignee;
    private String oPhone;
    private String oAddress;

    private BigDecimal oRental;



    private List<Ordetails> details;

    @GeneratedValue (strategy = GenerationType.IDENTITY) /*默认是 auto 会自动  然后会选择 */
    @Id
    @Column(name = "oid", nullable = true)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "o_state", nullable = true, length = 3)
    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    @Basic
    @Column(name = "o_time", nullable = true)
    public Timestamp getoTime() {
        return oTime;
    }

    public void setoTime(Timestamp oTime) {
        this.oTime = oTime;
    }

    @Basic
    @Column(name = "o_consignee", nullable = true, length = 765)
    public String getoConsignee() {
        return oConsignee;
    }

    public void setoConsignee(String oConsignee) {
        this.oConsignee = oConsignee;
    }

    @Basic
    @Column(name = "o_phone", nullable = true, length = 11)
    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone;
    }

    @Basic
    @Column(name = "o_address", nullable = true, length = 765)
    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    @Basic
    @Column(name = "o_rental", nullable = true, precision = 2)
    public BigDecimal getoRental() {
        return oRental;
    }

    public void setoRental(BigDecimal oRental) {
        this.oRental = oRental;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(oid, orders.oid) && Objects.equals(uid, orders.uid) && Objects.equals(oState, orders.oState) && Objects.equals(oTime, orders.oTime) && Objects.equals(oConsignee, orders.oConsignee) && Objects.equals(oPhone, orders.oPhone) && Objects.equals(oAddress, orders.oAddress) && Objects.equals(oRental, orders.oRental);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, uid, oState, oTime, oConsignee, oPhone, oAddress, oRental);
    }

    @OneToMany(mappedBy = "myorder")
    public List<Ordetails> getDetails() {
        return details;
    }

    public void setDetails(List<Ordetails> details) {
        this.details = details;
    }
}

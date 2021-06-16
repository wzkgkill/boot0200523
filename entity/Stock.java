package entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Stock {
    private Integer sid;//采购详情编号

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    private String sorder;//订单号
    private String ssid;//商品编号
    private BigDecimal sprice;//进货价格
    private Integer sordersize;//进货数量

    //根据业务需求，添加临时字段***********
    private String name;//商品名称
    private String unit;//商品单位

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSorder() {
        return sorder;
    }

    public void setSorder(String sorder) {
        this.sorder = sorder;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public Integer getSordersize() {
        return sordersize;
    }

    public void setSordersize(Integer sordersize) {
        this.sordersize = sordersize;
    }

    public Stock(Integer sid, String sorder, String ssid, BigDecimal sprice, Integer sordersize) {
        super();
        this.sid = sid;
        this.sorder = sorder;
        this.ssid = ssid;
        this.sprice = sprice;
        this.sordersize = sordersize;
    }

    public Stock() {
        super();
    }

    @Override
    public String toString() {
        return "Stock [sid=" + sid + ", sorder=" + sorder + ", ssid=" + ssid + ", sprice=" + sprice + ", sordersize="
                + sordersize + "]";
    }


}

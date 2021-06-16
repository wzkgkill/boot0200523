package entity;

import java.math.BigDecimal;

import util.BaseDao;

public class JinHuo extends BaseDao {
    private String rorder;
    private String rsid;
    private String rname;
    private String rspec;
    private BigDecimal rprice;
    private String waudit;
    private Integer rnum;
    private BigDecimal mmoney;
    private BigDecimal danqian;

    public String getRorder() {
        return rorder;
    }

    public void setRorder(String rorder) {
        this.rorder = rorder;
    }

    public String getRsid() {
        return rsid;
    }

    public void setRsid(String rsid) {
        this.rsid = rsid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRspec() {
        return rspec;
    }

    public void setRspec(String rspec) {
        this.rspec = rspec;
    }

    public BigDecimal getRprice() {
        return rprice;
    }

    public void setRprice(BigDecimal rprice) {
        this.rprice = rprice;
    }

    public String getWaudit() {
        return waudit;
    }

    public void setWaudit(String waudit) {
        this.waudit = waudit;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public BigDecimal getMmoney() {
        return mmoney;
    }

    public void setMmoney(BigDecimal mmoney) {
        this.mmoney = mmoney;
    }

    public BigDecimal getDanqian() {
        return danqian;
    }

    public void setDanqian(BigDecimal danqian) {
        this.danqian = danqian;
    }

    public JinHuo(String rorder, String rsid, String rname, String rspec, BigDecimal rprice, String waudit,
                  Integer rnum, BigDecimal mmoney, BigDecimal danqian) {
        super();
        this.rorder = rorder;
        this.rsid = rsid;
        this.rname = rname;
        this.rspec = rspec;
        this.rprice = rprice;
        this.waudit = waudit;
        this.rnum = rnum;
        this.mmoney = mmoney;
        this.danqian = danqian;
    }

    public JinHuo() {
        super();
    }

    @Override
    public String toString() {
        return "JinHuo [rorder=" + rorder + ", rsid=" + rsid + ", rname=" + rname + ", rspec=" + rspec + ", rprice="
                + rprice + ", waudit=" + waudit + ", rnum=" + rnum + ", mmoney=" + mmoney + ", danqian=" + danqian
                + "]";
    }

}

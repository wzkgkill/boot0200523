package entity;

import java.math.BigDecimal;

public class Repertory {
    private String rsid;
    private String rname;
    private String rtype;
    private String rspec;
    private BigDecimal rprice;
    private BigDecimal rmprice;
    private Integer rcap;
    private Integer rfloor;
    private Integer rinventory;
    private String runit;
    private String radress;
    private String rcolor;

    public String getRunit() {
        return runit;
    }

    public void setRunit(String runit) {
        this.runit = runit;
    }

    public String getRadress() {
        return radress;
    }

    public void setRadress(String radress) {
        this.radress = radress;
    }

    public String getRcolor() {
        return rcolor;
    }

    public void setRcolor(String rcolor) {
        this.rcolor = rcolor;
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

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
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

    public BigDecimal getRmprice() {
        return rmprice;
    }

    public void setRmprice(BigDecimal rmprice) {
        this.rmprice = rmprice;
    }

    public Integer getRcap() {
        return rcap;
    }

    public void setRcap(Integer rcap) {
        this.rcap = rcap;
    }

    public Integer getRfloor() {
        return rfloor;
    }

    public void setRfloor(Integer rfloor) {
        this.rfloor = rfloor;
    }

    public Integer getRinventory() {
        return rinventory;
    }

    public void setRinventory(Integer rinventory) {
        this.rinventory = rinventory;
    }

    public Repertory(String rsid, String rname, String rtype, String rspec, BigDecimal rprice, BigDecimal rmprice,
                     Integer rcap, Integer rfloor, Integer rinventory, String runit, String radress, String rcolor) {
        super();
        this.rsid = rsid;
        this.rname = rname;
        this.rtype = rtype;
        this.rspec = rspec;
        this.rprice = rprice;
        this.rmprice = rmprice;
        this.rcap = rcap;
        this.rfloor = rfloor;
        this.rinventory = rinventory;
        this.runit = runit;
        this.radress = radress;
        this.rcolor = rcolor;
    }

    public Repertory() {
        super();
    }


}

package entity;

public class Supplier {
    private Integer supid;//供货商编号
    private String supname;//供货商名称
    private String suppeople;//联系人
    private String suptel;//联系电话
    private String supadress;//联系地址
    private String supbz;//备注
    private Boolean supstatu;//供货商状态

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSuppeople() {
        return suppeople;
    }

    public void setSuppeople(String suppeople) {
        this.suppeople = suppeople;
    }

    public String getSuptel() {
        return suptel;
    }

    public void setSuptel(String suptel) {
        this.suptel = suptel;
    }

    public String getSupadress() {
        return supadress;
    }

    public void setSupadress(String supadress) {
        this.supadress = supadress;
    }

    public String getSupbz() {
        return supbz;
    }

    public void setSupbz(String supbz) {
        this.supbz = supbz;
    }

    public Integer getSupid() {
        return supid;
    }

    public void setSupid(Integer supid) {
        this.supid = supid;
    }

    public Boolean getSupstatu() {
        return supstatu;
    }

    public void setSupstatu(Boolean supstatu) {
        this.supstatu = supstatu;
    }

    @Override
    public String toString() {
        return "Supplier [supid=" + supid + ", supname=" + supname + ", suppeople=" + suppeople + ", suptel=" + suptel
                + ", supadress=" + supadress + ", supbz=" + supbz + ", supstatu=" + supstatu + "]";
    }

    public Supplier(Integer supid, String supname, String suppeople, String suptel, String supadress, String supbz,
                    Boolean supstatu) {
        super();
        this.supid = supid;
        this.supname = supname;
        this.suppeople = suppeople;
        this.suptel = suptel;
        this.supadress = supadress;
        this.supbz = supbz;
        this.supstatu = supstatu;
    }

    public Supplier() {
        super();
    }


}

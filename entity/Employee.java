package entity;

public class Employee {
    private Integer psid;//员工id
    private String pname;//员工姓名
    private String plphone;//手机号
    private String ppwd;//员工密码
    private String pplace;//员工职位
    private Boolean pstatu;//员工工作状态
    private String pbz;//员工备注

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPlphone() {
        return plphone;
    }

    public void setPlphone(String plphone) {
        this.plphone = plphone;
    }

    public String getPpwd() {
        return ppwd;
    }

    public void setPpwd(String ppwd) {
        this.ppwd = ppwd;
    }

    public String getPplace() {
        return pplace;
    }

    public void setPplace(String pplace) {
        this.pplace = pplace;
    }

    public Boolean getPstatu() {
        return pstatu;
    }

    public void setPstatu(Boolean pstatu) {
        this.pstatu = pstatu;
    }

    public String getPbz() {
        return pbz;
    }

    public void setPbz(String pbz) {
        this.pbz = pbz;
    }

    public Employee() {
        super();
    }

    public Employee(Integer psid, String pname, String plphone, String ppwd, String pplace, Boolean pstatu,
                    String pbz) {
        super();
        this.psid = psid;
        this.pname = pname;
        this.plphone = plphone;
        this.ppwd = ppwd;
        this.pplace = pplace;
        this.pstatu = pstatu;
        this.pbz = pbz;
    }

    @Override
    public String toString() {
        return "Employee [psid=" + psid + ", pname=" + pname + ", plphone=" + plphone + ", ppwd=" + ppwd + ", pplace="
                + pplace + ", pstatu=" + pstatu + ", pbz=" + pbz + "]";
    }

}

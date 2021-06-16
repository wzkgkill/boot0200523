package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 采购订单表
 *
 * @author lenovo
 */
public class WareHouse {
    private String worder;
    private Date worderdata;
    private String wsource;
    private BigDecimal wypay;
    private BigDecimal wspaid;
    //private String  waudit;
    private String wauditor;

    //private Date wauditortime;
    public String getWorder() {
        return worder;
    }

    public void setWorder(String worder) {
        this.worder = worder;
    }

    public Date getWorderdata() {
        return worderdata;
    }

    public void setWorderdata(Date worderdata) {
        this.worderdata = worderdata;
    }

    public String getWsource() {
        return wsource;
    }

    public void setWsource(String wsource) {
        this.wsource = wsource;
    }

    public BigDecimal getWypay() {
        return wypay;
    }

    public void setWypay(BigDecimal wypay) {
        this.wypay = wypay;
    }

    public BigDecimal getWspaid() {
        return wspaid;
    }

    public void setWspaid(BigDecimal wspaid) {
        this.wspaid = wspaid;
    }

    //	public String getWaudit() {
//		return waudit;
//	}
//	public void setWaudit(String waudit) {
//		this.waudit = waudit;
//	}
    public String getWauditor() {
        return wauditor;
    }

    public void setWauditor(String wauditor) {
        this.wauditor = wauditor;
    }
//	public Date getWauditortime() {
//		return wauditortime;
//	}
//	public void setWauditortime(Date wauditortime) {
//		this.wauditortime = wauditortime;
//	}
//	@Override
//	public String toString() {
//		return "WareHouse [worder=" + worder + ", worderdata=" + worderdata + ",  wsource=" + wsource + ", wypay=" + wypay + ", wspaid=" + wspaid + ", waudit=" + waudit
//				+ ", wauditor=" + wauditor + ", wauditortime=" + wauditortime + "]";
//	}
//	public WareHouse(String worder, Date worderdata, String wsource, BigDecimal wypay,
//			BigDecimal wspaid, String waudit, String wauditor, Date wauditortime) {
//		super();
//		this.worder = worder;
//		this.worderdata = worderdata;
//		this.wsource = wsource;
//		this.wypay = wypay;
//		this.wspaid = wspaid;
//		this.waudit = waudit;
//		this.wauditor = wauditor;
//		this.wauditortime = wauditortime;
//	}

    public WareHouse() {
        super();
    }

    public WareHouse(String worder, Date worderdata, String wsource, BigDecimal wypay, BigDecimal wspaid, String wauditor) {
        super();
        this.worder = worder;
        this.worderdata = worderdata;
        this.wsource = wsource;
        this.wypay = wypay;
        this.wspaid = wspaid;
        this.wauditor = wauditor;
    }

    @Override
    public String toString() {
        return "WareHouse [worder=" + worder + ", worderdata=" + worderdata + ", wsource=" + wsource + ", wypay="
                + wypay + ", wspaid=" + wspaid + ", wauditor=" + wauditor + "]";
    }


}

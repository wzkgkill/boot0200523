package com.student.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {
    private Integer id;
    private String productname;
    private String descs;

    private List<Ordetails> details;
    private Category mylei;

    @GeneratedValue(strategy = GenerationType.IDENTITY)/*mysql 的主键自增策略*/
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "productname", nullable = false, length = 30)
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Basic
    @Column(name = "descs", nullable = true, length = 500)
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productname, product.productname) && Objects.equals(descs, product.descs) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productname, descs);
    }

    @OneToMany(mappedBy = "myproduct")
    public List<Ordetails> getDetails() {
        return details;
    }

    public void setDetails(List<Ordetails> details) {
        this.details = details;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id", nullable = false)
    public Category getMylei() {
        return mylei;
    }

    public void setMylei(Category mylei) {
        this.mylei = mylei;
    }
}

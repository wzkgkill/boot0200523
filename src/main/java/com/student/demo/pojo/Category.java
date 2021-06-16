package com.student.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/*
 * @author SMILE.Huang
 * @date 2021-06-07 10:08
 */
@Entity
public class Category {
    private Integer id;
    private String name;

    private Integer pid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private List<Category> child;
    private List<Product> products;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Transient  /*该字段不是数据库的字段，也不是关系字段，仅仅为了存储类别和子类的一对多关系而存在的字段*/
    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }

    @OneToMany(mappedBy = "mylei")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

package com.student.demo.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Course {
    private Integer cid;
    private String cname;
    private Term termByTid;
    private Collection<Coursegrade> coursegradesByCid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = true, length = 1024)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(cid, course.cid) && Objects.equals(cname, course.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname);
    }

    @ManyToOne
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    public Term getTermByTid() {
        return termByTid;
    }

    public void setTermByTid(Term termByTid) {
        this.termByTid = termByTid;
    }

    @OneToMany(mappedBy = "courseByCid")
    public Collection<Coursegrade> getCoursegradesByCid() {
        return coursegradesByCid;
    }

    public void setCoursegradesByCid(Collection<Coursegrade> coursegradesByCid) {
        this.coursegradesByCid = coursegradesByCid;
    }
}

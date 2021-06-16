package com.student.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Coursegrade {
    private Integer cid2;
    private Integer cfen;
    private Student studentBySid;
    private Course courseByCid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid2", nullable = false)
    public Integer getCid2() {
        return cid2;
    }

    public void setCid2(Integer cid2) {
        this.cid2 = cid2;
    }

    @Basic
    @Column(name = "cfen", nullable = true)
    public Integer getCfen() {
        return cfen;
    }

    public void setCfen(Integer cfen) {
        this.cfen = cfen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coursegrade that = (Coursegrade) o;
        return Objects.equals(cid2, that.cid2) && Objects.equals(cfen, that.cfen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid2, cfen);
    }

    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    public Student getStudentBySid() {
        return studentBySid;
    }

    public void setStudentBySid(Student studentBySid) {
        this.studentBySid = studentBySid;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Course getCourseByCid() {
        return courseByCid;
    }

    public void setCourseByCid(Course courseByCid) {
        this.courseByCid = courseByCid;
    }
}

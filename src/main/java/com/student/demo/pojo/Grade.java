package com.student.demo.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Grade {
    private Integer giid;
    private String gname;
    private String teacher;
    private String classroom;
    private Integer term;
    private Collection<Student> studentsByGiid;
    private Collection<Term> termsByGiid;

    @Id
    @Column(name = "giid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getGiid() {
        return giid;
    }

    public void setGiid(Integer giid) {
        this.giid = giid;
    }

    @Basic
    @Column(name = "gname", nullable = true, length = 1024)
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Basic
    @Column(name = "teacher", nullable = true, length = 1024)
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "classroom", nullable = true, length = 1024)
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Basic
    @Column(name = "term", nullable = true)
    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(giid, grade.giid) && Objects.equals(gname, grade.gname) && Objects.equals(teacher, grade.teacher) && Objects.equals(classroom, grade.classroom) && Objects.equals(term, grade.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giid, gname, teacher, classroom, term);
    }

    @OneToMany(mappedBy = "gradeByGiid")
    public Collection<Student> getStudentsByGiid() {
        return studentsByGiid;
    }

    public void setStudentsByGiid(Collection<Student> studentsByGiid) {
        this.studentsByGiid = studentsByGiid;
    }

    @OneToMany(mappedBy = "gradeByGiid")
    public Collection<Term> getTermsByGiid() {
        return termsByGiid;
    }

    public void setTermsByGiid(Collection<Term> termsByGiid) {
        this.termsByGiid = termsByGiid;
    }
}

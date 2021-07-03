package com.LichySoft.jazs20162nbp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class NBP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cur;
    private LocalDate start;
    private LocalDate end;
    private Double avg;
    private Date save;


    public NBP() {
    }

    public NBP(String cur, LocalDate start, LocalDate end, Double avg, Date save) {
        this.cur=cur;
        this.start=start;
        this.end=end;
        this.avg=avg;
        this.save=save;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Date getSave() {
        return save;
    }

    public void setSave(Date save) {
        this.save = save;
    }
}

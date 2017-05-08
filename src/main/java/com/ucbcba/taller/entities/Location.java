package com.ucbcba.taller.entities;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Jp on 24/04/2017.
 */
@Entity
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private BigDecimal lat;
    private BigDecimal lng;

    @ManyToOne
    @JoinColumn(name="terminal_id")
    private Terminal terminal;

    private Integer likes=0;

    public Integer getLikes()
    {
        return likes;
    }

    public void incLikes()
    {
        likes++;
    }

    public void decLikes()
    {
        if(likes>0)
        {
            likes--;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}

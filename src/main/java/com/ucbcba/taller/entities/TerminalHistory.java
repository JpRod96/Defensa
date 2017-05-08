package com.ucbcba.taller.entities;

import javax.persistence.*;

/**
 * Created by Jp on 08/05/2017.
 */
@Entity
public class TerminalHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serial;

    private Integer terminalId;

    private Integer category;

    private byte active;

    private Integer user;

    private String data_change;


    public void llenar(Terminal t)
    {
        setSerial(t.getSerial());
        setTerminalId(t.getId());
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getData_change() {
        return data_change;
    }

    public void setData_change(String data_change) {
        this.data_change = data_change;
    }
}


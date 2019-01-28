package com.xc.easyui.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
  *@className ProgInfo
  *@author xc
  *@date 2019/1/19 21:32
  *@description TODO
  *@version 1.0
  **/
@Entity
public class ProgInfo {
    @Id
    @GeneratedValue
    private int seqNo;
    private String author;
    private String progDesc;
    private String progName;
    private String confirmFlag;

    public ProgInfo() {
    }

    public String getConfirmFlag() {
        return confirmFlag;
    }

    public void setConfirmFlag(String confirmFlag) {
        this.confirmFlag = confirmFlag;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProgDesc() {
        return progDesc;
    }

    public void setProgDesc(String progDesc) {
        this.progDesc = progDesc;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }
}

package cn.ch06.hoteventtest.entity;

import java.util.Date;

public class Hotevents {
    private Integer id;
    private String keyWord;
    private String hotContent;
    private Integer searchSum;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getHotContent() {
        return hotContent;
    }

    public void setHotContent(String hotContent) {
        this.hotContent = hotContent;
    }

    public Integer getSearchSum() {
        return searchSum;
    }

    public void setSearchSum(Integer searchSum) {
        this.searchSum = searchSum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

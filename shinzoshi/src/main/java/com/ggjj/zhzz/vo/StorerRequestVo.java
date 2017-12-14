package com.ggjj.zhzz.vo;

public class StorerRequestVo extends CommonRequestVo {
    private Integer storerkey;

    private String company;

    private String phone;

    private String address;

    private String email;

    private String comment;

    public Integer getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(Integer storerkey) {
        this.storerkey = storerkey;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}
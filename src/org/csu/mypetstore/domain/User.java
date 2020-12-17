package org.csu.mypetstore.domain;

public class User {
    private String id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String languagepre;
    private String favoritecata;
    private String iflist;
    private String ifbanner;

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguagepre() {
        return languagepre;
    }

    public void setLanguagepre(String languagepre) {
        this.languagepre = languagepre;
    }

    public String getFavoritecata() {
        return favoritecata;
    }

    public void setFavoritecata(String favoritecata) {
        this.favoritecata = favoritecata;
    }

    public String getIflist() {
        return iflist;
    }

    public void setIflist(String iflist) {
        this.iflist = iflist;
    }

    public String getIfbanner() {
        return ifbanner;
    }

    public void setIfbanner(String ifbanner) {
        this.ifbanner = ifbanner;
    }
}

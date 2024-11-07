package com.relationship.OnetoOne.Models;


import jakarta.persistence.*;

@Entity
public class Person01 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "passport01_id", referencedColumnName = "id")

    private Passport01 passport01;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Passport01 getPassport01() {
        return passport01;
    }

    public void setPassport01(Passport01 passport01) {
        this.passport01 = passport01;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

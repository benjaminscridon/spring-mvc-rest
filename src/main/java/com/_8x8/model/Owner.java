package com._8x8.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.mapping.Collection;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bscridon on 29.08.2016.
 */
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "owner_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @Email
    private String email;

    //unidirectional relationship
    @OneToOne
    @JoinColumn(name = "home_address_id", unique = true)
    private Address homeAddress;

    //Represents one-to-one relationship between Owner and User classes, bidirectional relationship
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (id != null ? !id.equals(owner.id) : owner.id != null) return false;
        if (name != null ? !name.equals(owner.name) : owner.name != null) return false;
        if (email != null ? !email.equals(owner.email) : owner.email != null) return false;
        if (homeAddress != null ? !homeAddress.equals(owner.homeAddress) : owner.homeAddress != null) return false;
        if (user != null ? !user.equals(owner.user) : owner.user != null) return false;
        return cars != null ? cars.equals(owner.cars) : owner.cars == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }
}

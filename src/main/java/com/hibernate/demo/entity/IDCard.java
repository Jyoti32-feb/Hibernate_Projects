package com.hibernate.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="id_cards")
public class IDCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "card_number")
    private String cardNumber;

    @OneToOne(mappedBy = "idCard")
    private Employee employee;

    public IDCard() {
    }

    public IDCard(String cardNumber,Employee employee) {
        this.cardNumber = cardNumber;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + ",employee=" + employee +
                '}';
    }

}

package com.bank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity{

    private Long customerId;

    @Column(name="account_number")
    @Id
    private  Long accountNumber;

    private String accountType;

    private String mobileNumber;

    private String branchAddress;


}

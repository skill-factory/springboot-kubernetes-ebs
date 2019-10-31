package com.springboot.crud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Employee Modal")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Integer id;
    @Column(name = "first_name")
    @ApiModelProperty(value = "first name")
    private String firstName;
    @Column(name = "last_name")
    @ApiModelProperty(value = "last name")
    private String lastName;
    @Column(name = "email")
    @ApiModelProperty(value = "email")
    private String email;

}
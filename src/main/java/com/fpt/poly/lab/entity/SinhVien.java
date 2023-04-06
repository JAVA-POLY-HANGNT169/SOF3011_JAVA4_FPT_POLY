package com.fpt.poly.lab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator")
    @Type(type = "uuid-char")
    @Column(name = "ma", columnDefinition = "uniqueidentifier")
    private UUID code;

    @Column(name = "ten")
    private String name;

    @Column(name = "tuoi")
    private Long age;

    @Column(name = "dia_chi")
    private String address;

    @Column(name = "gioi_tinh")
    private Boolean gender;
}

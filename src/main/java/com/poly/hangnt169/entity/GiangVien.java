package com.poly.hangnt169.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "giang_vien")
public class GiangVien {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "ma", nullable = false)
    private UUID ma;

    @Column(name = "ten")
    private String ten;

}

package com.poly.hangnt169.service;

import com.poly.hangnt169.entity.Lop;

import java.util.List;

/**
 * @author hangnt169
 */
public interface LopService {

    List<Lop> getAll();

    Lop getOne(String id);

    void add(Lop category);

    void update(Lop category);

    void delete(Lop category);

}

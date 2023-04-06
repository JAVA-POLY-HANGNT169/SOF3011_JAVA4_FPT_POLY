package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.repository.LopRepository;
import com.poly.hangnt169.service.LopService;

import java.util.List;
import java.util.UUID;

/**
 * @author hangnt169
 */
public class LopServiceImpl implements LopService {

    private LopRepository lopRepository = new LopRepository();

    public List<Lop> getAll() {
        return lopRepository.getAll();
    }

    @Override
    public Lop getOne(String id) {
        return lopRepository.getOne(UUID.fromString(id));
    }

    @Override
    public void add(Lop category) {
        lopRepository.add(category);
    }

    @Override
    public void update(Lop category) {
        lopRepository.update(category);
    }

    @Override
    public void delete(Lop category) {
        lopRepository.delete(category);
    }

}

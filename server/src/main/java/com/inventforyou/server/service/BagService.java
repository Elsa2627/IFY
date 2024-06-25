package com.inventforyou.server.service;

import com.inventforyou.server.entity.Bag;
import java.util.List;

public interface BagService {
    List<Bag> getAllBags();
    Bag getBagById(Long id);
    Bag saveBag(Bag bag);
    void deleteBag(Long id);
}

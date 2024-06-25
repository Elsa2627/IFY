package com.inventforyou.server.service;

import com.inventforyou.server.entity.Bag;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;

@Service
public class BagServiceImpl implements BagService {
    private final AtomicLong counter = new AtomicLong();
    private final List<Bag> bags = new ArrayList<>();

    public BagServiceImpl() {
        // Initialiser avec quelques sacs
        addSampleBags();
    }

    private void addSampleBags() {
        saveBag(new Bag(){{
            setName("Classic Bag");
            setDescription("A timeless accessory.");
            setPrice(250.00);
        }});
    }

    @Override
    public List<Bag> getAllBags() {
        return new ArrayList<>(bags);
    }

    @Override
    public Bag getBagById(Long id) {
        return bags.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Bag saveBag(Bag bag) {
        bag.setId(counter.incrementAndGet());
        bags.add(bag);
        return bag;
    }

    @Override
    public void deleteBag(Long id) {
        bags.removeIf(b -> b.getId().equals(id));
    }
}

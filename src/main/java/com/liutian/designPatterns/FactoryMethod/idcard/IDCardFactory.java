package com.liutian.designPatterns.FactoryMethod.idcard;

import com.liutian.designPatterns.FactoryMethod.framework.Factory;
import com.liutian.designPatterns.FactoryMethod.framework.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IDCardFactory extends Factory {

    private List owners = new ArrayList();
    private HashMap<Long, String> idcardOwners = new HashMap<>();
    private static Long index = 0L;

    @Override
    protected Product createProduct(String owner) {
        IDCard idCard = new IDCard(owner);
        idCard.setIdNumber(index);
        index++;
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        if (product instanceof IDCard) {
            IDCard card = (IDCard) product;
            owners.add(card.getOwner());
            idcardOwners.put(card.getIdNumber(), card.getOwner());
        }
        throw new RuntimeException("IDCard register error: unknown type");
    }

    public List getOwners() {
        return owners;
    }
}

package com.liutian.designPatterns.FactoryMethod.idcard;

import com.liutian.designPatterns.FactoryMethod.framework.Product;

public class IDCard extends Product {
    private String owner;

    private Long idNumber;

    //使用默认访问修饰符，
    //1.防止包外的类来直接new IDCard
    //2.让包内的IDCardFactory能够访问构造器，产生IDCard类
    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }
    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }
    public String getOwner() {
        return owner;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public Long getIdNumber() {
        return idNumber;
    }
}

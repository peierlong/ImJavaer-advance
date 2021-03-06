package com.peierlong.design.patterns.decorator;

/**
 * @author elong
 * @version V1.0
 * @date 2018/9/12
 */
public class Mocha extends BeverageDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }

}

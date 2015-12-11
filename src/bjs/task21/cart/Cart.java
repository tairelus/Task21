package bjs.task21.cart;

import bjs.task21.computers.Computer;

import java.util.LinkedList;

/**
 * Created by YM on 10.12.2015.
 * Present cart functionality of the computer store
 * We can use Cart<T extends Computer> to limit type parameter
 */
public class Cart<T> {
    /**Customer for */
    private CustomerCart customerCart;

    /**
     * Provides storage for the cart. Customer cart can be based on other data structure. It depends on how to interact
     * with cart.
     */
    private class CustomerCart extends LinkedList<T> {
        //Add user defined functions if necessary, e.g. some search
    }

    /**
     * Helper, print Desktop object in the console
     */
    private void printBuy(T buy) {
        /**
         * toString() overwritten for each class and it is virtual by default in Java.
         * So, correspondent version of the toString() will be called by type
         */
        System.out.print(buy.toString());
        System.out.println("--------------------------------------------\n");
    }

    public Cart() {
        customerCart = new CustomerCart();
    }

    /**
     * Add buy to the cart
     * @param buy
     */
    public void addBuy(T buy) {
        customerCart.add(buy);
    }

    /**
     * Get buy by index
     * @param index
     * @return
     */
    public T getBuy(int index) {
        return customerCart.get(index);
    }

    /**
     * Removes buy by object reference
     * @param buy Object reference
     */
    public void removeBuy(T buy) {
        customerCart.remove(buy);
    }

    /**
     * Removes buy by index
     * @param index Buy index
     */
    public void removeBuy(int index) {
        customerCart.remove(index);
    }

    /**
     * Prints customer cart
     */
    public void printCustomerCart() {
        for (T entry : customerCart) {
            printBuy(entry);
        }
    }
}

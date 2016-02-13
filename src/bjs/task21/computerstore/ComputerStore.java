package bjs.task21.computerstore;

import java.util.Collection;
import java.util.HashMap;

import bjs.task21.cart.Cart;
import bjs.task21.computers.*;

/**
 * Created by YM on 27.11.2015.
 */

/**
 * Presents computer store
 */
public class ComputerStore {
    /**Collection of the desktop computers*/
    private DesktopCatalog desktopComputers;
    /**Collection of the laptop computers*/
    private LaptopCatalog laptopComputers;
    /**Collection of the tablet computers*/
    private TabletCatalog tabletComputers;

    /**Customer cart*/
    private Cart<Computer> customerCart;

    /**
     * Provides storage for the desktop computer
     */
    private class DesktopCatalog extends HashMap<String, Desktop> {
       //Add user defined functions if necessary, e.g. some search
    }

    /**
     * Provides storage for the laptop computer
     */
    private class LaptopCatalog extends HashMap<String, Laptop> {
        //Add user defined functions if necessary, e.g. some search
    }

    /**
     * Provides storage for the laptop computer
     */
    private class TabletCatalog extends HashMap<String, Tablet> {
        //Add user defined functions if necessary, e.g. some search
    }

    /**
     * Helper, print Desktop object in the console
     */
    private void printComputer(Computer computer) {
        /**
         * toString() overwritten for each class and it is virtual by default in Java.
         * So, correspondent version of the toString() will be called by type
         */
        System.out.print(computer.toString());
        System.out.println("--------------------------------------------\n");
    }

    /**
     * Prints catalog passed as parameter
     * @param catalog Catalog of the different computer types
     * @param <T> Computer type
     */
    private <T extends Computer> void printCatalog(HashMap<String, T> catalog) {
        for (HashMap.Entry<String, T> entry : catalog.entrySet()) {
            printComputer(entry.getValue());
        }
    }

    /**
     * Current constructor
     */
    public ComputerStore() {
        desktopComputers = new DesktopCatalog();
        laptopComputers = new LaptopCatalog();
        tabletComputers = new TabletCatalog();

        customerCart = new Cart<>(); //Diamond syntax, JDK 7
    }

    /**
     * Gets Desktop object by index
     * @param article
     * @return
     */
    public Desktop getDesktop(String article) {
        return desktopComputers.get(article);
    }

    /**
     * Gets Desktop object by index
     * @param article
     * @return
     */
    public Laptop getLaptop(String article) {
        return laptopComputers.get(article);
    }

    /**
     * Adds computer to the correspondent collection by type
     * @param computer
     */
    public void addComputer(Computer computer) {
        String computerClass = computer.getComputerClass();

        switch (computerClass) {
            case "Desktop": //use instanceof keyword instead
                desktopComputers.put(computer.getArticle(), (Desktop)computer);
                break;
            case "Laptop":
                laptopComputers.put(computer.getArticle(), (Laptop)computer);
                break;
            case "Tablet":
                tabletComputers.put(computer.getArticle(), (Tablet)computer);
                break;
        }
    }

    /**
     * Add buy to the cart
     * @param buy
     */
    public void addBuy(Computer buy) {
        customerCart.addBuy(buy);
    }

    /**
     * Removes buy by index
     * @param index Buy index
     */
    public void removeBuy(int index) {
        customerCart.removeBuy(index);
    }

    /**
     * Removes buy by object reference
     * @param buy Object reference
     */
    public void removeBuy(Computer buy) {
        customerCart.removeBuy(buy);
    }

    /**
     * Prints Desktop collection with for cycle
     */
    public void printDesktopComputers() {
        printCatalog(desktopComputers);
    }

    /**
     * Prints Laptop collection with for cycle
     */
    public void printLaptopComputers() {
        printCatalog(laptopComputers);
     }

    /**
     * Prints Tablet collection with for cycle
     */
    public void printTabletComputers() {
        printCatalog(tabletComputers);
    }

    /**
     * Prints customer cart
     */
    public void printCustomerCart() {
        customerCart.printCustomerCart();
    }
}

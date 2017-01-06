package iteratorcomposite;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by stillFox on 16/12/30.
 */
public class Waitress {

    ArrayList menus;

    public Waitress(ArrayList menus) {
        this.menus = menus;
    }

    public void printMenu() {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu)menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printBreakfastMenu() {}
    public void printLunchMenu() {}
    public void printVegetarianMenu() {}
    public void isItemVegetarian(String name) {}
}

package iteratorcomposite;

import java.util.ArrayList;

/**
 * Created by stillFox on 16/12/30.
 */
public class Waitress {

    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    public void printMenu() {
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuitem = (MenuItem)breakfastItems.get(i);
            System.out.print(menuitem.getName() + " ");
            System.out.println(menuitem.getPrice() + " ");
            System.out.println(menuitem.getDescription());
        }

        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem != null) {
                System.out.print(menuItem.getName() + " ");
                System.out.println(menuItem.getPrice() + " ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    public void printBreakfastMenu() {}
    public void printLunchMenu() {}
    public void printVegetarianMenu() {}
    public void isItemVegetarian(String name) {}
}

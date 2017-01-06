package iteratorcomposite;

/**
 * Created by stillFox on 16/12/30.
 */
// component version

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
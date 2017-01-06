package iteratorcomposite;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by stillFox on 16/12/30.
 */
// Concrete Iterator
class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if (items[position-1] != null) {
            for (int i = position-1; i < (items.length-1); i++) {
                items[i] = items[i+1];
            }
            items[items.length-1] = null;
        }
    }
}

class AlternatingDinerMenuIterator implements Iterator {
    MenuItem[] items;
    int postion;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        Calendar rightNow = Calendar.getInstance();
        postion = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
    }

    public Object next() {
        MenuItem menuItem = items[postion];
        postion = postion + 2;
        return menuItem;
    }

    public boolean hasNext() {
        if (postion >= items.length || items[postion] == null) {
            return false;
        } else {
            return true;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Alternating Diner Menu Iterator does not support remove()");
    }
}

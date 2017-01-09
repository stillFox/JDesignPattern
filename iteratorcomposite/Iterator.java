package iteratorcomposite;
import java.util.*;

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

class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    public Object next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent)iterator.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = (Iterator)stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

class NullIterator implements Iterator {
    public Object next() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
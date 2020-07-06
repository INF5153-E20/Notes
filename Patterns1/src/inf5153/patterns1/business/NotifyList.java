package inf5153.patterns1.business;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wflag on 2020-07-06.
 */
public class NotifyList<T> extends AbstractList<T> {
    private List<T> baseList;
    private List<ListObserver<T>> observers = new ArrayList<>();

    public NotifyList(List<T> baseList) {
        this.baseList = baseList;
    }

    public void attach(ListObserver<T> o) {
        observers.add(o);
    }

    public void detach(ListObserver<T> o) {
        observers.remove(o);
    }

    private void notify(T e) {
        for(ListObserver<T> o : observers)
            o.update(e);
    }

    @Override
    public T get(int index) {
        return baseList.get(index);
    }

    @Override
    public int size() {
        return baseList.size();
    }

    @Override
    public boolean add(T e) {
        notify(e);
        return baseList.add(e);
    }
}

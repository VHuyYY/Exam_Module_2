package Manager;

import java.util.List;

public interface Imanager<T> {
    void add(T t);

    void remove(int id);

    void update(int id, T t);

    List<T> getAll();

    int findByIndexId(int id);
}

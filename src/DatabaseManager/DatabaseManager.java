package DatabaseManager;

import java.util.ArrayList;
import Interfaces.*;

public abstract class DatabaseManager<T extends Storable> {

    /* To be implemented */
    public abstract void view();
    public abstract void remove(T course);
    public abstract void add(T storable);
    public abstract void edit(T storable);
    public abstract ArrayList<T> readFile(String fileName);
    public abstract void writeFile(String fileName, ArrayList<T> storables);
}

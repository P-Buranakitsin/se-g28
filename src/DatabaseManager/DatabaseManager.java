package DatabaseManager;

import java.util.ArrayList;
import Interfaces.*;

public abstract class DatabaseManager<T extends Storable> {

    /* To be implemented */
    public abstract void view();
    public abstract void remove(int index);
    public abstract void add(T storable);
    public abstract void edit(int index, T storable);
    public abstract ArrayList<T> readFile();
    public abstract void writeFile(ArrayList<T> storables);
}

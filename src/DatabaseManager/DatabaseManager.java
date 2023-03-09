package DatabaseManager;

import java.util.ArrayList;
import General.*;
import Interfaces.*;

public abstract class DatabaseManager {

    /* To be implemented */
    public abstract void view();
    public abstract void remove(Storable storable);
    public abstract void add(Storable storable);
    public abstract void edit(Storable storable);
    public abstract ArrayList<Storable> readFile(String fileName);
    public abstract void writeFile(String fileName, ArrayList<Storable> storables);
}

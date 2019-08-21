package DevelopPack.Interfaces;

import static DevelopPack.Interfaces.Orientation.*;
import static DevelopPack.Interfaces.Orientation.NORTH;

public interface Rotatable {
    Orientation orientation = null;

    void rotate(); // нормальную реализацию я не смог реализовать в интерфейсе.
}

package DevelopPack.Units.Objects;

import DevelopPack.Field;
import DevelopPack.Units.GameThings;

public abstract class CommonObject extends GameThings {
    public CommonObject(){
        Field.addTo(this);
    }
}

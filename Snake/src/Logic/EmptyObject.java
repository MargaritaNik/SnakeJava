package Logic;

import GUI.IVisitor;
import java.io.Serializable;

public class EmptyObject implements MapObject, Serializable {
    public void moveToThisObject(Snake snake, Field field) {};

    public void accept(IVisitor visitor){
        visitor.paint(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

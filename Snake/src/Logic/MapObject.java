package Logic;

import GUI.IVisitor;
import GUI.Model;

public interface MapObject {
    void moveToThisObject(Snake snake, Field field);

    void accept(IVisitor visitor);
}

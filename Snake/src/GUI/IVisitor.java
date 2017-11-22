package GUI;

import Logic.*;

public interface IVisitor {
    void paint(Fruit fruit);
    void paint(SnakePart snake);
    void paint(Wall wall);
    void paint(EmptyObject empty);
}

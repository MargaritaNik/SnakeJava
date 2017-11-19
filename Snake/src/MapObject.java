import Models.Model;

public interface MapObject {
    MapObject EmptyObject = new MapObject() {
        public Model getModel() {
            return Model.EmptyModel;
        }

        public void moveToThisObject(Snake snake, Field field) { }
    };
    Model getModel();

    void moveToThisObject(Snake snake, Field field);
}

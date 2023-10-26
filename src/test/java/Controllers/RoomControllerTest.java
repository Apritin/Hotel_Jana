package Controllers;

import Modules.Room;
import org.junit.Test;

public class RoomControllerTest {

    @Test
    public void add() {
        RoomController controller = new RoomController();
        Room r = new Room("109", Room.RoomStyle.STANDARD, 1) ;
        controller.add(r);
    }

    @Test
    public void update() {
        RoomController controller = new RoomController();
        Room r = new Room("109", Room.RoomStyle.STANDARD, 0) ;
        controller.update(r);
    }

    @Test
    public void delete() {
        RoomController controller = new RoomController();
        Room r = new Room("109", Room.RoomStyle.STANDARD, 1) ;
        controller.delete(r);
    }

    @Test
    public void find() {
    }
}
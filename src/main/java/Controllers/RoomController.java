package Controllers;


import Modules.Room;

import java.sql.*;
import java.time.LocalDate;


public class RoomController extends Controller<Room>{
    public RoomController() {
        super();
    }

    @Override
    public TableState add(Room room){
        try{
            String sql = "INSERT INTO room VALUES(?,?,?);";
            ppsm = connection.prepareStatement(sql);
            ppsm.setString(1, room.getRoomNumber());
            ppsm.setString(2, room.getStyle().toString());
            ppsm.setInt(3, room.isSmoking());
            executeInsert(sql, ppsm);

            System.out.println("Room insert succeeded");
        }catch (SQLException e){
            /*
            Logger logger = Logger.getLogger(RoomBookingController.class.getName());
            logger.log(Level.INFO, "Inserted failed");
             */
            System.out.println("Room insert failed " + e.toString());
        }
        close();
        return getAll();
    }

    @Override
    public TableState update(Room room){
        try{
            /*
            reservation_number is pk
             */
            String sql = "UPDATE room SET room_style=?, is_smoking=? WHERE room_number=?;";
            ppsm = connection.prepareStatement(sql);
            ppsm.setString(1, room.getStyle().toString());
            ppsm.setInt(2, room.isSmoking());
            ppsm.setString(3, room.getRoomNumber());
            executeUpdate(sql, ppsm);

            System.out.println("RoomBooking update succeeded");
        }catch (SQLException e){
            System.out.println("RoomBooking update failed");
        }
        close();
        return getAll();
    }

    @Override
    public TableState delete(Room room){
        try{
            String sql = "DELETE FROM room WHERE room_number=?;";
            ppsm = connection.prepareStatement(sql);
            ppsm.setString(1, room.getRoomNumber());
            executeDelete(sql, ppsm);

            System.out.println("Room delete succeeded");
        }catch (SQLException e){
            System.out.println("Room delete failed");
        }
        close();
        return getAll();
    }

    public class RoomSearchQuery {
        public Room.RoomStyle roomStyle;
        public LocalDate startDate;
        public int duration ;
    }

    /**
     * No attributes allowed to be null
     **/
    public TableState search(RoomSearchQuery roomSearchQuery) {
        try{
            String sql = "SELECT *\n" +
                    "FROM room r\n" +
                    "WHERE r.room_style = ?\n" +
                    "OR r.room_number IN (\n" +
                    "    SELECT rb.room_number\n" +
                    "\tFROM room_booking rb\n" +
                    "\tWHERE (rb.start_date <= ? AND rb.start_date + rb.duration > ?)\n" +
                    "\tOR (rb.start_date < ? AND rb.start_date + rb.duration >= ?)\n" +
                    ");";
            ppsm = connection.prepareStatement(sql);
            ppsm.setString(1, roomSearchQuery.roomStyle.toString());
            ppsm.setDate(2, Date.valueOf(roomSearchQuery.startDate));
            ppsm.setDate(3, Date.valueOf(roomSearchQuery.startDate));
            ppsm.setDate(4, Date.valueOf(roomSearchQuery.startDate.plusDays(roomSearchQuery.duration)));
            ppsm.setDate(5, Date.valueOf(roomSearchQuery.startDate.plusDays(roomSearchQuery.duration)));
            executeSearch(sql, ppsm);
            System.out.println("Room search succeeded");
            return getAll();
        }catch (SQLException e){
            System.out.println("Room search failed "+e.toString());
        }
        close();
        return null;
    }

    @Override
    public TableState getAll() {
        return _getAll("room");
    }

}
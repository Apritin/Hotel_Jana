package Controllers;


import Modules.RoomBooking;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.*;


public class RoomBookingController implements Controller<RoomBooking>{
    @Override
    public void add(RoomBooking R){
        Connection connection = null;
        PreparedStatement ppsm = null;

        try{
            connection = Controller.getConnection();
            ppsm = connection.prepareStatement(
                    "INSERT INTO room_booking VALUES(?,?,?,?,?)");
            ppsm.setInt(1, R.getReservationNumber());
            ppsm.setDate(2, java.sql.Date.valueOf(R.getStartDate()));
            ppsm.setInt(3, R.getDurationInDays());
            ppsm.setString(4, R.getRoomId());
            ppsm.setInt(5, R.getGuestId());
            ppsm.executeUpdate();

            System.out.println("RoomBooking insert succeeded");
        }catch (SQLException e){
            /*
            Logger logger = Logger.getLogger(RoomBookingController.class.getName());
            logger.log(Level.INFO, "Inserted failed");
             */
            System.out.println("RoomBooking insert failed " + e.toString());
        } finally {
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println("connection close failed");
            }

            try{
                ppsm.close();
            }catch (SQLException e){
                System.out.println("ppsm close failed");
            }
        }
    }

    @Override
    public void update(RoomBooking R){
        Connection connection = null;
        PreparedStatement ppsm = null;

        try{
            /*
            reservation_number is pk
             */
            connection = Controller.getConnection();
            ppsm = connection.prepareStatement(
                    "UPDATE room_booking SET start_date=?, duration=?, room_number=?, account_id=? WHERE reservation_number=?;");
            ppsm.setDate(1, java.sql.Date.valueOf(R.getStartDate()));
            ppsm.setInt(2, R.getDurationInDays());
            ppsm.setString(3, R.getRoomId());
            ppsm.setInt(4, R.getGuestId());
            ppsm.setInt(5, R.getReservationNumber());
            ppsm.executeUpdate();

            System.out.println("RoomBooking update succeeded");
        }catch (SQLException e){
            System.out.println("RoomBooking update failed");
        } finally {
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println("connection close failed");
            }

            try{
                ppsm.close();
            }catch (SQLException e){
                System.out.println("ppsm close failed");
            }
        }
    }

    @Override
    public void delete(RoomBooking R){
        Connection connection = null;
        PreparedStatement ppsm = null;

        try{
            connection = Controller.getConnection();
            ppsm = connection.prepareStatement(
                    "DELETE FROM WHERE reservation_number=?;");
            ppsm.setInt(1, R.getReservationNumber());
            ppsm.executeUpdate();

            System.out.println("RoomBooking delete succeeded");
        }catch (SQLException e){
            System.out.println("RoomBooking delete failed");
        } finally {
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println("connection close failed");
            }

            try{
                ppsm.close();
            }catch (SQLException e){
                System.out.println("ppsm close failed");
            }
        }
    }

    public boolean find(int reservation_number){
        return false;
    };



}
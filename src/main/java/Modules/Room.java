package Modules;

public class Room {
    private String roomNumber;
    private RoomStyle style;
    private int isSmoking;

    public enum RoomStyle {
        STANDARD,
        DELUXE,
        FAMILY_SUITE,
        BUSINESS_SUITE
    }

    public Room(){

    }

    public Room(String roomNumber, RoomStyle style, int isSmoking) {
        this.roomNumber = roomNumber;
        this.style = style;
        this.isSmoking = isSmoking;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomStyle getStyle() {
        return style;
    }

    public void setStyle(RoomStyle style) {
        this.style = style;
    }

    public void getStatus(boolean status) {
        /**
         * Implement Start Date + duration
         */

    }

    public int isSmoking() {
        return isSmoking;
    }

    public void setSmoking(int smoking) {
        isSmoking = smoking;
    }


}


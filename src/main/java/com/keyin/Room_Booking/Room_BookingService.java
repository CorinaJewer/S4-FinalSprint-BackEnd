package com.keyin.Room_Booking;

import com.keyin.Rooms.Room;
import com.keyin.Rooms.RoomRepository;
import com.keyin.Users.User;
import com.keyin.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Room_BookingService {
    @Autowired
    private Room_BookingRepository room_bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Room_Booking> getAllRoom_Bookings(){
        return (List<Room_Booking>) room_bookingRepository.findAll();
    }

    public Room_Booking getRoom_BookingById(long id){
        Optional<Room_Booking> result = room_bookingRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }

        return null;
    }

    public List<Room_Booking> getRoom_BookingByRoomId(long id){
        Optional<Room> result = roomRepository.findById(id);

        if(result.isPresent()){
            return room_bookingRepository.findAllByRoom(result.get());
        }

        return null;
    }

    public List<Room_Booking> getRoom_BookingByUserId(long id){
        Optional<User> result = userRepository.findById(id);

        if(result.isPresent()){
            return room_bookingRepository.findAllByUser(result.get());
        }

        return null;
    }
}
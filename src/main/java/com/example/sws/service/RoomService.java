package com.example.sws.service;

import com.example.sws.entity.Room;
import com.example.sws.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> listAll(){
        return roomRepository.findAll();
    }

    public void save(Room room){
        roomRepository.save(room);

    }
    public Room get(int id){
        return roomRepository.findById(id).get();

    }

    public void delete(int id){
        roomRepository.deleteById(id);

    }
}

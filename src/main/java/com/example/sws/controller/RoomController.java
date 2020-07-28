package com.example.sws.controller;
import com.example.sws.entity.Room;
import com.example.sws.repository.RoomRepository;
import com.example.sws.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping("listroom")
    public String viewRoomPage(Model model) {
       List<Room> listRooms = service.listAll();
       model.addAttribute("listRooms", listRooms);
       return "listroom";
   }
   @GetMapping("createroom")
    public String createRoom(Model model) {
        Room room = new Room();
        model.addAttribute("room",room);
        return "addRoom";
   }
   @PostMapping("save")
    public String saveRoom(@ModelAttribute("room") Room room){
        service.save(room);
        return "redirect:listroom";
   }
    @GetMapping("edit/{id}")
    public ModelAndView viewEditRoomPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editRoom");
        Room room = service.get(id);
        mav.addObject("room",room);
        return mav;
    }
    @GetMapping("delete/{id}")
    public String deleteRoom(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin/listroom";
    }

}

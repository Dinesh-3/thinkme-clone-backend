package com.dinesh.thinkme_clone.controller;

import com.dinesh.thinkme_clone.model.Note;
import com.dinesh.thinkme_clone.service.NoteService;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    @Autowired NoteService noteService;

    @RequestMapping("/test")
    public String get(){
        return "Testing....";
    }

    @GetMapping()
    public HashMap getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseBody getNote(@PathVariable long id){
        return noteService.getNoteById(id);
    }

    @PostMapping()
    public ResponseBody createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public ResponseBody updateNote(@PathVariable long id, @RequestBody Note note){
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public HashMap deleteNote(@PathVariable long id){
        return noteService.deleteNote(id);
    }

}

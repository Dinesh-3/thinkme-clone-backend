package com.dinesh.thinkme_clone.controller;

import com.dinesh.thinkme_clone.model.Note;
import com.dinesh.thinkme_clone.service.NoteService;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    @Autowired NoteService noteService;

    @RequestMapping("/test")
    public String get(){
        return "Testing....";
    }

    @GetMapping()
    public ResponseBody getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNote(@PathVariable long id){
        return noteService.getNoteById(id);
    }

    @PostMapping()
    public Note createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable long id, @RequestBody Note note){
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public ResponseBody deleteNote(@PathVariable long id){
        return noteService.deleteNote(id);
    }

}

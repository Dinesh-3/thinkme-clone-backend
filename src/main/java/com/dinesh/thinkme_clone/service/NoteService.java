package com.dinesh.thinkme_clone.service;

import com.dinesh.thinkme_clone.model.Note;
import com.dinesh.thinkme_clone.repository.NoteRepository;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired NoteRepository noteRepository;

    public HashMap getAllNotes(){
        var notes = noteRepository.findAll();
        var response = this.getResponseBody();
        response.put("message", "Notes Fetched Successfully");
        response.put("data", notes);
        return response;
    }

    public ResponseBody getNoteById(long id) {
        var note = noteRepository.findById(id);
        var response = getResponseBody("Note Fetched Successfully", note);
        return response;
    }

    public ResponseBody createNote(Note note){
        var savedNote = noteRepository.save(note);
        var response = getResponseBody("Note Created Successfully", savedNote);
        return response;
    }

    public ResponseBody updateNote(long id, Note note){
//        var isExist = noteRepository.existsById(id);
        var updatedNote = noteRepository.save(note);
        var response = getResponseBody("Note Created Successfully", updatedNote);
        return response;
    }

    public HashMap deleteNote(long id) {
        noteRepository.deleteById(id);
        var response = getResponseBody();
        response.put("message", "Note Deleted Successfully");

        return response;
    }

    private ResponseBody getResponseBody(String message, Object data){
        return new ResponseBody(message, data);
    }

    @Bean
    private HashMap getResponseBody() {
        var hashMap = new HashMap<String, Object>();
        hashMap.put("status", true);
        hashMap.put("status_code", 200);
        return hashMap;
    }
}

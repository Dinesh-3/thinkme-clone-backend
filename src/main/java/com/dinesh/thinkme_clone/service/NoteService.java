package com.dinesh.thinkme_clone.service;

import com.dinesh.thinkme_clone.model.Note;
import com.dinesh.thinkme_clone.repository.NoteRepository;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {
    @Autowired NoteRepository noteRepository;

    public ResponseBody getAllNotes(){
        var notes = noteRepository.findAll();
        var response = this.getResponseBody("Notes Fetched", notes);

        return response;
    }

    public Optional<Note> getNoteById(long id) {
        return noteRepository.findById(id);
    }

    public Note createNote(Note note){
        var savedNote = noteRepository.save(note);
        return savedNote;
    }

    public Note updateNote(long id, Note note){
//        var isExist = noteRepository.existsById(id);
        return noteRepository.save(note);
    }

    public ResponseBody deleteNote(long id) {
        noteRepository.deleteById(id);
        return getResponseBody("Note Deleted Successfully", null);
    }

    private ResponseBody getResponseBody(String message, Object data){
        return new ResponseBody(message, data);
    }
}

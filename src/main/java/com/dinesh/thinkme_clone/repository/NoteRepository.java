package com.dinesh.thinkme_clone.repository;

import com.dinesh.thinkme_clone.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}

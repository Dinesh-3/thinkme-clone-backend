package com.dinesh.thinkme_clone.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="page")
public class Page {
    @Id
    private String page_id;

    private String page_title;

    @OneToMany(mappedBy = "page_id")
    private List<Note> notes;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    public String getPage_id() {
        return page_id;
    }

    public String getPage_title() {
        return page_title;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
}

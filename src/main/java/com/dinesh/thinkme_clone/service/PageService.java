package com.dinesh.thinkme_clone.service;

import com.dinesh.thinkme_clone.model.Page;
import com.dinesh.thinkme_clone.repository.PageRepository;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PageService {
    @Autowired
    PageRepository pageRepository;

    public ResponseBody getAllPages(){
        var notes = pageRepository.findAll();
        var response = this.getResponseBody("Pages Fetched", notes);
        return response;
    }

    public Optional<Page> getPageById(String id) {
        return pageRepository.findById(id);
    }

    public Page createPage(Page page){
        var savedPage = pageRepository.save(page);
        return savedPage;
    }

    public Page updatePage(String id, Page page){
//        var isExist = noteRepository.existsById(id);
        return pageRepository.save(page);
    }

    public ResponseBody deletePage(String id) {
        pageRepository.deleteById(id);
        return getResponseBody("Note Deleted Successfully", null);
    }

    private ResponseBody getResponseBody(String message, Object data){
        return new ResponseBody(message, data);
    }
}

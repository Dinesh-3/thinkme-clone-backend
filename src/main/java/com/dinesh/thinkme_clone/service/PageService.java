package com.dinesh.thinkme_clone.service;

import com.dinesh.thinkme_clone.model.Page;
import com.dinesh.thinkme_clone.repository.PageRepository;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    public ResponseBody getPageById(String id) {
        var page = pageRepository.findById(id);
        var response = getResponseBody("Page Contents Fetched Successfully", page);
        return response;
    }

    public ResponseBody createPage(Page page){
        var savedPage = pageRepository.save(page);
        var response = getResponseBody("Page Created Successfully", savedPage);

        return response;
    }

    public ResponseBody updatePage(String id, Page page){
//        var isExist = noteRepository.existsById(id);
        var updatedPage = pageRepository.save(page);
        var response = getResponseBody("Page Created Successfully", updatedPage);
        return response;
    }

    public ResponseBody deletePage(String id) {
        pageRepository.deleteById(id);
        return getResponseBody("Note Deleted Successfully", null);
    }

    private ResponseBody getResponseBody(String message, Object data){
        return new ResponseBody(message, data);
    }
}

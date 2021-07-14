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
        Iterable<Page> notes = pageRepository.findAll();
        ResponseBody response = this.getResponseBody("Pages Fetched", notes);
        return response;
    }

    public ResponseBody getPageById(String id) {
        Optional<Page> page = pageRepository.findById(id);
        ResponseBody response = getResponseBody("Page Contents Fetched Successfully", page);
        return response;
    }

    public ResponseBody createPage(Page page){
        Page savedPage = pageRepository.save(page);
        ResponseBody response = getResponseBody("Page Created Successfully", savedPage);

        return response;
    }

    public ResponseBody updatePage(String id, Page page){
//        var isExist = noteRepository.existsById(id);
        Page updatedPage = pageRepository.save(page);
        ResponseBody response = getResponseBody("Page Created Successfully", updatedPage);
        return response;
    }

    public ResponseBody deletePage(String id) {
        pageRepository.deleteById(id);
        return getResponseBody("Note Deleted Successfully", null);
    }

    public ResponseBody isPageExist(String id) {
        boolean isExist = pageRepository.existsById(id);
        return getResponseBody("Success", isExist);
    }

    private ResponseBody getResponseBody(String message, Object data){
        return new ResponseBody(message, data);
    }
}

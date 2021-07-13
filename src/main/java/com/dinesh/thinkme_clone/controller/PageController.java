package com.dinesh.thinkme_clone.controller;

import com.dinesh.thinkme_clone.model.Page;
import com.dinesh.thinkme_clone.service.PageService;
import com.dinesh.thinkme_clone.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/page")
public class PageController {
    @Autowired
    PageService pageService;

    @GetMapping()
    public ResponseBody getAllPages(){
        return pageService.getAllPages();
    }

    @GetMapping("/{id}")
    public ResponseBody getPage(@PathVariable String id){
        return pageService.getPageById(id);
    }

    @PostMapping()
    public ResponseBody createPage(@RequestBody Page page){
        return pageService.createPage(page);
    }

    @PutMapping("/{id}")
    public ResponseBody updatePage(@PathVariable String id, @RequestBody Page page){
        return pageService.updatePage(id, page);
    }

    @DeleteMapping("/{id}")
    public ResponseBody deletePage(@PathVariable String id){
        return pageService.deletePage(id);
    }
}

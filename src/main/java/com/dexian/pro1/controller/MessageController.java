package com.dexian.pro1.controller;

import com.dexian.pro1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Brook_min
 * @date 2019/3/26 0026 - 15:44
 */
@RestController
@RequestMapping("/mes")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List findAll(){
        List mesList = this.messageService.findAll();
        return mesList;
    }

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String hell(){
        return "Hello World!美好的世界";
    }
}

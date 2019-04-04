package com.dexian.pro1.service.serviceimpl;

import com.dexian.pro1.dao.MessageMapper;
import com.dexian.pro1.pojo.MessageExample;
import com.dexian.pro1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Brook_min
 * @date 2019/3/26 0026 - 15:37
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    public MessageMapper messageMapper;

    @Override
    public List findAll() {
        MessageExample messageExample = new MessageExample();
        return this.messageMapper.selectByExample(messageExample);
    }
}

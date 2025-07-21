package com.example.service;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

@Autowired
private MessageRepository messageRepository;
@Autowired
private AccountRepository accountRepository;

public Message createMessage(Message message) {
if (!accountRepository.existsById(message.getPostedBy())) {
        return null;
    }
return messageRepository.save(message);
}

public List<Message> getAllMessages(){
    return messageRepository.findAll();
}

public Message getMessageById(int id){
    return messageRepository.findById(id).orElse(null);
}

public int deleteMessage(int id){
    if (messageRepository.existsById(id)){
        messageRepository.deleteById(id);
        return 1;
    }

    return 0;
}

public List<Message> getMessagesByUser(int accountId){
    return messageRepository.findByPostedBy(accountId);
}

public int updateMessage(int id, String newText){
    return messageRepository.findById(id).map(msg -> {
                msg.setMessageText(newText);
                messageRepository.save(msg);
                return 1;
            })
            .orElse(0);
}

}

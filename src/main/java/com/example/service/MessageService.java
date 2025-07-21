package com.example.service;
import com.example.entity.Message;
import com.example.repository.MessageRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

@Autowired
private MessageRepository messageRepository;

public Message messages(Message message) {
return messageRepository.save(message);
}

public Message createMessage(Message message) {
return messageRepository.save(message);
}

public List<Message> getAllMessages(){
    return messageRepository.findAll();
}

public Message getMessageById(int id){
    return messageRepository.findById(id);
}

public int deleteMessage(int id){
    return messageRepository.deleteById(id);
}

public List<Message> getMessagesByUser(int accountId){
    return messageRepository.findByPostedBy(accountId);
}

public int updateMessage(int id, String newText){
    return messageRepository.updateTextMessage(id, newText);
}

}

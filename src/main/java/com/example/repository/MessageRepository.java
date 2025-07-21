package com.example.repository;
import com.example.entity.Message;
import java.util.List;

public interface MessageRepository {
    //save messages
    Message save(Message message);
    //finds all messages to return to list
    List<Message> findAll();
    //deletes messages by id
    int deleteById(int id);
    //finds specific messages by id
    Message findById(int id);
    //finds messages of a specific user
    List<Message> findByPostedBy(int AccountId);
    //updates the text
    int updateTextMessage(int id, String newText);

}

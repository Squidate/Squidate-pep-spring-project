package com.example.service;
import com.example.entity.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
private final List<Message> messages = new ArrayList<>();

public Message messages(Message message) {
return message;
}

public Message createMessage(Message message) {
return message;
}

public List<Message> getAllMessages(){
 return new ArrayList<>(messages);
}

public Message getMessageById(int id){
    return null;
}

public int deleteMessage(int id){
    return 0;
}

public List<Message> getMessagesByUser(int accountId){
    return new ArrayList<>();
}

public int updateMessage(int id, String newText){
    return 0;
}

}

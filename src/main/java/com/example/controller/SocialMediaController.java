package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @RestController
public class SocialMediaController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageService messageService;
    

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody Account account){
if (account.getUsername() == null || account.getUsername().isBlank() || account.getPassword() == null || account.getPassword().length() < 4){
    return ResponseEntity.badRequest().build();
}
Account created = accountService.register(account);
if (created == null){
    return ResponseEntity.status(HttpStatus.CONFLICT).build();
}
return ResponseEntity.ok(created);
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Account account){
    Account existing = accountService.login(account);
    if (existing == null){
        return ResponseEntity.status(401).build();
    }
    return ResponseEntity.ok(existing);
}

@PostMapping("/messages")
public ResponseEntity<?> messages(@RequestBody Message message){
    if (message.getMessageText() == null || message.getMessageText().isBlank() || message.getMessageText().length() > 255){
        return ResponseEntity.badRequest().build();
    }
    Message created = messageService.createMessage(message);
    if (created == null){
        return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(created);
}

@GetMapping("/messages")
public ResponseEntity<List<Message>> getAllMessages(){
return ResponseEntity.ok(messageService.getAllMessages());
}

@GetMapping("/messages/{id}")
public ResponseEntity<?> getMessageById(@PathVariable("id") int id){
    Message message = messageService.getMessageById(id);
    if (message == null){
        return ResponseEntity.ok().body("");
    }
    return ResponseEntity.ok(message);
}

@DeleteMapping("/messages/{id}")
public ResponseEntity<?> deleteMessage(@PathVariable("id") int id){
    int rowDeleted = messageService.deleteMessage(id);
    if (rowDeleted == 0){
        return ResponseEntity.ok().body("");
    }
    return ResponseEntity.ok(rowDeleted);
}

@PatchMapping("/messages/{id}")
public ResponseEntity<?> updateMessage(@PathVariable("id") int id, @RequestBody Message update){
 if (update.getMessageText() == null || update.getMessageText().isBlank() || update.getMessageText().length() > 255){
    return ResponseEntity.badRequest().build();
 }
 int rowUpdate = messageService.updateMessage(id, update.getMessageText());
 if (rowUpdate == 0){
    return ResponseEntity.badRequest().build();
 }
 return ResponseEntity.ok(rowUpdate);
}

@GetMapping("/accounts/{accountId}/messages")
public ResponseEntity<?> getMessagesByAccountId(@PathVariable("accountId") int accountId){
    return ResponseEntity.ok(messageService.getMessagesByUser(accountId));
}
}

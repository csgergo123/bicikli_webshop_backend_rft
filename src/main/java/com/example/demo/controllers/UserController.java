package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Összes felhasználó visszaadása
     * 
     * @return
     */
    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Adott ID-jű felhasználó visszaadása
     * 
     * @param userId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value="id") Long userId) throws ResourceNotFoundException {
        User user = userRepository
                .findById(userId)
                .orElseThrow( () -> new ResourceNotFoundException("User not found on :: " + userId) );
        return ResponseEntity.ok().body(user);
    }

    /**
     * Új felhasználó beszúrása
     * 
     * @param user
     * @return
     */
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * Felhasználó adatainak frissítése
     * 
     * @param userId
     * @param userDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        
        user.setEmail(userDetails.getEmail());
        user.setJelszo(userDetails.getJelszo());
        user.setRole(userDetails.getRole());
        user.setKeresztnev(userDetails.getKeresztnev());
        user.setVezeteknev(userDetails.getVezeteknev());
        user.setTelefonszam(userDetails.getTelefonszam());
        user.setOrszag(userDetails.getOrszag());
        user.setVaros(userDetails.getVaros());
        user.setIranyitoszam(userDetails.getIranyitoszam());
        user.setUtca(userDetails.getUtca());
        user.setHazszam(userDetails.getHazszam());
        user.setEmelet(userDetails.getEmelet());
        user.setAjto(userDetails.getAjto());
        
        final User updatedUser = userRepository.save(user);
        
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Felhasználó törlése
     * @param userId
     * @return
     * @throws Exception
     */
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

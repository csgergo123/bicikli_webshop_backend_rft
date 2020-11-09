package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Összes felhasználó visszaadása
     * 
     * @return
     */
    @GetMapping("/")
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
    @GetMapping("/{id}")
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
    @PostMapping("/")
    public User createUser(@Valid @RequestBody User user){
        user.setJelszo(passwordEncoder.encode(user.getJelszo()));
        
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
    @PutMapping("/{id}")
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
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    @GetMapping("/logout")
    public String logout() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//        SecurityContextHolder.getContext().setAuthentication(null);
//        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        
        return "logout";
    }
    
    @GetMapping("/logoutsuccess")
    public String logoutSuccess() throws Exception {
        return "logout successful";
    }


}

package com.example.demo.controllers;

import com.example.demo.entities.Bicikli;
import com.example.demo.repositories.BicikliRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BicikliController {
    
    @Autowired
    private BicikliRepository bicikliRepository;


    // Get all bicikli
    @GetMapping("/biciklik")
    public Iterable<Bicikli> getAllBicikli() {
        return bicikliRepository.findAll();
    }

    // Get one bicikli
    @GetMapping("/bicikli/{id}")
    public ResponseEntity<Bicikli> get(@PathVariable Integer id) {
        Optional<Bicikli> bicikli = bicikliRepository.findById(id);
        if (bicikli.isPresent()) {
            return ResponseEntity.ok(bicikli.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create bicikli
    @PostMapping("/bicikli")
    public Bicikli createBicikli(@RequestBody Bicikli bicikli) {
        return bicikliRepository.save(bicikli);
    }

    /*

    @Autowired
    private RendelesRepository rendelesRepository;

    @Autowired
    private KepekRepository kepekRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;


    @GetMapping("")
    public ResponseEntity<Iterable<Bicikli>> getAll() {
        User user = authenticatedUser.getUser();
        User.Role role = user.getRole();
        if (role.equals(User.Role.ROLE_ADMIN)) {
            return ResponseEntity.ok(bicikliRepository.findAll());
        } else {
            return ResponseEntity.ok(bicikliRepository.findAllByUser(user));
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Bicikli> get(@PathVariable Integer id) {
        Optional<Bicikli> issue = bicikliRepository.findById(id);
        if (issue.isPresent()) {
            return ResponseEntity.ok(issue.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<Bicikli> post(@RequestBody Bicikli issue) {
        User user = authenticatedUser.getUser();
        issue.setUser(user);
        Bicikli savedBicikli = bicikliRepository.save(issue);
        return ResponseEntity.ok(savedBicikli);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Bicikli> update
            (@PathVariable Integer id,
             @RequestBody Bicikli issue) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            issue.setId(id);
            return ResponseEntity.ok(bicikliRepository.save(issue));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Bicikli> delete
            (@PathVariable Integer id) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            bicikliRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @GetMapping("/{id}/rendelesek")
    public ResponseEntity<Iterable<Rendeles>> rendelesek
            (@PathVariable Integer id) {
        Optional<Bicikli> bicikli = bicikliRepository.findById(id);
        if (bicikli.isPresent()) {
            return ResponseEntity.ok(bicikli.get().getMessages());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @PostMapping("/{id}/messages")
    public ResponseEntity<Message> insertMessage
            (@PathVariable Integer id,
             @RequestBody Message message) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            Bicikli bicikli = oBicikli.get();
            message.setBicikli(bicikli);
            return ResponseEntity.ok(
                rendelesRepository.save(message));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @GetMapping("/{id}/kepeks")
    public ResponseEntity<Iterable<Kepek>> kepeks
        (@PathVariable Integer id) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            return ResponseEntity.ok(oBicikli.get().getKepeks());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @PostMapping("/{id}/kepeks")
    public ResponseEntity<Kepek> insertKepek
        (@PathVariable Integer id, 
         @RequestBody Kepek kepek) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            Bicikli bicikli = oBicikli.get();
            Kepek newKepek = kepekRepository.save(kepek);
            bicikli.getKepeks().add(newKepek);
            bicikliRepository.save(bicikli);
            return ResponseEntity.ok(newKepek);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @PutMapping("/{id}/kepeks")
    public ResponseEntity<Iterable<Kepek>> modifyKepeks
        (@PathVariable Integer id,
         @RequestBody List<Kepek> kepeks) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            Bicikli bicikli = oBicikli.get();
            
            for (Kepek kepek: kepeks) {
                if (kepek.getId() == null) {
                    kepekRepository.save(kepek);
                }
            }
            
            bicikli.setKepeks(kepeks);
            bicikliRepository.save(bicikli);
            return ResponseEntity.ok(kepeks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     */
}

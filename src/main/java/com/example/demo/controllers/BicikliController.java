package com.example.demo.controllers;

import com.example.demo.entities.Bicikli;
import com.example.demo.entities.Kepek;
import com.example.demo.repositories.BicikliRepository;
import com.example.demo.repositories.KepekRepository;

import java.util.List;
import java.util.Optional;

import net.minidev.json.JSONUtil;
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

    @Autowired
    private KepekRepository kepekRepository;


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

    // Delete a bicikli
    @DeleteMapping("/biciki/{id}")
    public ResponseEntity<Bicikli> delete (@PathVariable Integer id) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (!oBicikli.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bicikliRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update a bicikli
    @PutMapping("/bicikli/{id}")
    public ResponseEntity<Bicikli> update
            (@PathVariable Integer id,
             @RequestBody Bicikli bicikliDetails) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (!oBicikli.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Bicikli bicikli = oBicikli.get();
        if(bicikliDetails.getLeiras() != null)
            bicikli.setLeiras(bicikliDetails.getLeiras());
        if(bicikliDetails.getNev() != null)
            bicikli.setNev(bicikliDetails.getNev());
        if(bicikliDetails.getTipus() != null)
            bicikli.setTipus(bicikliDetails.getTipus());
        if(bicikliDetails.getMeret() != null)
            bicikli.setMeret(bicikliDetails.getMeret());
        if(bicikliDetails.getSebessegElol() != null)
            bicikli.setSebessegElol(bicikliDetails.getSebessegElol());
        if(bicikliDetails.getSebessegHatul() != null)
            bicikli.setSebessegHatul(bicikliDetails.getSebessegHatul());
        if(bicikliDetails.getSzin() != null)
            bicikli.setSzin(bicikliDetails.getSzin());
        if(bicikliDetails.getFek() != null)
            bicikli.setFek(bicikliDetails.getFek());
        if(bicikliDetails.getTeleszkop() != null)
            bicikli.setTeleszkop(bicikliDetails.getTeleszkop());
        if(bicikliDetails.getVaz() != null)
            bicikli.setVaz(bicikliDetails.getVaz());
        if(bicikliDetails.getKeszlet() != null)
            bicikli.setKeszlet(bicikliDetails.getKeszlet());
        if(bicikliDetails.getNettoAr() != null)
            bicikli.setNettoAr(bicikliDetails.getNettoAr());
        bicikliRepository.save(bicikli);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bicikli/{id}/kepek")
    public ResponseEntity<Iterable<Kepek>> kepeks
            (@PathVariable Integer id) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (oBicikli.isPresent()) {
            return ResponseEntity.ok(oBicikli.get().getKepekList());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bicikli/{id}/kep")
    public ResponseEntity<Kepek> insertKepek
            (@PathVariable Integer id,
             @RequestBody List<Kepek> kepek) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (!oBicikli.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Bicikli bicikli = oBicikli.get();
        for (Kepek kep : kepek) {
            kep.setBicikli(bicikli);
            Kepek newKep = kepekRepository.save(kep);
            bicikli.getKepekList().add(newKep);
            bicikliRepository.save(bicikli);
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/bicikli/{id}/kepek")
    public ResponseEntity<Iterable<Kepek>> modifyKepek
            (@PathVariable Integer id,
             @RequestBody List<Kepek> kepek) {
        Optional<Bicikli> oBicikli = bicikliRepository.findById(id);
        if (!oBicikli.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Bicikli bicikli = oBicikli.get();

        for (Kepek kep: kepek) {
            if (kep.getId() == null) {
                kep.setBicikli(bicikli);
                kepekRepository.save(kep);
            }
        }

        bicikli.setKepekList(kepek);
        bicikliRepository.save(bicikli);
        return ResponseEntity.ok().build();
    }

    /*

    @Autowired
    private RendelesRepository rendelesRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

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
     */
}

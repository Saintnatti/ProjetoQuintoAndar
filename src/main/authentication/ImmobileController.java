package com.example.projetoQuintoAndar.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImmobileController {

    @Autowired
    private ImmobileRepository ImmobileRepository;

    @RequestMapping("/register")
    public Immobile Register(@RequestBody Immobile immobile) {
        return ImmobileRepository.save(immobile);
    }

    @RequestMapping("")
    public Immobile GetById(@RequestBody BigInteger id) {
        Immobile immobileSaved = ImmobileRepository.findById(id);
        if (immobileSaved == null) {
            throw new Error("Imóvel não encontrado");
        } else {
            return immobileSaved;
        }
    }

    @RequestMapping("/update")
    public Immobile Update(@RequestBody Immobile immobile) {
        Immobile immobileSaved = ImmobileRepository.findById(immobile.id);
        if (immobileSaved == null) {
            throw new Error("Imóvel não encontrado");
        } else {
            ImmobileRepository.update(immobile);
            return immobile;
        }
    }

    @RequestMapping("/delete")
    public Immobile Delete(@RequestBody Immobile immobile) {
        Immobile oldImmobile = ImmobileRepository.findById(immobile.id);
        if (oldImmobile == null) {
            throw new Error("Erro ao tentar apagar a imóvel");
        } else {
            ImmobileRepository.delete(oldImmobile);
            return oldImmobile;
        }
    }
}

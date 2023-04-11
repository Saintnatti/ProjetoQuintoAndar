package com.example.projetoQuintoAndar.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    public User Register(@RequestBody User user) {
        User existsUserEmail = userRepository.findByEmailAndSenha(user.getEmail(), user.getSenha());
        User existsUserCel = userRepository.findByCelularAndSenha(user.getCelular(), user.getSenha());

        if (existsUserEmail != null || existsUserCel != null) {
            throw new Error("Este usuário já existe!");
        } else {
            return userRepository.save(user);
        }
    }

    @RequestMapping("/login")
    public User Login(@RequestBody User user) {
        User oldUserEmail = userRepository.findByEmailAndSenha(user.email, user.senha);
        User oldUserCel = userRepository.findByCelularAndSenha(user.celular, user.senha);
        if (oldUserEmail == null && oldUserCel == null) {
            throw new Error("Este usuário não existe");
        } else {
            return oldUserEmail;
        }
    }

    @RequestMapping("/delete")
    public User Delete(@RequestBody User user) {
        User oldUser = userRepository.deleteByEmail(user.email);
        if (oldUser == null) {
            throw new Error("Erro ao tentar apagar a conta");
        } else {
            userRepository.delete(oldUser);
            return oldUser;
        }
    }

}

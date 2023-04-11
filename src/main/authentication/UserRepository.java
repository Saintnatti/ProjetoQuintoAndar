package com.example.projetoQuintoAndar.authentication;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
    User findByEmailAndSenha(String email, String senha);

    User findByCelularAndSenha(String celular, String senha);

    User findByEmail(String email);

    User findByCelular(String celular);

    User deleteByEmail(String email);
}

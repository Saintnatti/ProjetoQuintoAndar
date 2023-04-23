package com.example.projetoQuintoAndar.authentication;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImobbileRepository extends MongoRepository<Imobbile, BigInteger> {
    Imobbile findById(BigInteger id);

    Imobbile deleteById(BigInteger id);

    Imobbile updateById(BigInteger id);
}
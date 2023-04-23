package com.example.projetoQuintoAndar.authentication;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Immobile {
    @Id
    @GeneratedValue
    BigInteger id;
    BigInteger userId;
    Endereco endereco;
    Tipo tipo;
    Caracteristicas caracteristicas;
    Valores valores;

    // seus respectivos getters e setters
}

public class Endereco {
    String rua;
    String bairro;
    String cep;
    String numero;
    String uf;
    String cidade;

    // seus respectivos getters e setters
}

public class Tipo {
    String titulo;
    Integer tipoImovel;
    Integer qtdQuartos;
    Integer tamanho;

    // seus respectivos getters e setters
}

public class Caracteristicas {
    Boolean mobiliado;
    String[] mobilias;
    Boolean aceitaPets;
    Boolean vagaCarro;
    Integer qtdVagaCarros;
    Boolean banheiros;
    Integer qtdBanheiros;

    // seus respectivos getters e setters
}

public class Valores{
    TipoNegocio tipoNegocio;
    Decimal valorAluguel;
    Boolean condominio;
    Decimal valorCondominio;
    Boolean iptu;
    Decimal valorIPTU;
    Boolean SeguroIncendio;
    Decimal valorSeguroIncendio;

    // seus respectivos getters e setters
}

public enum TipoImovel {
    kitnetStudio(1),
    Apartamento(2),
    Casa(3),
    CasaCondominio(4)
}

public enum TipoNegocio {
    Aluguel(1),
    Venda(2)
}
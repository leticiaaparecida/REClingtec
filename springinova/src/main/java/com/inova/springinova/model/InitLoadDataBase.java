package com.inova.springinova.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitLoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(InitLoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(AdmRepository repository){
        return args ->{
            //aqui voce vai colocar seu código de inserção de dados iniciais no banco

            Administrador adm1 = new Administrador("Fátima Transportes", "Av. Ernesto Vaz de Lima, 79");
            Empresa emp1 = new Empresa("Av. Ernesto Vaz de Lima, 79", "Horários de Onibus");
            emp1.setAdministrador(adm1); //sincronizar a conexão bidirecional

            Administrador adm2 = new Administrador("JTP Transportes", "R. Miguel Salaroli, 251");
            Empresa emp2 = new Empresa("R. Miguel Salaroli, 251", "Horários e pontos de partida");
            emp2.setAdministrador(adm2); //sincronizar a conexão bidirecional

            log.info("Inserindo: "+ repository.save(adm1));
            log.info("Inserindo: "+ repository.save(adm2));
            
        };
        
    }
}

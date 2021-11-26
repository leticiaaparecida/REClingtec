package com.inova.springinova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Empresa {

    @ManyToOne
    private Administrador administrador;

    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String endereco;
        private String info;
        
        public Empresa(){}

        public Empresa (String endereco, String info ){
            this.endereco = endereco;
            this.info = info;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public void setAdministrador(Administrador administrador2) {
        }
    
}

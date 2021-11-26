package com.inova.springinova.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
    public class Administrador {

        @OneToMany(mappedBy = "administrador", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
        private List<Empresa>empresas;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String nome;
        private String endereco;
        
        public Administrador(){}

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public Administrador (String nome, String endereco ){
            this.nome = nome;
            this.setEndereco(endereco);
        }

        public String getNome(){
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public void setEmpresa(List<Empresa> empresa) {
        }


        
    }
    

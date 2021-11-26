package com.inova.springinova.controller;

import java.util.List;

import com.inova.springinova.model.AdmRepository;
import com.inova.springinova.model.EmpresaRepository;
import com.inova.springinova.model.Administrador;
import com.inova.springinova.model.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AdmController {

    private static final Logger log = LoggerFactory.getLogger(AdmController.class);

    @Autowired
    AdmRepository admRepository;
    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping("/administradores")
    public List< Administrador > getAdministradores(){
        return (List<Administrador>) admRepository.findAll();
    }

    //retorna a cadastro pelo id
    @GetMapping("/administradores/{id}")
    @ResponseBody
    public Administrador getAdministradorById(@PathVariable("id") Administrador administrador){
        return administrador;
    }

    //adiciona um registro no banco
    @PostMapping("/administradores/criar")
    public Administrador postAdministrador(@RequestBody Administrador administrador){
        admRepository.save(administrador);
        if(admRepository.findById(administrador.getId()).isPresent())
            return administrador;
        return null;
      }

    //cria empresa e adiciona no banco
    @PostMapping("/administradores/{id}/criar_empresa")
      public Empresa postEmpresaToLista(@PathVariable Long id, @RequestBody Empresa empresa){
          if(admRepository.findById(id).isPresent()){
              Administrador administrador = admRepository.findById(id).get();
              log.debug(administrador.getNome());
              empresa.setAdministrador(administrador);
              empresa = empresaRepository.save(empresa);
              return empresa;
          }
          return null;
      }
    
    //retorna empresa pelo id
    @GetMapping("/administrador/retorn_empresa/{id}")
    @ResponseBody
    public Empresa getListaId(@PathVariable("id") Empresa empresa){
        return empresa;
    }
    
    //altera empresa ja cadastrada
    @PutMapping("/administradores/alterar_empresa/{id}")
      public Empresa putEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){
          if(empresaRepository.findById(id).isPresent()){
              Empresa empresaAlt = empresaRepository.findById(id).get();
              empresaAlt.setEndereco(empresa.getEndereco());
              empresaAlt.setInfo(empresa.getInfo());
              empresaRepository.save(empresaAlt);
              return empresa;
          }
          return null;
      }
    
    //deleta uma empresa cadastrada
    @DeleteMapping("/administradores/deletar_empresa/{id}")
      public Empresa deleteEmpresaa(@PathVariable Long id){
          if(empresaRepository.findById(id).isPresent()){
              Empresa empresa = empresaRepository.findById(id).get();
              empresaRepository.delete(empresa);
              return empresa;
          }
          return null;
      }

}




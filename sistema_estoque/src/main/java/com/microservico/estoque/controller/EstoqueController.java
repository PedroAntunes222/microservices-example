package com.microservico.estoque.controller;

import constantes.RabbitMQConstantes;
import dto.Estoquedto;
import com.microservico.estoque.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="estoque")
public class EstoqueController {
    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody Estoquedto estoqueDto){
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}

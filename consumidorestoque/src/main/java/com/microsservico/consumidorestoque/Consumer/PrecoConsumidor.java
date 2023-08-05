package com.microsservico.consumidorestoque.Consumer;


import constantes.RabbitMQConstantes;
import dto.Precodto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

public class PrecoConsumidor {
    @RabbitListener(queues = RabbitMQConstantes.FILA_PRECO)
    private void Consumidor(Precodto precodto){
        System.out.println("----- Preco -----");
        System.out.println(precodto.codigoProduto);
        System.out.println(precodto.preco);
        System.out.println("-----------------------");
    }
}

package com.microsservico.consumidorestoque.Consumer;


import constantes.RabbitMQConstantes;
import dto.Estoquedto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumidor {
    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void Consumidor(Estoquedto estoquedto){
        System.out.println("------- Estoque -------");
        System.out.println(estoquedto.codigoProduto);
        System.out.println(estoquedto.quantidade);
        System.out.println("-----------------------");
    }
}

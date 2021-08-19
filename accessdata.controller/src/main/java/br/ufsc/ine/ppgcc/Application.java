package br.ufsc.ine.ppgcc;

import br.ufsc.ine.ppgcc.client.DocumentClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = DocumentClient.class)
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}

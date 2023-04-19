package com.nttdata.projetoSpring.validators;

import com.nttdata.projetoSpring.model.AlunoEntity;
import com.nttdata.projetoSpring.model.DisciplinaEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;

@Component
public class MinisterioValidator {

    WebClient getMinisterio = WebClient.builder().baseUrl("http://localhost:8082").defaultHeader("Content-Type", new String[]{"application/json"}).defaultUriVariables(Collections.singletonMap("url", "http://localhost:8082")).clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection()))).build();

    public boolean validarAluno(String cpf){
        //Pego no base URL e envio o cpf pra o ministério
        AlunoEntity a = getMinisterio.get().uri("/getAluno/"+ cpf).retrieve().bodyToMono(AlunoEntity.class).block();

        if (a != null){
            return true;
        } else {
            return false;

        }
    }

    public boolean validarDisciplina(Integer id){
        DisciplinaEntity d = getMinisterio.get().uri("/getDisciplina/"+ id).retrieve().bodyToMono(DisciplinaEntity.class).block();

        if (d != null){
            return true;
        } else {
            return false;

        }
    }
}

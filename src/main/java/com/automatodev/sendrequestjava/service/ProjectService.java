package com.automatodev.sendrequestjava.service;

import com.automatodev.sendrequestjava.dto.UserDto;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;



@Service
public class ProjectService {

    @Autowired
    private RestTemplate restTemplate;
    
    /** 
     * 
     * @author Marco Aurelio
     * @date 17/07/2021
     * @param id
     * @return Mono<UserDto>
     * 
     * Metodo que consome uma api rest
     * pode ser localhost ou externa, ideal para usar na comunicação entre microsserviços.
     */
    public Mono<UserDto> fetchById(Long id) {

        // -> Consumindo serviços externos com api web flux spring


        /**
         * Primeira forma usando Webclient com ResponseSpec
         * Deste modo é necessário extrair o tupo usando um blockOptional quando for receber o objeto, pois o mesmo retorna um Mono<Objeto>
         */
        WebClient client = WebClient.create();
        ResponseEntity<UserDto> user = client.get().uri("https://econommiza-api.herokuapp.com/econommiza-app/usuarios/3/").retrieve().toEntity(UserDto.class).block();
        System.out.println(user.getStatusCode());

        
        /**
         * Tratamento de status usando onStatus do WebClient
         */
    
        ResponseEntity response = client.get().uri("https://econommiza-api.herokuapp.com/econommiza-app/usuarios/2").retrieve().onStatus(status -> status.value() == 401,clienteResponse -> Mono.empty()).toEntity(UserDto.class).block();

        
        /*Segunda forma usando RestTampblet (Será depreciado em breve, foi substituido pelo WebClient da mesma api)*/
        UserDto userRest = restTemplate.getForObject("https://econommiza-api.herokuapp.com/econommiza-app/usuarios/3", UserDto.class);
        System.out.println(userRest.getEmail());

        /**
        * Terceira forma retornando diretamente um WebCLient usando o padrão Builder
        * Deste modo é necessário extrair o tupo usando um blockOptional quando for receber o objeto, pois o mesmo retorna um Mono<Objeto>
        */
        return WebClient.builder().baseUrl("https://econommiza-api.herokuapp.com/econommiza-app/").build().get().uri("usuarios/3")
            .retrieve().bodyToMono(UserDto.class);

    }
}

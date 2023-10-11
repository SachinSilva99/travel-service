package com.sachin.travelservice.api;

import com.sachin.travelservice.dto.TravelDTO;
import com.sachin.travelservice.dto.UserDTO;
import com.sachin.travelservice.util.StandardResponse;
import jakarta.validation.Valid;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/v1/travels", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TravelController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createTravel(
            @RequestBody @Valid TravelDTO travelDTO
    ) {

        System.out.println(travelDTO);
        return "works";
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{travelId}")
    public TravelDTO getTravel(@PathVariable String travelId) {
        String apiUrl = "http://localhost:8090/userservice/api/v1/users/65268dcafb1c4e1ce75bc398";


        WebClient webClient = WebClient.create(apiUrl);
        Mono<StandardResponse<UserDTO>> standardResponseMono = webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<StandardResponse<UserDTO>>() {});

        StandardResponse<UserDTO> block = standardResponseMono.block();
        assert block != null;
        UserDTO data = (UserDTO) block.getData();
        System.out.println(data);
        return null;
    }


}

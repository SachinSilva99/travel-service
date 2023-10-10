package com.sachin.travelservice.api;

import com.sachin.travelservice.dto.TravelDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/travels")
@Validated
public class TravelController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createTravel(
            @Valid @ModelAttribute TravelDTO travelDTO
    ) throws IOException {
        System.out.println(travelDTO);
        return "works";
    }


}

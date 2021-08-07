package sr.hit.helloworld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
public class IndexController {

    @GetMapping(value = "/")
    public ResponseEntity<Object> index() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        var response = new HashMap<String, String>();
        response.put("message", "Hellow World from Docker");
        response.put("time", LocalDateTime.now(ZoneId.of("UTC-5")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS")));

        return ResponseEntity.accepted().body(mapper.writeValueAsString(response));

    }


}

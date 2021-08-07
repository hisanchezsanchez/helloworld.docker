package sr.hit.helloworld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sr.hit.helloworld.config.FirebaseProperties;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexController {
    private final FirebaseProperties firebaseProperties;

    @GetMapping(value = "/")
    public ResponseEntity<Object> index() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var response = new HashMap<String, String>();
        response.put("message", "Hellow World from Docker");
        response.put("time", LocalDateTime.now(ZoneId.of("UTC-5")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS")));
        response.put("firebase.user", firebaseProperties.getUser());
        response.put("firebase.pwd", firebaseProperties.getPwd());
        var result = mapper.writer().with(SerializationFeature.INDENT_OUTPUT).writeValueAsString(response);
        log.info(" result with format {}", result);
        return ResponseEntity.accepted().body(result);
    }
}

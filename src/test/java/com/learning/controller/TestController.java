package com.learning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.rest.EventWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amits on 16/09/16.
 */
@RestController
@RequestMapping("test")
public class TestController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping()
    public EventWrapper getEventData(@RequestParam("event_type") String eventType) throws IOException {
        return populateFromFile(eventType);
    }

    private EventWrapper populateFromFile(String fileName) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources", fileName + ".json");
        List<String> strings = Files.readAllLines(path);
        String fileContent = strings.stream().collect(Collectors.joining("\n"));
        return objectMapper.readValue(fileContent, EventWrapper.class);
    }
}

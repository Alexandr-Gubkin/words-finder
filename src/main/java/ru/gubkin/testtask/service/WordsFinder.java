package ru.gubkin.testtask.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WordsFinder {

    final private Path path = Paths.get("src/main/resources/dictionary.txt");

    public List<String> findWords(String wordPart) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(path)) {
            lines = lineStream.filter(word -> word.toLowerCase().
                    matches(wordPart.toLowerCase() + ".+")).
                    map(word -> word.replace(word.substring(0, wordPart.length()), wordPart)).
                    sorted().
                    collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}




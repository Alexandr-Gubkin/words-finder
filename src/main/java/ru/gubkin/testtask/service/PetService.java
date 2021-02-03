package ru.gubkin.testtask.service;

import org.springframework.stereotype.Service;
import ru.gubkin.testtask.pojo.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PetService {

    private List<Pet> petList = new ArrayList<>();

    public String findName(String name) {
        return petList.stream().filter(x -> x.getName().equals(name)).findFirst().get().getName();
    }

    public void putPet(Pet pet) {
        petList.add(pet);
    }
}
package com.hillel.dz_11;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/controller")
public class Controller {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Everyone!";
    }

    private List<UserDTO> usersList = new ArrayList<>();

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {

        if (userDTO.name() != null && userDTO.age() != null
        && userDTO.surname() != null) {
            usersList.add(userDTO);
            System.out.println("Added user " + usersList.size() + ") " + userDTO.name() + " " + userDTO.surname() +
                    " " + userDTO.age());
        }
        return userDTO;
    }

    private List<UserDTO> helperArray = new ArrayList<>();

    @GetMapping("/users/{usersName}")
    public List<UserDTO> findUser(@PathVariable String usersName) {

        List<UserDTO> searchedUsersList = new ArrayList<>();

        for (UserDTO userDTO : usersList) {
            if (userDTO.name().toLowerCase(Locale.ROOT).contains(usersName.toLowerCase(Locale.ROOT))) {
                searchedUsersList.add(userDTO);
                System.out.println(userDTO.name() + " " + userDTO.surname() +
                        " " + userDTO.age());
            }
        }
        helperArray = searchedUsersList;
        return searchedUsersList;
    }

    @GetMapping("/users/{usersName}/{number}")
    public UserDTO findExactlyUser(@PathVariable Integer number) {
        return helperArray.get(number - 1);
    }
}

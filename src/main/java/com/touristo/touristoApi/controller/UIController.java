package com.touristo.touristoApi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UIController {

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        String htmlResponse = "<html><body>" +
                "<pre><br><br><br>" +
                "                     ,---------------------------,\n" +
                "                     |  /---------------------\\  |\n" +
                "                     | |                       | |\n" +
                "                     | |                       | |\n" +
                "                     | |        Welcome        | |\n" +
                "                     | |    To Touristo API    | |\n" +
                "                     | |                       | |\n" +
                "                     | |                       | |\n" +
                "                     |  \\_____________________/  |\n" +
                "                     |___________________________|\n" +
                "                      ,--\\_____     []     _______/-----,\n" +
                "                     /         /______________\\        /|\n" +
                "                    /________________________________ / | ___\n" +
                "                    |                                 | |    )\n" +
                "                    |  _ _ _               [-------]  | |   (\n" +
                "                    |  o o o               [-------]  | /    _)_\n" +
                "                    |________________________________ |/     /  /\n" +
                "                    /-----------------------------------/   ( )/\n" +
                "                    /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ \n" +
                "                    /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ " +
                "</pre>" +
                "</body></html>";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlResponse, headers, HttpStatus.OK);
    }
}

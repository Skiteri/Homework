package com.skitel.gaishnik.controllers;


import com.skitel.gaishnik.Number;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController  {

    private final Number current;

    public MainController(Number current) {
        this.current = current;
    }


    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public ResponseEntity<String> next(ModelAndView model) {
        HttpHeaders h = new HttpHeaders();
        current.next();
        h.add("Content-type", "text/html;charset=UTF-8");
        return new ResponseEntity<>(current.toString(), h, HttpStatus.OK);
    }
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ResponseEntity<String> random() {
        HttpHeaders h = new HttpHeaders();
        h.add("Content-type", "text/html;charset=UTF-8");
        current.random();
        return new ResponseEntity<>(current.toString(), h, HttpStatus.OK);
    }
}

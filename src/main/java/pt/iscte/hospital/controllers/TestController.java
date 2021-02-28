package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping(value="/test")
    public String pageTest(){
        return "test";
    }

    @GetMapping(value="/faturaForm")
    public String pageFaturaForm(){
        return "faturaForm";
    }

    @GetMapping(value="/historicoPagamentos")
    public String page(){
        return "historicoPagamentos";
    }
}
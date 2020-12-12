package com.example.azure.wsfake;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {
    @GetMapping("/value")
    public Result getResult() {
        return new Result("Foo Bar");
    }
}

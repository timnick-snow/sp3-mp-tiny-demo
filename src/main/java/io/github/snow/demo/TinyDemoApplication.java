package io.github.snow.demo;

import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TinyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyDemoApplication.class, args);
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping("/mp/demo/{id}")
    public User getUser(@PathVariable String id) {
        return userMapper.selectById(id);
    }

}
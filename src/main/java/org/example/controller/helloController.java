package org.example.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.example.dto.team.TeamSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class helloController {
    @RequestMapping(value="hello", method = RequestMethod.GET)
    public String hello()
    {
        return "hello";
    }
}

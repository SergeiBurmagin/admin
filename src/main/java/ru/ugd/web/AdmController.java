package ru.ugd.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.web.bind.annotation.*;
import ru.ugd.service.users.UserService;

import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin
@Api(value="AdmController", description="Operations pertaining to products in Online Store")
public class AdmController {

    private static final Logger log = Logger.getLogger(AdmController.class);

    @Autowired
    UserService service;


    @ApiOperation(value = "Выполняем  тест",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @RequestMapping(value = "/users-test",method = RequestMethod.GET,produces = "application/json")


    public Set usersList() {

        Set grantSet = null;

        grantSet = service.findAllGrant("861dfd21-3273-4862-98d6-ec8f6a715c25");



        return grantSet;




    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable("calculateResult")
    public String calculateResult() {
        log.info("Performing expensive calculation...");
        // perform computationally expensive calculation
        return "result";
    }
}

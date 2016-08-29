package com._8x8.controller;

import com._8x8.model.Car;
import com._8x8.model.Owner;
import com._8x8.service.IOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bscridon on 29.08.2016.
 */
@RestController
@RequestMapping(value = "/owner")
@Api(value = "owner", description = "Owner API")
public class OwnerController {

    private IOwnerService ownerService;

    public IOwnerService getOwnerService() {
        return ownerService;
    }

    @Autowired
    public void setOwnerService(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @ApiOperation(value = "addOwner", notes = "Add new owner")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Owner addOwner(@RequestBody Owner owner) throws Exception {
        if (owner == null) {
            throw new Exception("To Do -> addOwner method");
        }
        return ownerService.addOwner(owner);
    }

    @ApiOperation(value = "findOwnerById", notes = "Find owner by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Owner findOwnerById(@PathVariable("id") Long id) throws Exception {
        if (id == null) {
            throw new Exception("To Do -> findOwnerById");
        }
        return ownerService.findOwnerById(id);
    }

    @ApiOperation(value = " getAllOwners", notes = "Get all owners")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @ApiOperation(value = "updateOwner", notes = "Update an owner")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Owner updateOwner(@RequestBody Owner oldOwner) throws Exception {
        if (oldOwner == null) {
            throw new Exception("To do-updateCar");
        }
        return ownerService.updateOwner(oldOwner);
    }

    @ApiOperation(value = "deleteOwner", notes = "Delete an owner")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOwner(@PathVariable("id") Long id) {
        ownerService.deleteOwner(id);
    }

}

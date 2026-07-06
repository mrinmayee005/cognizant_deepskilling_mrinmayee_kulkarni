package com.cognizant.controller;

import com.cognizant.entity.Country;
import com.cognizant.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return service.getByCode(code);
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country update(@PathVariable String code, @RequestBody Country country) {
        return service.updateCountry(code, country);
    }

    @DeleteMapping("/{code}")
    public String delete(@PathVariable String code) {
        service.deleteCountry(code);
        return "Deleted successfully";
    }

    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}
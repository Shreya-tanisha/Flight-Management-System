package com.ezytek.software.controller;

import com.ezytek.software.requestdto.RouteRequestDto;
import com.ezytek.software.responsedto.RouteResponseDto;
import com.ezytek.software.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping
    public RouteResponseDto save(@RequestBody RouteRequestDto dto){
        return routeService.save(dto);
    }
    @GetMapping("/{id}")
    public RouteResponseDto getById(@PathVariable  Long id){
        return routeService.getById(id);

    }
    @GetMapping
    public List<RouteResponseDto> getAll() {
        return routeService.findAllRoute();
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public RouteResponseDto update(@PathVariable Long id,
                                   @RequestBody RouteRequestDto dto) {
        return routeService.update(id, dto);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        routeService.delete(id);
        return "Route deleted successfully";
    }


}

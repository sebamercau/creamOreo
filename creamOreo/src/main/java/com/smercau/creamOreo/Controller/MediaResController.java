package com.smercau.creamOreo.Controller;

import com.smercau.creamOreo.Entity.MediaRes;
import com.smercau.creamOreo.Service.MediaResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mediares")
public class MediaResController {

    @Autowired
    private MediaResService mediaResService;

    // Endpoint para crear un registro de media res
    @PostMapping
    public MediaRes crearProducto(@RequestBody MediaRes mediaRes) {
        return mediaResService.guardarProducto(mediaRes);
    }

    // Endpoint para obtener todos los registros de mediareses
    @GetMapping
    public List<MediaRes> obtenerTodosLosProductos() {
        return mediaResService.obtenerTodosLosRegistros();
    }
}


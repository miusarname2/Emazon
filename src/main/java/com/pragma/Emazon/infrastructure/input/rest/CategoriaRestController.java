package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.handler.ICategoriaHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categoria")
public class CategoriaRestController {

    private final ICategoriaHandler categoriaHandler;

    @PostMapping
    public ResponseEntity<Void> saveCategoria(@RequestBody CategoriaRequest categoriaRequest){
        categoriaHandler.saveCategoria(categoriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RolResponseTest {

    @Test
    void testGettersAndSetters(){
        RolResponse rolResponse = new RolResponse();
        String nombre = "Administrador";
        String descripcion = "Tiene acceso a todas las funcionalidades.";

        rolResponse.setNombre(nombre);
        rolResponse.setDescripcion(descripcion);

        assertEquals(nombre, rolResponse.getNombre());
        assertEquals(descripcion, rolResponse.getDescripcion());
    }

}
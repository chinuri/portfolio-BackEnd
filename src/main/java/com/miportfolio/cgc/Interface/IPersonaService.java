package com.miportfolio.cgc.Interface;

import com.miportfolio.cgc.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Obtengo una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto del tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto (se busca por ID)
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}

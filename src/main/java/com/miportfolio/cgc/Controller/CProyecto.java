package com.miportfolio.cgc.Controller;

import com.miportfolio.cgc.Dto.dtoProyecto;
import com.miportfolio.cgc.Entity.Proyecto;
import com.miportfolio.cgc.Security.Controller.Mensaje;
import com.miportfolio.cgc.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://frontend-1-88288.web.app", "http://localhost:4200"})
@RequestMapping("/proyectos")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if(!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
        
    }
    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {
        if(StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(sProyecto.existsByNombreP(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
                dtoproyecto.getNombreP(), dtoproyecto.getFechaP(),
                dtoproyecto.getDescripcionP(), dtoproyecto.getLinkP(), dtoproyecto.getUrlP()
        );
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creada OK"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto) {
        if(!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(sProyecto.existsByNombreP(dtoproyecto.getNombreP()) && sProyecto.getByNombreP(dtoproyecto.getNombreP()).get().getId() != id ) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        
        proyecto.setNombreP(dtoproyecto.getNombreP());
        proyecto.setFechaP(dtoproyecto.getFechaP());
        proyecto.setDescripcionP(dtoproyecto.getDescripcionP());
        proyecto.setLinkP(dtoproyecto.getLinkP());
        proyecto.setUrlP(dtoproyecto.getUrlP());
        
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
}

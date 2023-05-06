package com.miportfolio.cgc.Security.Repository;

import com.miportfolio.cgc.Security.Entity.Rol;
import com.miportfolio.cgc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

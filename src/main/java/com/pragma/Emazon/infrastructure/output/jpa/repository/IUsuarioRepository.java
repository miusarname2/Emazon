    package com.pragma.Emazon.infrastructure.output.jpa.repository;

    import com.pragma.Emazon.infrastructure.output.jpa.entity.UsuarioEntity;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface IUsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

        Optional<UsuarioEntity> findUserEntityByUsername(String username);

    }

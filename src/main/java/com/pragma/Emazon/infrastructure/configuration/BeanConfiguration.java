package com.pragma.Emazon.infrastructure.configuration;

import com.pragma.Emazon.domain.api.*;
import com.pragma.Emazon.domain.spi.*;
import com.pragma.Emazon.domain.usecase.*;
import com.pragma.Emazon.infrastructure.output.jpa.adapter.*;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.*;
import com.pragma.Emazon.infrastructure.output.jpa.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;
    private final IMarcaRepository marcaRepository;
    private final MarcaEntityMapper marcaEntityMapper;
    private final IArticuloRepository articuloRepository;
    private final ArticuloEntityMapper articuloEntityMapper;
    private final IUsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final IRolRepository rolRepository;
    private final RolEntityMapper rolEntityMapper;
    private final ITipoDocumentoRepository tipoDocumentoRepository;
    private final TipoDocumentoEntityMapper tipoDocumentoEntityMapper;
    private final ICarritoRepository carritoRepository;
    private final CarritoEntityMapper carritoEntityMapper;

    //@Bean
    //public JwtDecoder jwtDecoder() {
    //    return JwtDecoders.fromIssuerLocation("https://dev-34mzyluwbwzfnauy.us.auth0.com/api/v2/");
    //}

    @Bean
    public ICategoriaPersistence categoriaPersistencePort(){
        return new CategoriaJpaAdapter(categoriaRepository,categoriaEntityMapper);
    }

    @Bean
    public ICategoriaPortService categoriaPortService(){
        return new CategoriaUseCase(categoriaPersistencePort());
    }

    @Bean
    public IMarcaPersistence marcaPersistencePort(){
        return new MarcaJpaAdapter(marcaRepository,marcaEntityMapper);
    }

    @Bean
    public IMarcaPortService marcaPortService(){
        return new MarcaUseCase(marcaPersistencePort());
    }

    @Bean
    public IArticuloPersistence articuloPersistencePort(){
        return new ArticuloJpaAdapter(articuloRepository,articuloEntityMapper);
    }

    @Bean
    public IArticuloPortService articuloPortService(){
        return new ArticuloUseCase(articuloPersistencePort());
    }

    @Bean
    public IUsuarioPersistence usuarioPersistencePort(){
        return new UsuarioJpaAdapter(usuarioRepository,usuarioEntityMapper);
    }

    @Bean
    public IUsuarioPortService usuarioPortService(){
        return new UsuarioUseCase(usuarioPersistencePort());
    }

    @Bean
    public IRolPersistence rolPersistencePort(){
        return new RolJpaAdapter(rolRepository,rolEntityMapper);
    }

    @Bean
    public IRolPortService rolPortService(){
        return new RolUseCase(rolPersistencePort());
    }

    @Bean
    public ITipoDocumentoPersistence tipoDocumentoPersistencePort(){
        return new TipoDocumentoJpaAdapter(tipoDocumentoRepository,tipoDocumentoEntityMapper);
    }

    @Bean
    public ITipoDocumentoPortService tipoDocumentoPortService(){
        return new TipoDocumentoUseCase(tipoDocumentoPersistencePort());
    }

    @Bean
    public ICarritoPersistence carritoPersistencePort(){
        return new CarritoJpaAdapter(carritoRepository,carritoEntityMapper);
    }

    @Bean
    public ICarritoPortService carritoPortService(){
        return new CarritoUseCase(carritoPersistencePort());
    }

}

package com.pragma.Emazon.infrastructure.configuration;

import com.pragma.Emazon.domain.api.IArticuloPortService;
import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.api.IMarcaPortService;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import com.pragma.Emazon.domain.spi.IMarcaPersistence;
import com.pragma.Emazon.domain.usecase.ArticuloUseCase;
import com.pragma.Emazon.domain.usecase.CategoriaUseCase;
import com.pragma.Emazon.domain.usecase.MarcaUseCase;
import com.pragma.Emazon.infrastructure.output.jpa.adapter.ArticuloJpaAdapter;
import com.pragma.Emazon.infrastructure.output.jpa.adapter.CategoriaJpaAdapter;
import com.pragma.Emazon.infrastructure.output.jpa.adapter.MarcaJpaAdapter;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.ArticuloEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IArticuloRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;
    private final IMarcaRepository marcaRepository;
    private final MarcaEntityMapper marcaEntityMapper;
    private final IArticuloRepository articuloRepository;
    private final ArticuloEntityMapper articuloEntityMapper;

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

}

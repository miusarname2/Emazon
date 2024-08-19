package com.pragma.Emazon.infrastructure.configuration;

import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import com.pragma.Emazon.domain.usecase.CategoriaUseCase;
import com.pragma.Emazon.infrastructure.output.jpa.adapter.CategoriaJpaAdapter;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    @Bean
    public ICategoriaPersistence categoriaPersistencePort(){
        return new CategoriaJpaAdapter(categoriaRepository,categoriaEntityMapper);
    }

    @Bean
    public ICategoriaPortService categoriaPortService(){
        return new CategoriaUseCase(categoriaPersistencePort());
    }

}

package com.pragma.Emazon.infrastructure.Utils.security;

import com.pragma.Emazon.application.dto.AuthCreateUserRequest;
import com.pragma.Emazon.application.dto.AuthLoginRequest;
import com.pragma.Emazon.application.dto.AuthResponse;
import com.pragma.Emazon.domain.model.Usuario;
import com.pragma.Emazon.infrastructure.Utils.JwtUtils;
import com.pragma.Emazon.infrastructure.output.jpa.entity.RolEntity;
import com.pragma.Emazon.infrastructure.output.jpa.entity.UsuarioEntity;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IRolRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IUsuarioRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioRepository userRepository;
    private final IRolRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        // Buscar usuario por el nombre de usuario
        UsuarioEntity userEntity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        // Lista de autoridades (roles y permisos)
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // Agregar los roles del usuario a la lista de autoridades
        RolEntity rol = roleRepository.findById(userEntity.getId_rol())
                .orElseThrow(() -> new UsernameNotFoundException("El rol asignado al usuario no existe."));

        authorityList.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre()));

        // Aquí podrías agregar permisos adicionales si la estructura de tu aplicación lo requiere
        // rol.getPermissionList().forEach(permission ->
        // authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        // Devolver el UserDetails personalizado con la información del usuario
        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getClave(), // La contraseña ya debería estar codificada
                true, // Suponiendo que tienes un campo enabled en UsuarioEntity
                true, // accountNonExpired (puedes ajustar según tu lógica)
                true, // credentialsNonExpired
                true, // accountNonLocked
                authorityList
        );
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Nombre de usuario o contraseña incorrectos.");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Contraseña incorrecta.");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {

        String username = authLoginRequest.getUsername();
        String password = authLoginRequest.getPassword();

        // Autenticar al usuario
        Authentication authentication = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Crear el token de acceso
        String accessToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(accessToken);
        authResponse.setStatus(true);
        authResponse.setMessage("Usuario logueado exitosamente");
        authResponse.setUsername(username);

        // Crear la respuesta
        return authResponse;
    }

}

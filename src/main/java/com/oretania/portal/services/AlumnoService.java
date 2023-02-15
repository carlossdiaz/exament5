package com.oretania.portal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.oretania.portal.models.Alumno;
import com.oretania.portal.models.Asignatura;
import com.oretania.portal.repositories.AlumnoRepository;

@Service
public class AlumnoService implements UserDetailsService{
    

    @Autowired
    AlumnoRepository repository;


    public List<Alumno> findAll(){
        return repository.findAll();
    }

    public Optional<Alumno> findById(int id){
        Optional<Alumno> alumno = repository.findById(id);
        return alumno;
    }

    public void save(Alumno alumno){
        repository.save(alumno);
    }

    public void update(Alumno alumno){
        repository.save(alumno);
    }

    public void delete(Alumno alumno){
        repository.delete(alumno);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Alumno alumno = repository.findByUserName(username);
        List<Asignatura> asignaturas = alumno.getAsignaturas();
        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for (Asignatura asignatura : asignaturas) {
            roles.add(new SimpleGrantedAuthority(asignatura.getCodigo()));
        }

        UserDetails user = User.builder()
        .username(username)
        .password(alumno.getPassword())
        .authorities(roles)
        .build();

        return user;
        
    }

}

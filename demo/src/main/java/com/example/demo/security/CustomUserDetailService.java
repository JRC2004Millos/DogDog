package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Role;
import com.example.demo.model.UserEntity;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));

        UserDetails userDetails = new User(userDB.getUsername(), userDB.getPassword(),
                mapToGrantedAuthorities(userDB.getRoles()));
        return userDetails;
    }

    private Collection<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity ClienteToUser(Cliente cliente) {
        UserEntity user = new UserEntity();
        user.setUsername(String.valueOf(cliente.getCedula()));
        user.setPassword(passwordEncoder.encode("123"));

        Role roles = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));

        return user;
    }

    public UserEntity VetToUser(Veterinario vet) {
        UserEntity user = new UserEntity();
        user.setUsername(String.valueOf(vet.getCedula()));
        user.setPassword(passwordEncoder.encode(vet.getClave()));

        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));

        return user;
    }

}

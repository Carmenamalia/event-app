package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.AuthRequestDTO;
import com.springapp.iaBiletclone.entities.Role;
import com.springapp.iaBiletclone.entities.RoleType;
import com.springapp.iaBiletclone.entities.User;
import com.springapp.iaBiletclone.exceptions.ResourceNotFoundException;
import com.springapp.iaBiletclone.repositories.RoleRepository;
import com.springapp.iaBiletclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtTokenService jwtTokenService;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;

    @Autowired
    public UserService(AuthenticationManager authenticationManager, RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, JwtTokenService jwtTokenService, UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public String authenticate(AuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestDTO.getUsername());
        return jwtTokenService.generateToken(userDetails);
    }

    @Transactional
    public User register(AuthRequestDTO authRequestDTO) {
        Optional<User> userOptional = userRepository.findUserByUsername(authRequestDTO.getUsername());
        if (userOptional.isPresent()) {
            throw new ResourceNotFoundException("aleardy exist");
        }
        User user = new User();
        user.setUsername(authRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));

        Role role = roleRepository.findByRoleType(RoleType.CLIENT);
        //rolul găsit este adăugat la lista de roluri a utilizatorului
        user.getRoles().add(role);
        //utilizatorul nou creat este adăugat la lista de utilizatori asociată rolului.
        role.getUsers().add(user);
        //utilizatorul nou înregistrat este salvat în repository-ul utilizatorilor și apoi returnat.
        return userRepository.save(user);
    }

}

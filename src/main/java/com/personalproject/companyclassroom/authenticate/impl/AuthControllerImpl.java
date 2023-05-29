package com.personalproject.companyclassroom.authenticate.impl;

import com.personalproject.companyclassroom.authenticate.AuthController;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.exception.ResponseException;
import com.personalproject.companyclassroom.security.jwt.JwtRequest;
import com.personalproject.companyclassroom.security.jwt.JwtResponse;
import com.personalproject.companyclassroom.security.jwt.JwtUtils;
import com.personalproject.companyclassroom.security.service.UserService;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.security.service.impl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<?> authenticateUser(JwtRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));
    }
}

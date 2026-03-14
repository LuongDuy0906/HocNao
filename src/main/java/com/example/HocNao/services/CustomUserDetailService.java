package com.example.HocNao.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.HocNao.models.User;
import com.example.HocNao.models.UserPrincipal;
import com.example.HocNao.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identity) throws UsernameNotFoundException {
        System.out.println(identity);
        User user = userRepository.findByEmail(identity)
                .or(() -> userRepository.findByUsername(identity))
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với: " + identity));
        System.out.println(user.getEmail());

        return new UserPrincipal(user);
    }

}

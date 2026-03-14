package com.example.HocNao.services;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.HocNao.dto.userDTO.ChangePasswordDTO;
import com.example.HocNao.dto.userDTO.UserGetDTO;
import com.example.HocNao.dto.userDTO.UserPostDTO;
import com.example.HocNao.models.Profile;
import com.example.HocNao.models.User;
import com.example.HocNao.repositories.ProfileRepository;
import com.example.HocNao.repositories.UserRepository;
import com.example.HocNao.type.UserRole;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public List<UserGetDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserGetDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            userDTOs.add(new UserGetDTO(user));
        }

        return userDTOs;
    }

    @Transactional
    public UserGetDTO createUser(UserPostDTO userPostDTO) {
        if (userRepository.existsByEmail(userPostDTO.getEmail())) {
            throw new RuntimeException("Email da duoc su dung");
        }

        if (userRepository.existsByUsername(userPostDTO.getUsername())) {
            throw new RuntimeException("Ten nguoi dung da duoc su dung");
        }

        User user = new User();
        user.setUsername(userPostDTO.getUsername());
        user.setEmail(userPostDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userPostDTO.getPassword()));
        if (userPostDTO.getRole() != null) {
            user.setRole(userPostDTO.getRole());
        } else {
            user.setRole(UserRole.USER);
        }

        Profile newProfile = new Profile();
        newProfile.setUser(user);

        user.setProfile(newProfile);

        User newUser = userRepository.save(user);
        return new UserGetDTO(newUser);
    }

    @Transactional
    public String changePassword(ChangePasswordDTO changePasswordDTO) throws NotFoundException {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User existsUser = userRepository.findByUsername(currentUsername).orElseThrow(
                () -> new NotFoundException());

        if (!passwordEncoder.matches(changePasswordDTO.getCurrentPassword(), existsUser.getPassword())) {
            throw new BadCredentialsException("Mat khau khong tung khop");
        }

        if (passwordEncoder.matches(changePasswordDTO.getNewPassword(), existsUser.getPassword())) {
            throw new IllegalArgumentException("Mat khau moi khong duoc giong mat khau cu");
        }

        existsUser.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));

        return "Đổi mật khẩu thành công";
    }
}

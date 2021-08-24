package com.timetabling.demo.service;

import com.timetabling.demo.auth.AppUser;
import com.timetabling.demo.dto.UserDTO;
import com.timetabling.demo.exceptions.UserAlreadyExistsException;
import com.timetabling.demo.model.User;
import com.timetabling.demo.repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo auth;

    @Value("${default.password}")
    private String lecturerPw;

    @Value("${default.password1}")
    private String studentPw;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = auth.findUserByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);

        }
        {
            ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().toUpperCase(Locale.ROOT)));
            AppUser u = new AppUser(grantedAuthorities, user.getEmail(), user.getPassword(),
                    true, true, true, true);
            return u;
        }
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public List<UserDTO> getAllLecturersToList() {
        List<UserDTO> list = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            if (user.getUserRole().equals("lecturer")) {
                UserDTO dto = new UserDTO();
                dto.setUserRole(user.getUserRole());
                dto.setEmail(user.getEmail());
                dto.setfName(user.getfName());
                dto.setlName(user.getlName());
                list.add(dto);
            }
        }
        return list;
    }


    public List<UserDTO> getAllLecturers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userList = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                if (user.getUserRole().equals("lecturer")) {
                    UserDTO listUser = new UserDTO();
                    listUser.setEmail(user.getEmail());
                    listUser.setfName(user.getfName());
                    listUser.setlName(user.getlName());
                    listUser.setContactNumber(user.getContactNumber());
                    userList.add(listUser);
                }
            }
        }
        return userList;
    }


    public List<UserDTO> getAllStudents() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userList = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                if (user.getUserRole().equals("student")) {
                    UserDTO listUser = new UserDTO();
                    listUser.setEmail(user.getEmail());
                    listUser.setfName(user.getfName());
                    listUser.setlName(user.getlName());
                    listUser.setBatchId(user.getBatch());
                    listUser.setContactNumber(user.getContactNumber());
                    userList.add(listUser);
                }
            }
        }
        return userList;
    }


    public User registerUsers(UserDTO dtoUser) throws UserAlreadyExistsException {
        User users = new User();
        if (userRepo.findById(dtoUser.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("This email is already in use. Please try with another email.");
        } else {
            users.setfName(dtoUser.getfName());
            users.setlName(dtoUser.getlName());
            users.setEmail(dtoUser.getEmail());
            users.setUserRole(dtoUser.getUserRole());
            users.setPassword(passwordEncoder.encode(studentPw));
            users.setContactNumber(dtoUser.getContactNumber());
            users.setBatch(dtoUser.getBatchId());
        }
//            emailService.EmailToStudents(dtoUser.getEmail());
        return userRepo.save(users);
    }

    public User registerLecturers(UserDTO dtoUser) throws UserAlreadyExistsException {
        User users = new User();
        if(userRepo.findById(dtoUser.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("This Lecturer Email is already in Use. Please try with another email.");
        }
        else {
            users.setfName(dtoUser.getfName());
            users.setlName(dtoUser.getlName());
            users.setEmail(dtoUser.getEmail());
            users.setUserRole(dtoUser.getUserRole());
            users.setPassword(passwordEncoder.encode(lecturerPw));
            users.setContactNumber(dtoUser.getContactNumber());
            users.setBatch(dtoUser.getBatchId());
        }
//        emailService.EmailToLecturers(dtoUser.getEmail());
        return userRepo.save(users);
    }


    public User getUserByID(String uId) {
        Optional<User> user = userRepo.findById(uId);
        User users = null;
        if (user.isPresent()) {
            users = user.get();
        }
        return users;
    }

    public User updateUserInfo(User dtoUser) {

        User users = new User();
        if (users != null) {
            users.setfName(dtoUser.getfName());
            users.setlName(dtoUser.getlName());
            users.setEmail(dtoUser.getEmail());
            users.setUserRole(dtoUser.getUserRole());
            users.setPassword(passwordEncoder.encode(dtoUser.getPassword()));
            users.setContactNumber(dtoUser.getContactNumber());
            users.setBatch(dtoUser.getBatch());

        }
        return userRepo.save(users);
    }


    public User directUserType(String email) {
        return userRepo.findUserByEmail(email);
    }

    public void removeUser(User user) {
        userRepo.delete(user);
    }

    public List<UserDTO> searchUsers(String name) {
        List<User> userList = new ArrayList<>();
        userList.addAll(userRepo.firstName(name));
        userList.addAll(userRepo.lastName(name));
        List<UserDTO> userList2 = new ArrayList<>();
        for (User user : userList) {
            UserDTO listUser = new UserDTO();
            listUser.setEmail(user.getEmail());
            listUser.setfName(user.getfName());
            listUser.setlName(user.getlName());
            listUser.setBatchId(user.getBatch());
            listUser.setContactNumber(user.getContactNumber());
            userList2.add(listUser);
        }
        return userList2;
    }

}

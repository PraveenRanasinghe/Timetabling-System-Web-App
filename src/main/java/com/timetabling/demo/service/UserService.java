package com.timetabling.demo.service;

import com.timetabling.demo.auth.AppUser;
import com.timetabling.demo.dto.batchDTO;
import com.timetabling.demo.dto.userDTO;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.User;
import com.timetabling.demo.repositary.TimetableRepo;
import com.timetabling.demo.repositary.UserRepo;
import com.timetabling.demo.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private TimetableRepo timetableRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = auth.findUserByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        } else {
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


    public List<userDTO> getAllLecturersToList() {
        List<userDTO> list = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            if(user.getUserRole().equals("lecturer")){
                userDTO dto = new userDTO();
                dto.setUserRole(user.getUserRole());
                dto.setEmail(user.getEmail());
                dto.setfName(user.getfName());
                dto.setlName(user.getlName());
                list.add(dto);
            }

        }
        return list;
    }


    public List<userDTO> getAllLecturers() {
        List<User> users = userRepo.findAll();
        List<userDTO> userList = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                if (user.getUserRole().equals("lecturer")) {
                    userDTO listUser = new userDTO();
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


    public List<userDTO> getAllStudents() {
        List<User> users = userRepo.findAll();
        List<userDTO> userList = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                if (user.getUserRole().equals("student")) {
                    userDTO listUser = new userDTO();
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


    public User registerUsers(userDTO dtoUser) {
        User users = new User();
        if (dtoUser != null) {
            users.setfName(dtoUser.getfName());
            users.setlName(dtoUser.getlName());
            users.setEmail(dtoUser.getEmail());
            users.setUserRole(dtoUser.getUserRole());
            users.setPassword(passwordEncoder.encode("User1234"));
            users.setContactNumber(dtoUser.getContactNumber());
            users.setBatch(dtoUser.getBatchId());
        }
        return userRepo.save(users);
    }


    public User getUserByID(String uId) {
        Optional<User> user = userRepo.findById(uId);
        User users = null;
        if (user.isPresent()) {
            users = user.get();
//            System.out.println(users.getBatch().getBatchID());
        }
        return users;
    }

    public User updateUserInfo(User dtoUser) {

//        Optional<User> user= userRepo.findById(dtoUser.getEmail());
        User users = new User();
//        System.out.println(dtoUser.getBatchId().getBatchID());
        if (users != null) {
            users.setfName(dtoUser.getfName());
            users.setlName(dtoUser.getlName());
            users.setEmail(dtoUser.getEmail());
            users.setUserRole(dtoUser.getUserRole());
            users.setPassword(dtoUser.getPassword());
            users.setContactNumber(dtoUser.getContactNumber());
            users.setBatch(dtoUser.getBatch());

        }
        return userRepo.save(users);
    }
//    public List<batchDTO> getAllBatchesToList(){
//        List<batchDTO> list = new ArrayList<>();
//        for(Batch batch: batchRepo.findAll()){
//            batchDTO dto= new batchDTO();
//            dto.setBatchID(batch.getBatchID());
//            dto.setBatchName(batch.getBatchName());
//            list.add(dto);
//        }
//        return list;
//    }

//    public List<userDTO> getAllLecturersToList(String userRole){
//        List<userDTO> list= new ArrayList<>();
//        for (User user:userRepo.findAll());
//
//    }

}

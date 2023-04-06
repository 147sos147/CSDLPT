package com.example.qlbh.config;

import com.example.qlbh.model.Account;
import com.example.qlbh.model.Role;
import com.example.qlbh.repository.AccountRepository;
import com.example.qlbh.repository.RoleRepository;
import com.example.qlbh.util.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AccountRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (roleRepository.getByNameRole("ROLE_ADMIN")==null){
            Role role = new Role();
            role.setId(1);
            role.setRole_name("ROLE_ADMIN");
            roleRepository.save(role);
        }
        if (roleRepository.getByNameRole("ROLE_MEMBER")==null){
            Role role = new Role();
            role.setId(2);
            role.setRole_name("ROLE_MEMBER");
            roleRepository.save(role);
        }

        //them admin
        if (userRepository.findRoleNameByEmail("admin@email.com") == null){
            Account admin = new Account();
            admin.setId(1);
            admin.setEmail("admin@email.com");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            userRepository.save(admin);
            Account accountDTO = userRepository.findUserByEmail("admin@email.com");
            Role role = new Role();
            role = roleRepository.getByNameRole("ROLE_ADMIN");
            userRepository.createAccountRole(accountDTO.getId(),role.getId());
        }

        //them member
        if (userRepository.findUserByEmail("member@email.com") == null){
            Account admin = new Account();
            admin.setId(2);
            admin.setEmail("member@email.com");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            admin.setFull_name("member1");
            admin.setEmail("member@email.com");
            admin.setNumber_phone("0932568991");
            admin.setAddress("To 48 Hoa Minh");
            userRepository.save(admin);
            Account accountDTO = userRepository.findUserByEmail("member@email.com");
            Role role = new Role();
            role = roleRepository.getByNameRole("ROLE_MEMBER");
            userRepository.createAccountRole(accountDTO.getId(),role.getId());
        }
    }
}

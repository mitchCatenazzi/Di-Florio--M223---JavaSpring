package ch.samt.libraryManager.service;

import ch.samt.libraryManager.data.MyUserRepository;
import ch.samt.libraryManager.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MYUserService {

    private MyUserRepository myUserRepository;

    @Autowired
    public MYUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    public List<MyUser> findAll() {
        return myUserRepository.findAll();
    }


}

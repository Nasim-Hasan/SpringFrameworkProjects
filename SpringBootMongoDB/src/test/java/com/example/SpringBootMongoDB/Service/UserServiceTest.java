package com.example.SpringBootMongoDB.Service;

import com.example.SpringBootMongoDB.Model.User;
import com.example.SpringBootMongoDB.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private  UserService userService;

    @Test
    public void getAllUsers(){
        User user1 = new User("ABC177","Tarikul islam",30);
        User user2 = new User("ABC171","Arup Das",32);

        when(userRepository.findAll()).thenReturn(asList(user1,user2));

        List<User> userList = userService.getAllUsers();

        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
    }
}

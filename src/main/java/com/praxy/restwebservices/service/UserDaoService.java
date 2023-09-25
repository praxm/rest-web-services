package com.praxy.restwebservices.service;

import com.praxy.restwebservices.exception.CustomException;
import com.praxy.restwebservices.model.Post;
import com.praxy.restwebservices.model.User;
import com.praxy.restwebservices.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class UserDaoService {
    private UserRepository userRepository;

    public List<User> getAllusers() {
        return userRepository.findAll();
    }

    public User getUserById(final Integer id) {
        return userRepository.findById(id).get();
    }

    public List<User> deleteUserById(final Integer id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

    public List<User> createUser(final User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    public List<Post> getPostsForUser(final Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new CustomException("User not found for id " + id);
        }
        return user.get().getPosts();
    }
}

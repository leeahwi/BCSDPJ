package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.user.User;
import org.example.dto.user.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMapper {

    User getUserById(Integer id);

    void create(User user);

    void delete(User user);

    void update(User user);

    List<User> findAllDesc();

    // void createUser(UserVo user);
    // void setUserAuthority(UserVo user);
    // int idCheck(String id);
    void join(UserDTO userVo);
    // void addRole(UserDTO userVo);
    // Optional<UserVo> findUserById(String userId);
    Optional<UserDTO> findUser(String userId);
    Optional<UserDTO> findUserId(String userId);
    // int findPkById(String id);sss
}

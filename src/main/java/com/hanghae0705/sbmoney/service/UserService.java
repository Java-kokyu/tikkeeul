package com.hanghae0705.sbmoney.service;

import com.hanghae0705.sbmoney.exception.ApiException;
import com.hanghae0705.sbmoney.exception.ApiRequestException;
import com.hanghae0705.sbmoney.model.domain.User;
import com.hanghae0705.sbmoney.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void checkUser(Long userId){
        Optional<User> found = userRepository.findById(userId);

        if (found.isPresent()) {
            throw new ApiRequestException(ApiException.REGEXP_PASSWORD);
        }
    }
}

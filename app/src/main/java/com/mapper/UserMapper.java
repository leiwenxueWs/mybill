package com.mapper;

import com.dto.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserByNumber(@Param("number") long number);
}

package com.example.user;

import com.example.user.User;
import org.springframework.data.repository.CrudRepository;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
public interface UserRepository extends CrudRepository<User, Integer>
{
}

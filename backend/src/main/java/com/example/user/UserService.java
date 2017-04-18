package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.sql.Timestamp;
import java.util.Date;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@Service
public class UserService
{
   @Autowired
   UserRepository repository;

   public Iterable<User> getAllUsers()
   {
      return repository.findAll();
   }

   public User addUser(User user)
   {
      try
      {
         user.setRegistrationDate(new Timestamp(new Date().getTime()));
         return repository.save(user);
      }
      catch(UnexpectedRollbackException e)
      {
         return null;
      }
   }

   public User getUser(int id)
   {
      return repository.findOne(id);
   }

   public User updateUser(User user)
   {
      //Make sure user already exists
      User dbUser = repository.findOne(user.getId());

      if(dbUser == null)
         return null;

      return repository.save(user);
   }

   public boolean deleteUser(int id)
   {
      User dbUser = repository.findOne(id);
      if(dbUser == null)
         return false;

      repository.delete(id);

      dbUser = repository.findOne(id);

      return dbUser == null;
   }
}

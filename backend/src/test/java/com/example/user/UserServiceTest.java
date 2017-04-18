package com.example.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.transaction.UnexpectedRollbackException;

import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest
{
   @Mock
   UserRepository mockRepository;
   @Mock
   User mockUser;
   UserService service;

   @Before
   public void setUp()
   {
      service = new UserService();
      service.repository = mockRepository;
   }

   @Test
   public void shouldBeAbleToReturnAllUsers()
   {
      service.getAllUsers();
      verify(mockRepository, times(1)).findAll();
   }

   @Test
   public void shouldBeAbleToAddANewUser()
   {
      when(mockRepository.save(mockUser)).thenReturn(mockUser);

      User returnedUser = service.addUser(mockUser);

      verify(mockRepository, times(1)).save(mockUser);
      verify(mockUser, times(1)).setRegistrationDate(any(Timestamp.class));

      assertNotNull(returnedUser);
   }

   @Test
   public void shouldReturnNullOnRollbackExceptionWhenAddingANewUser()
   {
      //noinspection unchecked
      when(mockRepository.save(mockUser)).thenThrow(UnexpectedRollbackException.class);

      User returnedUser = service.addUser(mockUser);
      verify(mockUser, times(1)).setRegistrationDate(any(Timestamp.class));

      assertNull(returnedUser);
   }

   @Test
   public void shouldBeAbleToGetAnExistingUser()
   {
      when(mockRepository.findOne(1)).thenReturn(mockUser);

      User returnedUser = service.getUser(1);

      verify(mockRepository, times(1)).findOne(1);

      assertNotNull(returnedUser);
   }

   @Test
   public void shouldBeAbleToUpdateAnExitingUser()
   {
      when(mockUser.getId()).thenReturn(1);
      when(mockRepository.findOne(1)).thenReturn(mockUser);
      when(mockRepository.save(mockUser)).thenReturn(mockUser);

      User returnedUser = service.updateUser(mockUser);

      verify(mockUser, times(1)).getId();
      verify(mockRepository, times(1)).findOne(1);
      verify(mockRepository, times(1)).save(mockUser);

      assertNotNull(returnedUser);
   }

   @Test
   public void shouldReturnNullIfUserToUpdateDoesNotExist()
   {
      when(mockUser.getId()).thenReturn(0);
      when(mockRepository.findOne(0)).thenReturn(null);

      User returnedUser = service.updateUser(mockUser);

      verify(mockUser, times(1)).getId();
      verify(mockRepository, times(1)).findOne(0);

      assertNull(returnedUser);
   }

   @Test
   public void shouldBeAbleToDeleteAnExitingUser()
   {
      when(mockRepository.findOne(1)).thenReturn(mockUser).thenReturn(null);

      boolean returnVal = service.deleteUser(1);

      verify(mockRepository, times(2)).findOne(1);
      verify(mockRepository, times(1)).delete(1);

      assertTrue(returnVal);
   }

   @Test
   public void shouldReturnNullIfUserToDeleteDoesNotExist()
   {
      when(mockRepository.findOne(0)).thenReturn(null);

      boolean returnVal = service.deleteUser(0);

      verify(mockRepository, times(1)).findOne(0);

      assertFalse(returnVal);
   }
}

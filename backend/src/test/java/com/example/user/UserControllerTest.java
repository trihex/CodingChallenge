package com.example.user;

import com.example.ServiceResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest
{
   @Mock
   UserService mockService;
   @Mock
   HttpServletResponse mockResponse;

   UserController controller;

   @Before
   public void setUp()
   {
      controller = new UserController();
      controller.service = mockService;
   }

   @Test
   public void shouldBeAbleToGetAListOfUsers()
   {
      Iterable<User> itr = new ArrayList<>();
      when(mockService.getAllUsers()).thenReturn(itr);

      ServiceResponse<Iterable<User>> response = controller.getAllUsers();

      verify(mockService, times(1)).getAllUsers();

      assertNotNull(response);
      assertTrue(response.isSuccess());
   }

   @Test
   public void shouldReturnAppropriateErrorMessageIfUnableToFindUsers()
   {
      when(mockService.getAllUsers()).thenReturn(null);

      ServiceResponse<Iterable<User>> response = controller.getAllUsers();

      verify(mockService, times(1)).getAllUsers();

      assertNotNull(response);
      assertFalse(response.isSuccess());
      assertEquals("Error getting users", response.getResponse());
   }

   @Test
   public void shouldBeAbleToGetASpecificUser()
   {
      User user = new User();
      user.setId(1);
      user.setUsername("test");
      user.setEmail("test@test");
      when(mockService.getUser(1)).thenReturn(user);

      ServiceResponse<User> response = controller.getUser(1);
      verify(mockService, times(1)).getUser(1);

      assertNotNull(response);
      assertTrue(response.isSuccess());
      assertEquals(user, response.getResponseObject());
   }

   @Test
   public void shouldReturnAppropriateErrorMessageOnUserNotFound()
   {
      when(mockService.getUser(1)).thenReturn(null);

      ServiceResponse<User> response = controller.getUser(1);
      verify(mockService, times(1)).getUser(1);

      assertNotNull(response);
      assertFalse(response.isSuccess());
      assertEquals("User not found", response.getResponse());
   }

   @Test
   public void shouldBeAbleToAddANewUser()
   {
      User user = new User();
      user.setId(1);
      user.setUsername("test");
      user.setEmail("test@test");
      when(mockService.addUser(user)).thenReturn(user);

      ServiceResponse<User> response = controller.createUser(user, mockResponse);
      verify(mockService, times(1)).addUser(user);

      assertNotNull(response);
      assertTrue(response.isSuccess());
      assertEquals(user, response.getResponseObject());
   }

   @Test
   public void shouldReturnAppropriateErrorMessageOnUnableToAddNewUser()
   {
      User user = new User();
      user.setId(1);
      user.setUsername("test");
      user.setEmail("test@test");

      when(mockService.addUser(user)).thenReturn(null);

      ServiceResponse<User> response = controller.createUser(user, mockResponse);
      verify(mockService, times(1)).addUser(user);

      assertNotNull(response);
      assertFalse(response.isSuccess());
      assertEquals("Error creating user", response.getResponse());
   }

   @Test
   public void shouldBeAbleToUpdateAUser()
   {
      User user = new User();
      user.setId(1);
      user.setUsername("newtest");
      user.setEmail("test@test");

      when(mockService.updateUser(user)).thenReturn(user);

      ServiceResponse<User> response = controller.updateUser(1, user, mockResponse);
      verify(mockService, times(1)).updateUser(user);

      assertNotNull(response);
      assertTrue(response.isSuccess());
      assertEquals(user, response.getResponseObject());
   }

   @Test
   public void shouldReturnAppropriateErrorMessageOnUnableToUpdateAUser()
   {
      User user = new User();
      user.setId(1);
      user.setUsername("newtest");
      user.setEmail("test@test");

      when(mockService.updateUser(user)).thenReturn(null);

      ServiceResponse<User> response = controller.updateUser(1, user, mockResponse);
      verify(mockService, times(1)).updateUser(user);

      assertNotNull(response);
      assertFalse(response.isSuccess());
      assertEquals("Error updating user", response.getResponse());
   }

   @Test
   public void shouldReturnAppropriateErrorMessageWhenUserIdDoesNotMatch()
   {
      User user = new User();
      user.setId(1);
      user.setUsername("newtest");
      user.setEmail("test@test");

      ServiceResponse<User> response = controller.updateUser(2, user, mockResponse);
      verify(mockResponse, times(1)).setStatus(HttpStatus.BAD_REQUEST.value());

      assertNotNull(response);
      assertFalse(response.isSuccess());
      assertEquals("Id and user object mismatch", response.getResponse());
   }

   @Test
   public void shouldBeAbleToDeleteAUser()
   {
      when(mockService.deleteUser(1)).thenReturn(true);

      ServiceResponse<User> response = controller.deleteUser(1, mockResponse);
      verify(mockService, times(1)).deleteUser(1);

      assertNotNull(response);
      assertTrue(response.isSuccess());
   }

   @Test
   public void shouldReturnAppropriateErrorMessageOnUnableToDeleteAUser()
   {
      when(mockService.deleteUser(1)).thenReturn(false);

      ServiceResponse<User> response = controller.deleteUser(1, mockResponse);
      verify(mockService, times(1)).deleteUser(1);

      assertNotNull(response);
      assertFalse(response.isSuccess());
      assertEquals("Error deleting user", response.getResponse());
   }
}

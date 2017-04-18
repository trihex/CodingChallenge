package com.example.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@Entity
@Table(name="user")
public class User
{
   @Id
   @GeneratedValue
   private int id;
   private String username;
   private String email;
   private Timestamp registrationDate;

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public Timestamp getRegistrationDate()
   {
      return registrationDate;
   }

   public void setRegistrationDate(Timestamp registrationDate)
   {
      this.registrationDate = registrationDate;
   }
}

package com.example;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
public class ServiceResponse<T>
{
   private boolean success;
   private String response;
   private T responseObject;

   public boolean isSuccess()
   {
      return success;
   }

   public void setSuccess(boolean success)
   {
      this.success = success;
   }

   public String getResponse()
   {
      return response;
   }

   public void setResponse(String response)
   {
      this.response = response;
   }

   public T getResponseObject()
   {
      return responseObject;
   }

   public void setResponseObject(T responseObject)
   {
      this.responseObject = responseObject;
   }
}

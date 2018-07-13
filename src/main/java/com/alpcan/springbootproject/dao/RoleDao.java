    package com.alpcan.springbootproject.dao;

   import com.alpcan.springbootproject.model.Role;
   import org.springframework.beans.factory.annotation.Qualifier;
   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;

   @Repository
   @Qualifier("roleDao")
      public interface RoleDao extends JpaRepository <Role,Long>{
         Role findByRole(String role);

    }

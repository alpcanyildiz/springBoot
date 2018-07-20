    package com.alpcan.springbootproject.repository;

   import com.alpcan.springbootproject.entity.RoleEntity;
   import com.alpcan.springbootproject.model.Role;
   import org.springframework.beans.factory.annotation.Qualifier;
   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;

   @Repository
   @Qualifier("roleDao")
      public interface RoleRepository extends JpaRepository <RoleEntity,Long>{
      //Role findByRole(String role);
      RoleEntity findByRole(String role);

    }

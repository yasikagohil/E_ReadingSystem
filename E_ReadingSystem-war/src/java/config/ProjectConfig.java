/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author Akshay
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/epool",
        callerQuery = "select password from user where username = ?",
        groupsQuery = "select roleName from user_group where username = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)

@Named
@ApplicationScoped
public class ProjectConfig {
    
}

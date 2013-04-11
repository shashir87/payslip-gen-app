package org.nthdimenzion.ddd.domain.service;

import com.google.common.base.Preconditions;
import org.nthdimenzion.crud.ICrud;
import org.nthdimenzion.ddd.domain.PersonRole;
import org.nthdimenzion.security.application.services.UserService;
import org.nthdimenzion.security.domain.IUserLoginRepository;
import org.nthdimenzion.security.domain.SystemUser;
import org.nthdimenzion.security.domain.UserLogin;
import org.nthdimenzion.security.infrastructure.repositories.hibernate.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 10/4/13
 * Time: 11:19 PM
 */
@Service
public class RoleService {

    @Autowired
    private ICrud crudDao;

    @Autowired
    private SystemUser systemUser;

    @Autowired
    private IUserLoginRepository userLoginRepository;

    /***
     * Preconditions loggedInUser must have a valid @DomainRole
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getRolePlayedByLoggedInUser(Class<T> clazz){
        UserLogin userLogin = userLoginRepository.findUserLoginWithUserName(systemUser.getUsername());
        PersonRole personRole = userLogin.getPersonRole();
        Preconditions.checkNotNull(personRole);
        return crudDao.find(clazz,personRole.getId());
    }

}

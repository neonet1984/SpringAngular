package com.services.servicesImpl;

import com.repository.entity.Role;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Role> getUserRole(Long id) {
        List roleList = new ArrayList<Role>();
        try {
            List<Object[]> resultRoleList = entityManager.createNativeQuery(
                    "select b.id,b.role from role b left join user_role c" +
                            " on c.id_role = b.id and c.id_user =:id ").setParameter("id", id).getResultList();

            resultRoleList.stream().forEach((record) -> {
                Long roleId = ((BigInteger) record[0]).longValue();
                String roleName = (String) record[1];
                roleList.add(new Role(roleId, roleName));
            });
            return roleList;

        } catch (Exception e) {
            return null;
        }

    }
}

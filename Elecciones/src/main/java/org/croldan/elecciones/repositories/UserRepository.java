package org.croldan.elecciones.repositories;

import org.croldan.elecciones.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	public User getByLoginname(String loginname);
}

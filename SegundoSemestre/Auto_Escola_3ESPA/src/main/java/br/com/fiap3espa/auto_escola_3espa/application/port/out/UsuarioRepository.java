package br.com.fiap3espa.auto_escola_3espa.application.port.out;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
package dz9.rest.security;

import dz9.rest.model.User;
import dz9.rest.repository.UserRepository;
import dz9.rest.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyCustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<SimpleGrantedAuthority> userRoles = userRoleRepository.findByUserId(user.getUserId()).stream()
                .map(it -> new SimpleGrantedAuthority(it.getRoleName())).toList();
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                userRoles
        );
    }
}
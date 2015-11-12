package by.bsu.fpmi.pasevina.listenit.services.impl;


import by.bsu.fpmi.pasevina.listenit.models.UserRole;
import by.bsu.fpmi.pasevina.listenit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        by.bsu.fpmi.pasevina.listenit.models.User user = userService.getUserById(s);
        if(user == null) {
            throw new UsernameNotFoundException("Finding username " + s + " failed");
        }
        Set<GrantedAuthority> authorities = buildUserAuthority(userService.getUserRolesById(s));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private Set<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();

        for(UserRole userRole : userRoles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return grantedAuthoritySet;
    }
}

package gyber.org.mainCore.configs.security.auth;

import gyber.org.mainCore.configs.security.JwtService;
import gyber.org.mainCore.data.entities.User;
import gyber.org.mainCore.data.entities.enums.Role;
import gyber.org.mainCore.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .nickName(request.getNickname())
                .passwd(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        if (repository.findByEmail(request.getEmail()).isEmpty()
                &&
                repository.findByNickName(request.getNickname()).isEmpty()) {
            var savedUser = repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        } else {
            var userrr = repository.findByNickNameOrEmail(request.getEmail(), request.getNickname()).orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким email или nickname уже существует"));
            return null;
        }
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmailOrNickName(),
                        request.getPassword()
                )
        );
        var user = repository.findByNickNameOrEmail(request.getEmailOrNickName(), request.getEmailOrNickName())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }




}

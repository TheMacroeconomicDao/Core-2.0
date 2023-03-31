package gyber.org.mainCore.configs.security.auth;

import gyber.org.mainCore.configs.security.JwtService;
import gyber.org.mainCore.data.entities.User;
import gyber.org.mainCore.data.entities.enums.Role;
import gyber.org.mainCore.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
            return AuthenticationResponse.builder().build();
        }
    }


    public AuthenticationResponse authenticateEmail(AuthenticationRequestEmail request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }



}

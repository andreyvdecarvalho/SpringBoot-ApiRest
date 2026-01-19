package med.oak.api.controller;

import jakarta.validation.Valid;
import med.oak.api.domain.usuario.DadosAutenticacao;
import med.oak.api.domain.usuario.Usuario;
import med.oak.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticartionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity executarLogin(@RequestBody @Valid DadosAutenticacao DadosAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(DadosAutenticacao.login(), DadosAutenticacao.senha());
        var authenticate = authenticationManager.authenticate(token);

        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authenticate.getPrincipal()));
    }
}
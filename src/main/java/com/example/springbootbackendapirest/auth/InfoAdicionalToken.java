package com.example.springbootbackendapirest.auth;

import com.example.springbootbackendapirest.models.entity.Usuario;
import com.example.springbootbackendapirest.models.services.IUsuarioService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

  private final IUsuarioService usuarioService;

  public InfoAdicionalToken(IUsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

    Usuario usuario = usuarioService.findByUsername(oAuth2Authentication.getName());

    Map<String, Object> info = new HashMap<>();
    info.put("info_adicional", "Hola que tal ".concat(oAuth2Authentication.getName()));
    info.put("nombre_usuario", usuario.getId() + ": " + usuario.getUsername());

    ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

    return oAuth2AccessToken;
  }
}

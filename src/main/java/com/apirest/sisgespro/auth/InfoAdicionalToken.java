package com.apirest.sisgespro.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.apirest.sisgespro.entity.Usuario;
import com.apirest.sisgespro.services.IUsuarioService;



@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.buscarUsuario(authentication.getName());
	
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal! ".concat(authentication.getName()));
		info.put("nCodUsuario", usuario.getCodUsuario());
		info.put("vNomUsuario", usuario.getNombreUsuario());
		info.put("vUsuario",  usuario.getUsuario());
		info.put("vTipoUsuario",  usuario.getEstadoUsuario());
		info.put("vRolUsuario", usuario.getRol().getDesRol());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}

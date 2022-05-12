package br.com.api_activecampaign4.core.port.out;

import java.util.List;

import org.json.JSONObject;

import br.com.api_activecampaign4.core.domain.Users;

public interface UsersTools {

	public Object incluirUsuario(Users entidade);
	
	public Object incluirListaUsuarios(List<Object> lista);
	
	public List<?> mapearJson(JSONObject obj);
	
}

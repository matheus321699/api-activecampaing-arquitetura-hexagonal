package br.com.api_activecampaign4.core.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.api_activecampaign4.core.adapter.DAO;
import br.com.api_activecampaign4.core.port.out.UsersTools;

public class UsersService implements UsersTools {
	
	
	@Override
	public Object incluirUsuario(Users entidade) {
	
	    DAO<Users> dao = new DAO<>(Users.class);
	    return	dao.incluirAtomico(entidade);
		
	}
	
	@Override
	public Object incluirListaUsuarios(List<Object> lista) {
	    DAO<Users> dao = new DAO<>(Users.class);
	    dao.incluirTodosAtomico(lista);
		return dao.incluirTodosAtomico(lista);
	}
		

	@Override
	public List<?> mapearJson(JSONObject obj) {
		
		List<Object> listaUsuarios = new ArrayList<Object>();
		
		try{
    	
//	        obj=new JSONObject(response.toString());
//	        System.out.println(obj.toString());
	        JSONArray jArray = obj.getJSONArray("users");
	        for(int i = 0; i < jArray.length(); i++){
	        	JSONObject o = jArray.getJSONObject(i);
	        	
	        	Integer id = o.getInt("id");
	        	String username = o.getString("username");
	        	String firstName = o.getString("firstName");
	        	String lastName = o.getString("lastName");
	        	String email = o.getString("email");
	        	String phone = o.getString("phone");
	        	String signature = o.getString("signature");
	        	String lang = o.getString("lang");
	        	String localZoneid = o.getString("localZoneid");

	            
	        	listaUsuarios.add(new Users(id, username, firstName, lastName, email, phone, signature, lang, localZoneid));
	        	
//	            Users usuarios = new Users();
//	            usuarios.setUsername(nome);
	
//	            System.out.println(usuarios);
	            
//	            System.out.println(o.toString());
	        	
	        }
        	return listaUsuarios;

	        
    	}catch(JSONException e){
    		e.printStackTrace();
    	}
		
		return null;
	}

	
}

package br.com.api_activecampaign4;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import br.com.api_activecampaign4.core.adapter.ActiveCampaignConnection;
import br.com.api_activecampaign4.core.domain.Users;
import br.com.api_activecampaign4.core.domain.UsersService;



public class App {
	 public static void main( String[] args ) throws Exception
	    {
	    	
	        System.out.println( "Hello World!" );
	        
//			ActiveCampaignConnection.getStart("https://codetec.api-us1.com/api/3/users");
			Map<String, String> queryParams = new HashMap<String, String>();
			
			int size = 10;
			
//			int start = ActiveCampaignConnection.getStart(page, size);
		    queryParams.put("start", String.valueOf(10));
			queryParams.put("limit", String.valueOf(size));
		
			// Conexão e envio de requisição com verbo Get, recebendo os dados do Json
		    String response =  ActiveCampaignConnection.get("", queryParams);
	   	    System.out.println();
	   	    System.out.println(response);
		    System.out.println("----------------------");

		    System.out.println();

		    /*
		     *  Mapeando Json Object para uma lista Lista, setando os objetos e salvando
		     *  na lista
		     */
		    JSONObject obj = null;        	
	        obj= new JSONObject(response.toString()); 
	        
	        UsersService services = new UsersService();
	        
	        List<Object> listaUsuarios = (List<Object>) services.mapearJson(obj);
	        
	        // Percorrendo a lista
	        for(Object usuario : listaUsuarios) {
	        	
	            System.out.println(((Users) usuario)); 
	            System.out.println();
	        }
	        
	        services.incluirListaUsuarios(listaUsuarios);
	        
//	        Users usuario1 = new Users(1, "matheus321", "henrique", "Marciano", "matheus@gmail.com", "32345", 
//	        							"3421", "português-br", "Uberlândia");
//	        services.incluirUsuario(usuario1);

  }
}

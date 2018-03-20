$(document).ready(function(){
	
	// datagrid -----------------------------------------------------------------------------------
	
	if($("#datagrid").length){
		
		$("#datagrid").bs_grid({
			
			ajaxFetchDataURL: "/website-framework/systemManagement/userManagement/datagrid",
			
			row_primary_key: "id",
			
			columns: [
				{field: "id", header: "Code", width:"5%"},
				{field: "username", header: "Username", width:"30%"},
				{field: "email", header: "Email", width:"30%"},
				{field: "password", header: "Password"}
			],
			
			// editor settings
			editor: true,
			serverside_entity_name: "user",
			new_url: "/website-framework/systemManagement/userManagement/save",
			view_url: "/website-framework/systemManagement/userManagement/load",
			edit_url: "/website-framework/systemManagement/userManagement/update",
			delete_url: "/website-framework/systemManagement/userManagement/delete"
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
});
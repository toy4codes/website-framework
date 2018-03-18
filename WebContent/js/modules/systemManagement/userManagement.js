$(document).ready(function(){
	
	// datagrid -----------------------------------------------------------------------------------
	
	if($("#datagrid").length){
		
		$("#datagrid").bs_grid({
			
			ajaxFetchDataURL: "/website-framework/systemManagement/userManagement/datagrid",
			
			row_primary_key: "id",
			
			rowSelectionMode: "single", // "multiple", "single", false
			
			columns: [
				{field: "id", header: "Code", width:"5%", visible: "no"},
				{field: "username", header: "Username", width:"30%"},
				{field: "email", header: "Email", width:"30%"},
				{field: "password", header: "Password"}
			],
			
			editor: true,
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
});
$(document).ready(function(){
	
	// datagrid -----------------------------------------------------------------------------------
	
	if($("#datagrid").length){
		
		$("#datagrid").bs_grid({
			
			ajaxFetchDataURL: "/website-framework/pm2.5/datagrid",
			
			row_primary_key: "id",
			
			rowSelectionMode: "multiple", // "multiple", "single", false
			
			columns: [
				{field: "id", header: "Code", width:"5%"},
				{field: "time", header: "Time", width:"10%"},
				{field: "source", header: "Source", width:"15%"},
				{field: "destination", header: "Destination", width:"15%"},
				{field: "protocol", header: "Protocol", width:"10%"},
				{field: "length", header: "length", width:"5%", "sortable": "no"},
				{field: "info", header: "Info", "sortable": "no"}
			]
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
});
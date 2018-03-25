$(document).ready(function(){
	
	// datagrid -----------------------------------------------------------------------------------
	
	if($("#datagrid").length){
		
		$("#datagrid").bs_grid({
			
			ajaxFetchDataURL: "/website-framework/pm25/datagrid",
			
			row_primary_key: "id",
			
			rowSelectionMode: "false", // "multiple", "single", false
			
			columns: [
				{field: "id", header: "Code", sortable: "yes", width: "5%"},
				{field: "year", header: "Year", sortable: "no"},
				{field: "month", header: "Month", sortable: "no"},
				{field: "day", header: "Day", sortable: "no"},
				{field: "hour", header: "Hour", "sortable": "no"},
				{field: "pm25", header: "PM25", "sortable": "no"},
				{field: "dewPoint", header: "Dew Point", "sortable": "no"},
				{field: "temperature", header: "Temperatur", "sortable": "no"},
				{field: "pressure", header: "Pressure", "sortable": "no"},
				{field: "combinedWindDirection", header: "Combined Wind Direction", "sortable": "no"},
				{field: "cumulatedWindSpeed", header: "Cumulated Wind Speed", "sortable": "no"},
				{field: "cumnlatedHoursOfSnow", header: "Cumulated Hours Of Snow", "sortable": "no"},
				{field: "cumulatedHoursOfRain", header: "Cumulated Hours Of Rain", "sortable": "no"}
			],
			
			sorting: [
			    {sortingName: "Code", field: "id", order: "ascending"},      
			],
			
			useFilters: false
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
});
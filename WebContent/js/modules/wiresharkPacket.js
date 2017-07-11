$(document).ready(function(){
	
	// datagrid -----------------------------------------------------------------------------------
	
	if($("#datagrid").length){
		
		$("#datagrid").bs_grid({
			
			ajaxFetchDataURL: "/website-framework/wiresharkPacket/datagrid",
			
			row_primary_key: "id",
			
			rowSelectionMode: "multiple", // "multiple", "single", false
			
			columns: [
				{field: "id", header: "Code", visible: "no"},
				{field: "time", header: "Time"},
				{field: "source", header: "Source"},
				{field: "destination", header: "Destination"},
				{field: "protocol", header: "Protocol"},
				{field: "length", header: "length", "sortable": "no"},
				{field: "info", header: "Info", "sortable": "no"}
			],
			
			sorting: [
				{sortingName: "Code", field: "id", order: "ascending"},
				{sortingName: "Time", field: "time", order: "ascending"},
				{sortingName: "Source", field: "source", order: "none"},
				{sortingName: "Destination", field: "destination", order: "none"},
				{sortingName: "Protocol", field: "protocol", order: "none"},
			],
			
			filterOptions: {
				filters: [
					{
						filterName: "Protocol", 
						filterType: "text", 
						field: "protocol", 
						filterLabel: "Protocol",
						excluded_operators: ["in", "not_in", "less", "less_or_equal", "greater", "greater_or_equal"],
						filter_interface: [
							{
								filter_element: "select"
							}
						],
						lookup_values_ajax_url: "../../wiresharkPacket/protocols"
						// when use ajax_url, must return a json array object like [{},{}]
					}
				]
			}
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
	// chart --------------------------------------------------------------------------------------

	if($("#wireshark-packet-protocol-pie-chart").length){
		
		var data = [{
	        label: "Series 0",
	        data: 1
	    }, {
	        label: "Series 1",
	        data: 3
	    }, {
	        label: "Series 2",
	        data: 9
	    }, {
	        label: "Series 3",
	        data: 20
	    }];
		
		// ajax
		
		var options = {
			series: {
				pie: {
			        show: true
			    }
			},
			grid: {
			    hoverable: true
			},
			tooltip: true,
			tooltipOpts: {
			    content: "%p.0%, %s", // show percentages
			    shifts: {
			        x: 20,
			        y: 0
			    },
			    defaultTheme: false
			}
		};
		
		$.plot($("#wireshark-packet-protocol-pie-chart"), data, options);
	}
	
	// chart --------------------------------------------------------------------------------------
	
});
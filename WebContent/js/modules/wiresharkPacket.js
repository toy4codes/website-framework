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
		
		var data = [];
		
		// ajax
		$.ajax({
			url : "/website-framework/wiresharkPacket/protocolsAndCounts",
			type : "POST",
			// the type of data we expect back
			dataType : "json",
			async : false
		})
		// code to run if the request succeeds (is done);
		.done(function(protocolsAndCounts){
			for(var i = 0; i < protocolsAndCounts.length; i++){
				var protocol = protocolsAndCounts[i][0];
				var count = protocolsAndCounts[i][1];
				var protocolAndCount = {"label" : protocol, "data" : count};
				data.push(protocolAndCount);
			}
		});
		
		var formatter = function (label, series) {
			return label + ' ' + toy4codes.round(series.percent, 3);
		};
		
		var options = {
			series: {
				pie: {
			        show: true
			    }
			},
			legend: {
				show: true,
				labelFormatter: formatter,
			},
			grid: {
			    hoverable: true
			},
			tooltip: true,
			tooltipOpts: {
			    content: "%p.3%, %s", // show percentages
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
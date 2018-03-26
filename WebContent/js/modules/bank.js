$(document).ready(function(){
	
	// datagrid -----------------------------------------------------------------------------------
	
	if($("#datagrid").length){
		
		$("#datagrid").bs_grid({
			
			ajaxFetchDataURL: "/website-framework/bank/datagrid",
			
			row_primary_key: "id",
			
			rowSelectionMode: "false", // "multiple", "single", false
			
			columns: [
				{field: "id", header: "Code", sortable: "yes"},
				{field: "age", header: "Age", sortable: "no"},
				{field: "job", header: "Job", sortable: "no"},
				{field: "marital", header: "Marital", sortable: "no"},
				{field: "education", header: "Education", "sortable": "no"},
				{field: "hasCredit", header: "Has Credit", "sortable": "no"},
				{field: "housingLoan", header: "Housing Loan", "sortable": "no"},
				{field: "personalLoan", header: "Personal Loan", "sortable": "no"},
				{field: "contact", header: "Contact", "sortable": "no"},
				{field: "lastContactMonth", header: "Last Contact Month", "sortable": "no"},
				{field: "lastContactDay", header: "Last Contact Day", "sortable": "no"},
				{field: "lastContactDuration", header: "Last Contact Duration", "sortable": "no"},
				{field: "campaign", header: "Campaign", "sortable": "no"},
				{field: "pdays", header: "Pdays", "sortable": "no"},
				{field: "previous", header: "Previous", "sortable": "no"},
				{field: "poutcome", header: "Poutcome", "sortable": "no"},
				{field: "employmentVariationRate", header: "Employment Variation Rate", "sortable": "no"},
				{field: "consumerPrice", header: "Consumer Price", "sortable": "no"},
				{field: "consumerConfidence", header: "Consumer Confidence", "sortable": "no"},
				{field: "euribor3m", header: "Euribor3m", "sortable": "no"},
				{field: "numberOfEmployees", header: "Number Of Employees", "sortable": "no"},
				{field: "termDeposit", header: "Term Deposit", "sortable": "no"}
			],
			
			sorting: [
			    {sortingName: "Code", field: "id", order: "ascending"},      
			],
			
			useFilters: false,
			showSortingIndicator: true
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
});
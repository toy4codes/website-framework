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
			
			editor: true,
			
			onNewClick: function(event, data) {
				
				// toggle modal
				$("#userModal").modal("toggle");
				
				// modal header title
				$("#userModal #userModalLabel").text("Create User");
				
				// clean readonly
				$("#userModal #inputUsername").removeAttr("readonly");
				$("#userModal #inputEmail").removeAttr("readonly");
				$("#userModal #inputPassword").removeAttr("readonly");
				
				// clean user attribute
				
				$("#userModal #inputUsername").val("");
				$("#userModal #inputEmail").val("");
				$("#userModal #inputPassword").val("");
				
				// set placeholder
				$("#userModal #inputUsername").attr("placeholder", "Username");
				$("#userModal #inputEmail").attr("placeholder", "Email");
				$("#userModal #inputPassword").attr("placeholder", "Password");
				
				$(".form-horizontal").attr("action", "/website-framework/systemManagement/userManagement/save")
					.attr("method", "post");
			},
			
			onViewClick: function(event, data) {
				if(!$(".btn-view").hasClass("disabled")) {
					
					// selected data id
					var row_id = $("#datagrid").bs_grid('selectedRows', 'get_ids').shift();
					
					// user data
					var username, email, password;
					
					$.ajax({
						type: "POST",
						url: "/website-framework/systemManagement/userManagement/load",
						data: {
							"user.id": String(row_id)
						},
						dataType : "json",
						success: function(data) {
							// set user attributes
							$("#userModal #inputUsername").val(data.username);
							$("#userModal #inputEmail").val(data.email);
							$("#userModal #inputPassword").val(data.password);
						}
					});
					
					// toggle modal
					$("#userModal").modal("toggle");
					
					// modal header title
					$("#userModal #userModalLabel").text("View User");
					
					// set readonly
					$("#userModal #inputUsername").attr("readonly", "");
					$("#userModal #inputEmail").attr("readonly", "");
					$("#userModal #inputPassword").attr("readonly", "");
					
					// hidden submit & cancle button
					$("#userModal .btn-toolbar").attr("hidden", "");
				}
			},
			
			onEditClick: function(event, data) {
				if(!$(".btn-edit").hasClass("disabled")) {
					
					// selected data id
					var row_id = $("#datagrid").bs_grid('selectedRows', 'get_ids').shift();
					
					// user data
					var username, email, password;
					
					$.ajax({
						type: "POST",
						url: "/website-framework/systemManagement/userManagement/load",
						data: {
							"user.id": String(row_id)
						},
						dataType : "json",
						success: function(data) {
							// set user attributes
							$("#userModal #inputUsername").val(data.username);
							$("#userModal #inputEmail").val(data.email);
							$("#userModal #inputPassword").val(data.password);
						}
					});
					
					// toggle modal
					$("#userModal").modal("toggle");
					
					// modal header title
					$("#userModal #userModalLabel").text("Edit User");
					
					// clean readonly
					$("#userModal #inputUsername").removeAttr("readonly");
					$("#userModal #inputEmail").removeAttr("readonly");
					$("#userModal #inputPassword").removeAttr("readonly");
					
					// show submit & cancle button
					$("#userModal .btn-toolbar").removeAttr("hidden");
					
					$("#userModal #inputId").val(String(row_id));
					$(".form-horizontal").attr("action", "/website-framework/systemManagement/userManagement/update");
				}
			},
			
			onDeleteClick: function(event, data) {
				if(!$(".btn-delete").hasClass("disabled")) {
					// selected data id
					var row_id = $("#datagrid").bs_grid('selectedRows', 'get_ids').shift();
					
					$.ajax({
						type: "POST",
						url: "/website-framework/systemManagement/userManagement/delete",
						data: {
							"user.id": String(row_id)
						},
						success: function(msg) {
							$("#datagrid").bs_grid('displayGrid', true);
							$(".btn-view").addClass("disabled");
        					$(".btn-edit").addClass("disabled");
        					$(".btn-delete").addClass("disabled");
						}
					});
					
				}
			}
			
		});
		
	}
	
	// datagrid -----------------------------------------------------------------------------------
	
});
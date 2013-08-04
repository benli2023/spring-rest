	function notify(msg,type) {
				var n = noty({text: msg,type:type,timeout:3000,layout: 'bottomRight'});
			}
		
		new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
			var finalResult = result;
			var ajaxmethod=getPostMethod();
			var postURL=getJsonUrl();
			if(window.validationCallback) {
				finalResult=window.validationCallback(form,finalResult);
			}
			if(ajaxmethod=='ajax'&&finalResult) {
				var data = $(form).serialize();
				$.ajax({
					  url: postURL,
					  type: "POST",
					  data: data,
					  success: function(resp){
					        if(resp.statusCode=='000') {
					        	notify("success!",'success');
					        	if(window.opener) {
					        		if(window.opener.newItemCallback) {
					        			window.opener.newItemCallback();
					        		}
					        	}
								if(window.confirm('success! do u want to close window ?')) {
										window.close();
								}
					        }else if(resp.statusCode=='E001') {
					        	if(resp.validationError) {
					        		if(resp.validationError.globalError) {
					        			notify("Object: "+resp.validationError.globalError.objectName+" Error:"+resp.validationError.globalError.errorMessage);
					        		}
					        		if(resp.validationError.fieldErrors) {
					        		    var fieldErrors=resp.validationError.fieldErrors;
					        			for(var i=0;i<fieldErrors.length;i++) {
					        				 var fieldError=fieldErrors[i];
					        				 notify("Field Name: "+fieldError.fieldName+" Error:"+fieldError.errorMessages,'error');
					        			}
					        		}
					        	}
					        }else if(resp.statusCode=='E000') {
					        	 notify(resp.genericError,'error');
					        }
					    }
				});
				finalResult=false;
			
			}else {
				//alert(ajaxmethod);
			
			}
			
			//在这里添加自定义验证
			
			return disableSubmit(finalResult,'submitButton');
		},focusOnError:true,immediate:true});
		
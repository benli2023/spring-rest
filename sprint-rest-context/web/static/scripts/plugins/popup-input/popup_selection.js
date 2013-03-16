var PopupSelection=(function($) {
	 		var localPopupOption;
	 		
	 		function initOption(popupOption) {
	 		   localPopupOption=popupOption||{};
	 		
	 		}
	 		
		     function fillBackAndCloseDialog(rowData,fieldId){
		        $( "#dialog-modal").omDialog('close');
		        window.frames[0].location.href="about:blank";//reset the iframe location
		        $('#'+fieldId).val(rowData[localPopupOption[fieldId].textColumn]).next('.popup_hidden_Id:eq(0)').val(rowData[localPopupOption[fieldId].valueColumn]);
		        $('#'+fieldId).next().next('.mini-buttonedit-button:eq(0)').hide();
		        $('#'+fieldId).next().next().next('.mini-buttonedit-close:eq(0)').show();
		     };
		     
		     function clearSelection(object,fieldId) {
		    	$(object).hide();
		    	$(object).prev('.mini-buttonedit-button:eq(0)').show();
		    	$('#'+fieldId).val('').next('.popup_hidden_Id:eq(0)').val('');
		     }
		     
		     function openSelection(fieldId,profileId) {
		     	if(localPopupOption[fieldId]) {
			     	var requestUrl=localPopupOption[fieldId].url;
			     	var title=localPopupOption[fieldId].title;
			         $( "#dialog-modal").omDialog({
			         	title:title
			         });
			         $( "#dialog-modal").omDialog('open');
			         var frameLoc=window.frames[0].location;
			         frameLoc.href=requestUrl+"?fieldId="+fieldId+"&profileId="+profileId; 
		         }else {
		         	alert("no such field id.");
		         }
		     }
		     
		    $(function() {
		        $( "#dialog-modal").omDialog({
		            autoOpen: false,
		            width:535,
		            height: 465,
		            modal: true
		        });
		        for(var htmlId in localPopupOption) {
				        $('#'+htmlId).keydown(function(e){
				             if(e.keyCode==118){ //F7
				            	 //var fieldId=$(this).attr('id');
								  //openSelection(fieldId);
				                return false;
				           }else{
				               return false; //forbide any input
				           }
				        });
		        }
		        
		        $( ".mini-buttonedit-button" ).each(function() {
					var value= $(this).prev().prev('.mini-buttonedit-input').val();
					if(value&&value!='') {
						$(this).hide();
						$(this).next().show();
					}
					 
				});
		    });

		   	function addClass(obj,cssClazz) {
		   		$(obj).addClass(cssClazz);
		   	}
		   	function removeClass(obj,cssClazz) {
		   	 $(obj).removeClass(cssClazz);
		   	}
		   	
	 	   return {
	 	   
		 	   "initOption":initOption,
		 	   
		 	   "fillBackAndCloseDialog":fillBackAndCloseDialog,
		 	   
		 	   "clearSelection":clearSelection,
		 	   
		 	   "openSelection":openSelection,
		 	   
		 	   "addClass":addClass,
		 	   
		 	   "removeClass":removeClass
	 	   
	 	   }
	 	
	 	}($))
	 	
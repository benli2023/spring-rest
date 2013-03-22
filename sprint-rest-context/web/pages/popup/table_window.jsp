<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>${pageTitle}</title>
	<%@ include file="../../commons/opera-maskui-import.jsp" %>
</rapid:override>

<rapid:override name="content">
	<style>
        html,body{
            margin: 0;
            padding: 0;
        }
        .treeContainer{
            width: 100%;
            height:100%;
            overflow: auto;
        }
        .toolbar{
            padding: 10px 0;
        }
        #q{
            width: 80px;
        }
    </style>
    <!-- view_source_begin -->
    <script type="text/javascript">
        $(document).ready(function() {
        	var parentFieldId='${fieldId}';
        	var dataUrl='${ctx}${jsonURL}'; 
        	var dataGridId='#userGrid';
        	var searchFieldId="#q";
        	var searchButtonId="#query";
            $(dataGridId).omGrid({
                dataSource : dataUrl+'?q=',
                width : 500,
                height : 300,
                limit : 10, //不分页
                colModel : [ <c:forEach items="${colModelList}" var="current" varStatus="loop">
        	    			   {header: '<c:out value="${current.header}" />',name:'<c:out value="${current.name}" />',width:'<c:out value="${current.width}" />',align:'<c:out value="${current.align}" />' }<c:if test="${!loop.last}">,</c:if>
        					  </c:forEach>
                           ],
                onRowDblClick:function(e, rowData) {
                	  //window.parent.$('#'+parentFieldId).val(rowData.cateName).next('.userIDHidden:eq(0)').val(rowData.cateId);
                      //window.parent.$( "#dialog-modal").omDialog('close');
                      if(window.parent.PopupSelection.fillBackAndCloseDialog) window.parent.PopupSelection.fillBackAndCloseDialog(rowData,parentFieldId);
                }
            });
            $(searchButtonId).omButton({
                onClick:function(e) {
                    $(dataGridId).omGrid("setData", encodeURI(dataUrl+'?searchTerm='+$(searchFieldId).val()));
                }
            });
            
        	function onKeyEnter(event) {
        		var searchOnEnter=true;
        		if(searchOnEnter) {
        			doSearch();
        		}else {
        		var keycode = (event.keyCode ? event.keyCode : event.which);
        		if(keycode == '13'){
        			doSearch();
        		}
        		}
        	}
        	
        	function doSearch() {
        		$(dataGridId).omGrid("setData", encodeURI(dataUrl+'?searchTerm='+$(searchFieldId).val()));
        	}
        	
        	window.onKeyEnter=onKeyEnter;
        });
    </script>
    <table style="width:100%;height:100%">
        <tbody><tr valign="top">
            <td> 
                <div class="toolbar">
			        查询条件(模糊查询)：
			        <input id="q" onkeyup="onKeyEnter(event)" autocomplete="off"/>
			       <input id="query" type="submit" value="查询" />
			    </div>
				<table id="userGrid"></div>
            </td>
        </tr>
    </tbody>
	</table>


</rapid:override>

<%@ include file="../no_head_base.jsp" %>
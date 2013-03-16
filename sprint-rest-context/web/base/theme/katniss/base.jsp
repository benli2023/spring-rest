<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Katniss Premium Admin Template</title>
	<%@ include file="/commons/theme/katniss/meta.jsp" %>
	<base href="<%=basePath%>">
	<rapid:block name="head"/>
</head>
<body>
	
<div class="mainwrapper">
	
	 <!-- START OF LEFT PANEL -->
    <div class="leftpanel">
    	
        <div class="logopanel">
        	<h1><a href="dashboard.html">Katniss <span>v1.0</span></a></h1>
        </div><!--logopanel-->
        
        <div class="datewidget">Today is Tuesday, Dec 25, 2012 5:30pm</div>
    
    	<div class="searchwidget">
        	<form action="results.html" method="post">
            	<div class="input-append">
                    <input type="text" class="span2 search-query" placeholder="Search here...">
                    <button type="submit" class="btn"><span class="icon-search"></span></button>
                </div>
            </form>
        </div><!--searchwidget-->
        
        <!--  
        <div class="plainwidget">
        	<small>Using 16.8 GB of your 51.7 GB </small>
        	<div class="progress progress-info">
                <div class="bar" style="width: 20%"></div>
            </div>
            <small><strong>38% full</strong></small>
        </div> -->
        <!--plainwidget-->
      
        <div class="leftmenu">        
            <ul class="nav nav-tabs nav-stacked">
            	<li class="nav-header">Main Navigation</li>
                <li><a href="dashboard.html"><span class="icon-align-justify"></span> Dashboard</a></li>
                <li><a href="media.html"><span class="icon-picture"></span> Media</a></li>
                <li class="dropdown"><a href=""><span class="icon-briefcase"></span> UI Elements &amp; Widgets</a>
                	<ul>
                    	<li><a href="elements.html">Theme Components</a></li>
                        <li><a href="bootstrap.html">Bootstrap Components</a></li>
                    </ul>
                </li>
                <li class="active dropdown"><a href=""><span class="icon-th-list"></span> Tables</a>
                	<ul style="display:block">
                    	<li><a href="table-static.html">Static Table</a></li>
                        <li><a href="table-dynamic.html">Dynamic Table</a></li>
                    </ul>
                </li>
                <li><a href="typography.html"><span class="icon-font"></span> Typography</a></li>
                <li><a href="charts.html"><span class="icon-signal"></span> Graph &amp; Charts</a></li>
                <li><a href="messages.html"><span class="icon-envelope"></span> Messages</a></li>
                <li><a href="buttons.html"><span class="icon-hand-up"></span> Buttons &amp; Icons</a></li>
                <li class="dropdown"><a href=""><span class="icon-pencil"></span> Forms</a>
                	<ul>
                    	<li><a href="forms.html">Form Styles</a></li>
                        <li><a href="wizards.html">Wizard Form</a></li>
                        <li><a href="wysiwyg.html">WYSIWYG</a></li>
                    </ul>
                </li>
                <li><a href="calendar.html"><span class="icon-calendar"></span> Calendar</a></li>
                <li><a href="animations.html"><span class="icon-play"></span> Animations</a></li>
                <li class="dropdown"><a href=""><span class="icon-book"></span> Other Pages</a>
                	<ul>
                    	<li><a href="404.html">404 Error Page</a></li>
                        <li><a href="invoice.html">Invoice Page</a></li>
                        <li><a href="editprofile.html">Edit Profile</a></li>
                        <li><a href="grid.html">Grid Styles</a></li>
			<li><a href="faq.html">FAQ</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--leftmenu-->
    </div><!--mainleft-->
     <!-- END OF LEFT PANEL -->
    
    
      <!-- START OF RIGHT PANEL -->
    <div class="rightpanel">
    	<div class="headerpanel">
        	<a href="" class="showmenu"></a>
            
            <div class="headerright">
            	<div class="dropdown notification">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="page.html">
                    	<span class="iconsweets-globe iconsweets-white"></span>
                    </a>
                    <ul class="dropdown-menu">
                    	<li class="nav-header">Notifications</li>
                        <li>
                        	<a href="">
                        	<strong>3 people viewed your profile</strong><br />
                            <img src="${ctx}/theme/katniss/img/thumbs/thumb1.png" alt="" />
                            <img src="${ctx}/theme/katniss/img/thumbs/thumb2.png" alt="" />
                            <img src="${ctx}/theme/katniss/img/thumbs/thumb3.png" alt="" />
                            </a>
                        </li>
                        <li><a href=""><span class="icon-envelope"></span> New message from <strong>Jack</strong> <small class="muted"> - 19 hours ago</small></a></li>
                        <li><a href=""><span class="icon-envelope"></span> New message from <strong>Daniel</strong> <small class="muted"> - 2 days ago</small></a></li>
                        <li><a href=""><span class="icon-user"></span> <strong>Bruce</strong> is now following you <small class="muted"> - 2 days ago</small></a></li>
                        <li class="viewmore"><a href="">View More Notifications</a></li>
                    </ul>
                </div><!--dropdown-->
                
    			<div class="dropdown userinfo">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="page.html">Hi, ThemePixels! <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="editprofile.html"><span class="icon-edit"></span> Edit Profile</a></li>
                        <li class="divider"></li>
                        <li><a href=""><span class="icon-wrench"></span> Account Settings</a></li>
                        <li><a href=""><span class="icon-eye-open"></span> Privacy Settings</a></li>
                        <li class="divider"></li>
                        <li><a href="index.html"><span class="icon-off"></span> Sign Out</a></li>
                    </ul>
                </div><!--dropdown-->
    		
            </div><!--headerright-->
            
    	</div><!--headerpanel-->
        <div class="breadcrumbwidget">
        	<ul class="skins">
                <li><a href="default" class="skin-color default"></a></li>
                <li><a href="orange" class="skin-color orange"></a></li>
                <li><a href="dark" class="skin-color dark"></a></li>
                <li>&nbsp;</li>
                <li class="fixed"><a href="" class="skin-layout fixed"></a></li>
                <li class="wide"><a href="" class="skin-layout wide"></a></li>
            </ul><!--skins-->
        	<ul class="breadcrumb">
                <li><a href="dashboard.html">Home</a> <span class="divider">/</span></li>
                <li><a href="table-static.html">Tables</a> <span class="divider">/</span></li>
                <li class="active">Static Table</li>
            </ul>
        </div><!--breadcrumbs-->
        <div class="pagetitle">
        	<h1>Static Table</h1> <span>This is a sample description for the page...</span>
        </div><!--pagetitle-->
    
    	
    	<!-- katniss theme -->
	 <div class="maincontent">
        	<div class="contentinner">
        		<%@ include file="/commons/messages.jsp" %>
    			<rapid:block name="content"/>
    		</div><!--contentinner-->
	 </div><!--maincontent-->
    
    </div><!--mainright-->
    
     <!-- END OF RIGHT PANEL -->
    
    <div class="clearfix"></div>
    
     <div class="footer">
    	<div class="footerleft">Katniss Premium Admin Template v1.0</div>
    	<div class="footerright">&copy; ThemePixels - <a href="http://twitter.com/themepixels">Follow me on Twitter</a> - <a href="http://dribbble.com/themepixels">Follow me on Dribbble</a></div>
    </div><!--footer-->
    
</div><!--mainwrapper-->



	
	
</body>
</html>	
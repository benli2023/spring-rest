<header>
		<div class="container head_s_a">
			<div class="row sepH_b">
				<div class="six columns">
					<div class="row">
                        <div class="five phone-two columns">
							<div id="logo">
								<img src="${ctx}/pertho/img/logo.png" alt="Pertho Admin" />
							</div>
						</div>
						<div class="seven phone-two columns">
							<form action="search.php" id="search_box" method="post">
								<input name="query" id="query" type="text" size="40" placeholder="Find a city..." autocomplete="off" />
							</form>
						</div>
                    </div>
				</div>
				<div class="six columns">
					<div class="user_box cf">
						<div class="user_avatar">
							<img src="${ctx}/pertho/img/user_female.png" alt="" />
						</div>
						<div class="user_info user_sep">
							<p class="sepH_a">
								<strong>Mary Adams</strong>
							</p>
							<span>
								<a href="#" class="sep">Settings</a>
								<a href="index.php">Log out</a>
							</span>
						</div>
						<div class="ntf_bar user_sep">
							<a href="#ntf_mail_panel" class="ntf_item" style="background-image: url(${ctx}/pertho/img/ico/icSw2/32-Mail.png)">
                                <span class="ntf_tip ntf_tip_red"><span>12</span></span>
							</a>
							<a href="#ntf_tickets_panel" class="ntf_item" style="background-image: url(${ctx}/pertho/img/ico/icSw2/32-Day-Calendar.png)">
								<span class="ntf_tip ntf_tip_red"><span>122</span></span>
							</a>
							<a href="#ntf_comments_panel" class="ntf_item" style="background-image: url(${ctx}/pertho/img/ico/icSw2/32-Speech-Bubble.png)">
								<span class="ntf_tip ntf_tip_blue"><span>8</span></span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="twelve columns">
					<nav id="smoothmenu_h" class="ddsmoothmenu tinyNav">
                        <ul class="cf">
    <li><a href="dashboard.html" class="mb_parent first_el ">Dashboard</a></li>
    <li>
        <a href="javascript:void(0)" class="mb_parent">Forms</a>
        <ul style="display:none">
            <li><a href="form_elements.html">Form elements</a></li>
            <li><a href="form_extended.html">Form elements (extended)</a></li>
            <li><a href="form_validation.html">Form validation</a></li>
            <li><a href="form_example.html">Form example</a></li>
        </ul>
    </li>
    <li>
        <a href="javascript:void(0)" class="mb_parent">UI Elements</a>
        <ul style="display:none">
            <li><a href="ui_alertbox_btn_ico_tip.html">Alerts, Buttons, Icons, Tooltips</a></li>
            <li><a href="ui_gallery.html">Gallery</a></li>
            <li><a href="ui_grid.html">Grid</a></li>
            <li><a href="ui_pricingtable.html">Pricing Table</a></li>
            <li><a href="ui_scrollable.html">Scrollable</a></li>
            <li><a href="ui_sidebar.html">Sidebar</a></li>
            <li><a href="ui_tabs.html">Tabs / Accordion</a></li>
            <li><a href="ui_typography.html">Typography</a></li>
            <li><a href="ui_widgets.html">Widgets</a></li>
        </ul>
    </li>
    <li>
        <a href="javascript:void(0)" class="mb_parent">Plugins</a>
        <ul style="display:none">
            <li><a href="plugin_charts.html">Charts</a></li>
            <li><a href="plugin_tables.html">Data tables</a></li>
            <li><a href="plugin_explorer.html">File explorer</a></li>
            <li><a href="plugin_help.html">Help/Faq</a></li>
            <li><a href="plugin_dialogs.html">Dialog boxes/Notifications</a></li>
            <li><a href="plugin_wizard.html">Wizard</a></li>
        </ul>
    </li>
    <li>
        <a href="javascript:void(0)" class="mb_parent">Navigation</a>
        <ul style="display:none">
            <li><a href="nav_sticky.html">Sticky navigation</a></li>
            <li><a href="nav_sidebar.html">Sidebar navigation</a></li>
        </ul>
    </li>
    <li>
        <a href="javascript:void(0)" class="mb_parent">Error Pages</a>
        <ul style="display:none">
            <li><a href="error_401.html">401</a></li>
            <li><a href="error_403.html">403</a></li>
            <li><a href="error_404.html">404</a></li>
            <li><a href="error_500.html">500</a></li>
            <li><a href="error_503.html">503</a></li>
            <li><a href="error_unexpected.html">Unexpected error</a></li>
        </ul>
    </li>
    <li>
        <a href="javascript:void(0)" class="mb_parent">Sub-levels</a>
        <ul style="display:none">
            <li>
                <a href="#">First level</a>
                <ul style="display:none">
                    <li>
                        <a href="#">Second level</a>
                        <ul style="display:none">
                            <li><a href="#">Third level</a></li>
                            <li><a href="#">Third level</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Second level</a></li>
                </ul>
            </li>
            <li><a href="#">First level</a></li>
            <li><a href="#">First level</a></li>
            <li><a href="#">First level</a></li>
        </ul>
    </li>
    <li>
        <a href="documentation.html" class="mb_parent">Documentation</a>
    </li>
</ul>
					</nav>
					<ul id="breadcrumbs" class="cf">
						<li>You are here:</li>
						<li><a href="#">Content</a></li>
						<li><a href="#">Article</a></li>
						<li><span>Lorem Ipsum...</span></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- notifications content -->
		<div style="display:none">
			<div id="ntf_tickets_panel" style="display:none">
				<p class="sticky-title">New Tickets</p>
				<ul class="sticky-list">
					<li>
						<a href="#">Admin should not break if URL...</a>
						<p><span class="s_color small">updated 27.10.2011</span></p>
					</li>
					<li>
						<a href="#">Displaying submenus in custom...</a>
						<p><span class="s_color small">updated 27.10.2011</span></p>
					</li>
					<li>
						<a href="#">Featured image on post types.</a>
						<p><span class="s_color small">updated 26.10.2011</span></p>
					</li>
					<li>
						<a href="#">Multiple feed fixes and...</a>
						<p><span class="s_color small">updated 22.10.2011</span></p>
					</li>
					<li>
						<a href="#">Automatic line breaks in...</a>
						<p><span class="s_color small">updated 14.10.2011</span></p>
					</li>
					<li>
						<a href="#">Wysiwyg bug with shortcodes.</a>
						<p><span class="s_color small">updated 08.10.2011</span></p>
					</li>
				</ul>
				<a href="#" class="gh_button btn-small">Show all tickets</a>
			</div>
			<div id="ntf_comments_panel" style="display:none">
				<p class="sticky-title">New Comments</p>
				<ul class="sticky-list">
					<li>
						<a href="#">Lorem ipsum dolor sit amet...</a>
						<p><span class="s_color small">John Smith on Maiden Castle, Dorset (29.10.2011)</span></p>
					</li>
					<li>
						<a href="#">Lorem ipsum dolor sit...</a>
						<p><span class="s_color small">John Smith on Draining and development... (29.10.2011)</span></p>
					</li>
				</ul>
				<a href="#" class="gh_button btn-small">Show all comments</a>
			</div>
			<div id="ntf_mail_panel" style="display:none">
				<p class="sticky-title">New Messages</p>
				<ul class="sticky-list">
					<li>
						<a href="#">Lorem ipsum dolor sit amet...</a>
						<p><span class="s_color small">From John Smith (29.10.2011)</span></p>
					</li>
					<li>
						<a href="#">Lorem ipsum dolor sit...</a>
						<p><span class="s_color small">From John Smith (28.10.2011)</span></p>
					</li>
				</ul>
				<a href="#" class="gh_button btn-small">Show all messages</a>
			</div>
		</div>
	</header>